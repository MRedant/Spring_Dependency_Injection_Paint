package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.AmericanTaxCalc;
import com.switchfully.springdi.taxByCountry.TaxCalculation;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;


public class TaxCalculatorTest {

    @Test
    public void integrationTest_calculateTaxesOnYearIncome_givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        TaxCalculator calculator = new TaxCalculator(new AmericanTaxCalc());
        BigDecimal expectedResult = BigDecimal.valueOf(8150);

        //WHEN
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal actualResult = calculator.calculateTaxesOnYearIncome(yearSalary)
                .setScale(0, RoundingMode.CEILING);

        //THEN
        assertEquals(actualResult,expectedResult);
    }
    @Test
    public void unitTest_calculateTaxesOnYearIncome_givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        TaxCalculation americanTaxCalculation = Mockito.mock(AmericanTaxCalc.class);
        TaxCalculator calculator = new TaxCalculator(americanTaxCalculation);
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal expectedResult = BigDecimal.valueOf(8150);

        //WHEN
        Mockito.when(americanTaxCalculation.calculateTax(any())).thenReturn(BigDecimal.valueOf(8150));
        BigDecimal actualResult = calculator.calculateTaxesOnYearIncome(yearSalary);

        //THEN
        Mockito.verify(americanTaxCalculation,new Times(1)).calculateTax(any());
        assertEquals(actualResult,expectedResult);
    }



}