package com.switchfully.springdi.taxByCountry;

import java.math.BigDecimal;

public class FrenchTaxCalc implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(BigDecimal yearIncome) {
        return yearIncome.multiply(BigDecimal.valueOf(0.48));
    }
}
