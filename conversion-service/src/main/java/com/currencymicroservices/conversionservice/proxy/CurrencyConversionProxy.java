package com.currencymicroservices.conversionservice.proxy;

import com.currencymicroservices.conversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyConversionProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
     CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to );
}
