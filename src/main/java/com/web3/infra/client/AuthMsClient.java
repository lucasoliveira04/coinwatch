package com.web3.infra.client;

import com.web3.infra.client.dto.AuthRegisterRequest;
import com.web3.infra.client.dto.AuthRegisterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "auth-ms", url = "${auth-ms.url}")
public interface AuthMsClient {

    @PostMapping("/api/auth/register")
    AuthRegisterResponse register(@RequestBody AuthRegisterRequest request);
}