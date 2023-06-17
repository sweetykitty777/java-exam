package org.java.exam.service;

import org.apache.hadoop.yarn.webapp.NotFoundException;
import org.java.exam.model.Exchange;
import org.java.exam.model.Rate;
import org.java.exam.repository.RateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {
    private final RateRepository rateRepository;


    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    public Rate createRate(Rate rate) {
        String baseCurrency = rate.getBaseCurrency();
        String targetCurrency = rate.getTargetCurrency();

        if (rateRepository.findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency) != null) {
            throw new IllegalArgumentException("Такая пара уже существует, используйте updateRate");
        }
        return rateRepository.save(rate);
    }

    public double getRate(Exchange exchange) {
        if (rateRepository.findByBaseCurrencyAndTargetCurrency(exchange.getBaseCurrency(),
                exchange.getTargetCurrency()) != null) {
            return rateRepository.findByBaseCurrencyAndTargetCurrency(exchange.getBaseCurrency(),
                    exchange.getTargetCurrency()).getExchangeRate();
        }
        throw new NotFoundException("Такой пары не существует");
    }

    public Rate getRateById(Long id) {
        return rateRepository.findById(id).orElseThrow(() -> new NotFoundException("Rate not found"));
    }

    public Rate updateRate(Long id, Rate updatedRate) {
        Rate rate = rateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rate not found"));
        if (updatedRate.getTargetCurrency() == null || updatedRate.getTargetCurrency().isEmpty()) {
            throw new IllegalArgumentException("Invalid target currency");
        }
        if (updatedRate.getBaseCurrency() == null || updatedRate.getBaseCurrency().isEmpty()) {
            throw new IllegalArgumentException("Invalid base currency");
        }
        rate.setTargetCurrency(updatedRate.getTargetCurrency());
        return rateRepository.saveAndFlush(rate);
    }
    public void deleteRate(Long id) {
        rateRepository.deleteById(id);
    }
}