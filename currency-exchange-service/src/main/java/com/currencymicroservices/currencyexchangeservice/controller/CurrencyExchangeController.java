package com.currencymicroservices.currencyexchangeservice.controller;

import com.currencymicroservices.currencyexchangeservice.bean.CurrencyExchange;
import com.currencymicroservices.currencyexchangeservice.service.CurrencyExchangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeServiceImpl currencyExchangeServiceImpl = new CurrencyExchangeServiceImpl();

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to ){
        CurrencyExchange currencyExchange = currencyExchangeServiceImpl.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;

    }

}
