package com.web3.domain.service;

import com.web3.domain.service.dto.CoinPriceResponse;
import com.web3.infra.properties.CoingeckoProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CoinGeckoService {

    private final RestClient restClient;

    public CoinGeckoService(CoingeckoProperties properties) {
        this.restClient = RestClient.builder()
                .baseUrl(properties.getApi().getUri())
                .defaultHeader("x-cg-demo-api-key", properties.getApi().getKey())
                .build();
    }

    public CoinPriceResponse getPrice(String coinId, String currency) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/simple/price")
                        .queryParam("ids", coinId)
                        .queryParam("vs_currencies", currency)
                        .build())
                .retrieve()
                .body(CoinPriceResponse.class);
    }
}