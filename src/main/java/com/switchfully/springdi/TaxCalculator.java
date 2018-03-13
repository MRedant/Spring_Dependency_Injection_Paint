package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.TaxCalculation;

import java.math.BigDecimal;

public class TaxCalculator {

    private TaxCalculation taxCalculation;

    public TaxCalculator(TaxCalculation taxCalculation) {
        this.taxCalculation = taxCalculation;
    }

    public BigDecimal calculateTaxesOnYearIncome(BigDecimal yearIncome) {
        return taxCalculation.calculateTax(yearIncome);
    }

}
