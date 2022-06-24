package com.semo.peet.service.expense.domain;

import com.semo.peet.service.common.Guards;

import java.time.LocalDate;

public record ExpenseDate(LocalDate value) {

    public ExpenseDate {
        Guards.notNull(value, "Value cannot be null.");
    }

    public static ExpenseDate now() {
        return new ExpenseDate(LocalDate.now());
    }

    public static ExpenseDate valueOf(LocalDate value) {
        return new ExpenseDate(value);
    }
}
