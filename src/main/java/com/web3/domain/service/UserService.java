package com.web3.domain.service;

import com.web3.domain.dto.UserCreateRequest;
import com.web3.domain.dto.UserResponse;
import com.web3.domain.entity.UserEntity;
import com.web3.domain.repository.UserRepository;
import com.web3.infra.client.AuthMsClient;
import com.web3.infra.client.dto.AuthRegisterRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthMsClient authMsClient;

    @Transactional
    public UserResponse createUser(UserCreateRequest request) {
        UserEntity user = UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        UserEntity saved = userRepository.save(user);

        authMsClient.register(new AuthRegisterRequest(saved.getEmail(), request.password(), saved.getGuid()));

        return new UserResponse(
                saved.getGuid(),
                saved.getName(),
                saved.getEmail(),
                saved.getCreationDate()
        );
    }
}
