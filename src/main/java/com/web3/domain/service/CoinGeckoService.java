package com.web3.domain.service;

import com.web3.infra.properties.CoingeckoProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class CoinGeckoService {

    private final WebClient webClient;
    private final CoingeckoProperties properties;

    public CoinGeckoService(CoingeckoProperties properties) {
        this.properties = properties;
        this.webClient = WebClient.builder()
                .baseUrl(properties.getApi().getUri())
                .defaultHeader("x-cg-demo-api-key", properties.getApi().getKey())
                .build();
    }

    public Mono<Map> getPrice(String coinId, String currency) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/simple/price")
                        .queryParam("ids", coinId)
                        .queryParam("vs_currencies", currency)
                        .build())
                .retrieve()
                .bodyToMono(Map.class);
    }
}
