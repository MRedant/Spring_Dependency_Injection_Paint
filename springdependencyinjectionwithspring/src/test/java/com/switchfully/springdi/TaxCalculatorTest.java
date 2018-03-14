package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.AmericanTaxCalc;
import com.switchfully.springdi.taxByCountry.TaxCalculation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorTest {

    @Mock
    // = the empty shell of something we rely on in our tests
    private TaxCalculation taxCalculation;

    @InjectMocks
    // = when creating an instance of this class you should inject the mock inhere
    private TaxCalculator taxCalculator;

    @Test
    public void integrationTest_calculateTaxesOnYearIncome_givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        TaxCalculator calculator = new TaxCalculator(new AmericanTaxCalc());
        BigDecimal expectedResult = BigDecimal.valueOf(8150);

        //WHEN
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal actualResult = calculator.calculateTaxesOnYearIncome(yearSalary).setScale(0, RoundingMode.CEILING);

        //THEN
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void unitTest_calculateTaxesOnYearIncome_givenYearSalaryAndCountry_calculateTaxesOnYearIncome() {
        //GIVEN
        BigDecimal yearSalary = BigDecimal.valueOf(40000);
        BigDecimal expectedResult = BigDecimal.valueOf(8150);

        //WHEN
        Mockito.when(taxCalculation.calculateTax(any(BigDecimal.class))).thenReturn(BigDecimal.valueOf(8150));
        BigDecimal actualResult = taxCalculator.calculateTaxesOnYearIncome(yearSalary);

        //THEN
        assertEquals(actualResult, expectedResult);
    }


}