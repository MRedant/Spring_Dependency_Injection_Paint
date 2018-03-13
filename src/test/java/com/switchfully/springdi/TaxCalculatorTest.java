package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.AmericanTaxCalc;
import com.switchfully.springdi.taxByCountry.TaxCalculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.mockito.ArgumentMatchers.any;

public class TaxCalculatorTest {

    @Test
    public void integrationTest_calculateTaxesOnYearIncome_givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        TaxCalculator calculator = new TaxCalculator(new AmericanTaxCalc());
        BigDecimal expectedResult = BigDecimal.valueOf(8150);

        //WHEN
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal actualResult = calculator.calculateTaxesOnYearIncome(yearSalary).setScale(0, RoundingMode.CEILING);

        //THEN
        Assertions.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void unitTest_calculateTaxesOnYearIncome_givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        TaxCalculation taxCalculation = Mockito.mock(AmericanTaxCalc.class);
        TaxCalculator calculator = new TaxCalculator(taxCalculation);
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal expectedResult = BigDecimal.valueOf(8150);

        //WHEN
        Mockito.when(taxCalculation.calculateTax(any())).thenReturn(BigDecimal.valueOf(8150));
        BigDecimal actualResult = calculator.calculateTaxesOnYearIncome(yearSalary);

        //THEN
        Mockito.verify(taxCalculation,new Times(1)).calculateTax(any());
        Assertions.assertEquals(actualResult,expectedResult);
    }



}