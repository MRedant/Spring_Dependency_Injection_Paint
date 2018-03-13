package com.switchfully.springdi.taxByCountry;

import java.math.BigDecimal;

public class AmericanTaxCalc implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(BigDecimal yearIncome) {
        return yearIncome.multiply(BigDecimal.valueOf(0.18)).add(BigDecimal.valueOf(950));
    }
}
