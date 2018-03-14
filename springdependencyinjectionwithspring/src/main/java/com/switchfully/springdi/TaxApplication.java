package com.switchfully.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;

// folder in which he is going to look for files to manage
@ComponentScan (basePackages = {"com.switchfully.springdi"})
public class TaxApplication {
    public static void main(String[] args) {

        //use annotations in this class and manage it by an dependency injection:
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaxApplication.class);
        //get the implementation that has to be injected
        TaxCalculator taxCalculator = context.getBean(TaxCalculator.class);

        System.out.println(taxCalculator.calculateTaxesOnYearIncome(new BigDecimal(20000)));
    }
}
