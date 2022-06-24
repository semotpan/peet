package com.semo.peet.service.income.domain;

import com.semo.peet.service.common.Guards;

public enum IncomeSource {

    SALARY("Salary"),
    LOAN("Loan"),
    BUSINESS("Business");

    private final String value;

    IncomeSource(String value) {
        Guards.notNull(value, "Value cannot be null.");
        Guards.notBlank(value, "Value cannot be blank.");

        this.value = value;
    }

    public String value() {
        return value;
    }
}
