package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.AmericanTaxCalc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculatorTest {

    @Test
    public void givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        TaxCalculator calculator = new TaxCalculator(new AmericanTaxCalc());
        //WHEN
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal actualResult = calculator.calculateTaxesOnYearIncome(yearSalary).setScale(0, RoundingMode.CEILING);
        BigDecimal expectedResult = BigDecimal.valueOf(8150);
        //THEN
        Assertions.assertEquals(actualResult,expectedResult);
    }
}