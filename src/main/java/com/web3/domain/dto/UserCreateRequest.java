package com.web3.domain.dto;

public record UserCreateRequest(
        String name,
        String email,
        String password
) {
}

