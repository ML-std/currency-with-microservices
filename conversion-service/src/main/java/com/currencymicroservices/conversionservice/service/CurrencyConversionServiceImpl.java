package com.currencymicroservices.conversionservice.service;

import com.currencymicroservices.conversionservice.bean.CurrencyConversion;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    @Override
    public CurrencyConversion calculateCurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiplier, String environment) {

        CurrencyConversion currencyConversion = new CurrencyConversion(id, from, to, quantity, conversionMultiplier, environment);
        currencyConversion.setTotalCalculatedAmount(currencyConversion.getQuantity().multiply(currencyConversion.getConversionMultiple()));
        return currencyConversion;
    }
}
