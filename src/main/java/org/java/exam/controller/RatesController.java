package org.java.exam.controller;

import org.java.exam.model.Rate;
import org.java.exam.service.RateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RatesController {
    public final RateService rateService;
    public RatesController(RateService rateService) {
        this.rateService = rateService;
    }
    @GetMapping
    public List<Rate> getAllRates() {
        return rateService.getAllRates();
    }

    @PostMapping
    public Rate createRate(@RequestBody Rate rate) {
        return rateService.createRate(rate);
    }

    @GetMapping("/{id}")
    public Rate getRateById(@PathVariable("id") Long id) {
        return rateService.getRateById(id);
    }

    @PutMapping("/{id}")
    public Rate updateRate(@PathVariable("id") Long id, @RequestBody Rate rate) {
        return rateService.updateRate(id, rate);
    }
    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable("id") Long id) {
        rateService.deleteRate(id);
    }
}