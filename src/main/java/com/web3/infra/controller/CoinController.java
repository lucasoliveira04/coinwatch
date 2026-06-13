package com.web3.infra.controller;

import com.web3.domain.service.CoinGeckoService;
import com.web3.domain.service.dto.CoinPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coin")
@RequiredArgsConstructor
public class CoinController {
    private final CoinGeckoService coinGeckoService;

    @GetMapping("/price/{coinId}")
    public CoinPriceResponse getPrice(@PathVariable String coinId,
                                            @RequestParam(defaultValue = "usd") String currency) {
        return coinGeckoService.getPrice(coinId, currency);
    }
}
