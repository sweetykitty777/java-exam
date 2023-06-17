package org.java.exam.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Поля обязательны для заполнения")
    private String baseCurrency;
    @NotBlank(message = "Поля обязательны для заполнения")
    private String targetCurrency;
    private double cash;

    public Exchange(String baseCurrency, String targetCurrency, double cash) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.cash = cash;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getCash() {
        return cash;
    }

    public void setExchangeRate(double exchangeRate) {
        this.cash = cash;
    }
}


