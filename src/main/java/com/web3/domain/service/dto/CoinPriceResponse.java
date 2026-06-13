package com.web3.domain.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.util.Map;

public record CoinPriceResponse(Map<String, Map<String, Double>> price) implements Serializable {

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CoinPriceResponse {
    }
}