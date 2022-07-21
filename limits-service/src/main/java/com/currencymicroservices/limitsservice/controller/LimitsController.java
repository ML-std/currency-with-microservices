package com.currencymicroservices.limitsservice.controller;

import com.currencymicroservices.limitsservice.bean.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @GetMapping
    public Limits retrieveLimits(){
        return new Limits(1, 1000);
    }
}
