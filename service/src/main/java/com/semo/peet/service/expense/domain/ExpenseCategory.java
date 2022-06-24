package com.semo.peet.service.expense.domain;

import com.semo.peet.service.common.Guards;

public enum ExpenseCategory {

    CLOTHING("Clothing"),
    DRINKS("Drinks"),
    EDUCATION("Education"),
    FOOD("Food"),
    FUEL("Fuel"),
    FUN("Fun"),
    HOSPITAL("Hospital"),
    TRAVEL("Travel"),
    MEDICAL("Medical"),
    PERSONAL("Personal"),
    TRANSPORT("Transport"),
    OTHER("Other");

    private final String value;

    ExpenseCategory(String value) {
        Guards.notNull(value, "Value cannot be null.");
        this.value = value;
    }

    public String value() {
        return value;
    }
}
