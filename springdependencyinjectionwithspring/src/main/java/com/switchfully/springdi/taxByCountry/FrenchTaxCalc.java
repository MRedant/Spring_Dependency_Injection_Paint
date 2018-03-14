package com.switchfully.springdi.taxByCountry;

import javax.inject.Named;
import java.math.BigDecimal;

@Named("FrenchTax")
public class FrenchTaxCalc implements TaxCalculation {

    @Override
    public BigDecimal calculateTax(BigDecimal yearIncome) {
        return yearIncome.multiply(BigDecimal.valueOf(0.48));
    }
}
