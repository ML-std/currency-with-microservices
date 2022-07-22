package com.currencymicroservices.currencyexchangeservice.service;

import com.currencymicroservices.currencyexchangeservice.bean.CurrencyExchange;
import com.currencymicroservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository repository;

    public CurrencyExchange findByFromAndTo(String from, String to){
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if (currencyExchange == null){
            throw new RuntimeException("Unable to Find data");
        }
        return currencyExchange;
    }


}
