package com.currencymicroservices.currencyexchangeservice.service;

import com.currencymicroservices.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange findByFromAndTo(String from, String to);
}
