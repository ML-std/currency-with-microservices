package com.currencymicroservices.conversionservice.controller;

import com.currencymicroservices.conversionservice.bean.CurrencyConversion;
import com.currencymicroservices.conversionservice.proxy.CurrencyConversionProxy;
import com.currencymicroservices.conversionservice.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyConversionService currencyConversionService;
    @Autowired
    CurrencyConversionProxy currencyConversionProxy;


    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        Map<String, String> uriVariables =  new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
         ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}" ,CurrencyConversion.class, uriVariables);
         CurrencyConversion currencyConversion = responseEntity.getBody();

         return currencyConversionService.calculateCurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionMultiple(),currencyConversion.getEnvironment());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        CurrencyConversion currencyConversion =currencyConversionProxy.retrieveExchangeValue(from, to);

        return currencyConversionService.calculateCurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionMultiple(),currencyConversion.getEnvironment());
    }


}
