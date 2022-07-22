package com.currencymicroservices.conversionservice.service;

import com.currencymicroservices.conversionservice.bean.CurrencyConversion;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CurrencyConversionService {
    CurrencyConversion calculateCurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal  conversionMultiple, String environment);
}
