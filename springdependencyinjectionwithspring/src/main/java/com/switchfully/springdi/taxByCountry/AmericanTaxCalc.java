package com.switchfully.springdi.taxByCountry;

import org.springframework.context.annotation.Primary;

import javax.inject.Named;
import java.math.BigDecimal;

@Named("AmericanTax")
public class AmericanTaxCalc implements TaxCalculation {

    @Override
    @Primary
    public BigDecimal calculateTax(BigDecimal yearIncome) {
        return yearIncome.multiply(BigDecimal.valueOf(0.18)).add(BigDecimal.valueOf(950));
    }
}
