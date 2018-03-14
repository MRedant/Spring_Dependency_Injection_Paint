package com.switchfully.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;

// folder in which he is going to look for files to manage
@ComponentScan (basePackages = {"com.switchfully.springdi"})
public class TaxApplication {
    public static void main(String[] args) {

          //old way without Spring
//        BigDecimal yearIncome = new BigDecimal(40000);
//        TaxCalculator taxCalculator = new TaxCalculator(new AmericanTaxCalc());
//        BigDecimal tax = taxCalculator.calculateTaxesOnYearIncome(yearIncome);
//        System.out.println(tax);

        //use annotations in this class and manage it by an dependency injection:
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaxApplication.class);
        //get the implementation that has to be injected
        TaxCalculator taxCalculator = context.getBean(TaxCalculator.class);

        System.out.println(taxCalculator.calculateTaxesOnYearIncome(new BigDecimal(20000)));
    }
}
