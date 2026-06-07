package com.web3.infra.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("coingecko")
@Getter @Setter
public class CoingeckoProperties {

    private Api api = new Api();

    @Getter @Setter
    public static class Api {
        private String key;
        private String uri;
    }

}
