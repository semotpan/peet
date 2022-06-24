package com.semo.peet.service.expense.domain;

import com.semo.peet.service.common.Guards;

import java.time.LocalTime;

public record ExpenseTime(LocalTime value) {

    public ExpenseTime {
        Guards.notNull(value, "Value cannot be null.");
    }

    public static ExpenseTime now() {
        return new ExpenseTime(LocalTime.now());
    }

    public static ExpenseTime valueOf(LocalTime value) {
        return new ExpenseTime(value);
    }
}
