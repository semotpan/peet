package com.semo.peet.service.income.domain;

import com.semo.peet.service.common.Guards;

import java.time.LocalDate;

public record IncomeDate(LocalDate value) {

    public IncomeDate {
        Guards.notNull(value, "Value cannot be null.");
    }

    public static IncomeDate now() {
        return new IncomeDate(LocalDate.now());
    }

    public static IncomeDate valueOf(LocalDate value) {
        return new IncomeDate(value);
    }
}
