package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.TaxCalculation;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class TaxCalculator {

    private TaxCalculation taxCalculation;

    @Inject
    public TaxCalculator(TaxCalculation taxCalculation) {
        this.taxCalculation = taxCalculation;
    }

    public BigDecimal calculateTaxesOnYearIncome(BigDecimal yearIncome) {
        return taxCalculation.calculateTax(yearIncome);
    }

}
