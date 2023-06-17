package org.java.exam.controller;

import org.java.exam.model.Exchange;
import org.java.exam.model.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    private final RatesController ratesController;

    @Autowired
    public ExchangeController(RatesController ratesController) {
        this.ratesController = ratesController;
    }

    @PostMapping
    public double getResult(@RequestBody Exchange exchange) {
        return exchange.getCash() * ratesController.rateService.getRate(exchange);
    }

}
