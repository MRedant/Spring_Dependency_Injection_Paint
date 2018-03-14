package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.AmericanTaxCalc;

import java.math.BigDecimal;

public class TaxApplication {

    public static void main(String[] args) {

        BigDecimal yearIncome = new BigDecimal(40000);
        TaxCalculator taxCalculator = new TaxCalculator(new AmericanTaxCalc());
        BigDecimal tax = taxCalculator.calculateTaxesOnYearIncome(yearIncome);
        System.out.println(tax);

    }
}
