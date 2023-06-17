package org.java.exam.repository;

import org.java.exam.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query("SELECT r FROM Rate r WHERE r.baseCurrency = :baseCurrency AND r.targetCurrency = :targetCurrency")
    Rate findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
}

