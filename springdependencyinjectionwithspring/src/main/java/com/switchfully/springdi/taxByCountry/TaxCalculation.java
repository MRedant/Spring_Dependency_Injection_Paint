package com.switchfully.springdi.taxByCountry;

import java.math.BigDecimal;

public interface TaxCalculation {

    BigDecimal calculateTax(BigDecimal yearIncome);

}
