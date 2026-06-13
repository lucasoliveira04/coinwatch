package com.web3.domain.dto;

import java.time.LocalDateTime;

public record UserResponse(
        String guid,
        String name,
        String email,
        LocalDateTime creationDate
) {
}
