package com.switchfully.springdi.taxByCountry;

import java.math.BigDecimal;

public class BelgianTaxCalc implements TaxCalculation {

    public BigDecimal calculateTax(BigDecimal yearIncome) {
        return yearIncome.multiply(BigDecimal.valueOf(0.45));
    }
}