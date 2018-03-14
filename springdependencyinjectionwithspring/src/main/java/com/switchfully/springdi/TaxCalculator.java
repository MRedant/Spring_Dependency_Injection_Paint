package com.switchfully.springdi;

import com.switchfully.springdi.taxByCountry.TaxCalculation;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class TaxCalculator {

    private TaxCalculation taxCalculation;

    // inject the bean here (and use the one specified in the qualifier) (or use a primary-one and leave out the Qualifier
    @Inject
    public TaxCalculator(@Qualifier("BelgianTax") TaxCalculation taxCalculation) {
        this.taxCalculation = taxCalculation;
    }

    public BigDecimal calculateTaxesOnYearIncome(BigDecimal yearIncome) {
        return taxCalculation.calculateTax(yearIncome);
    }

}
