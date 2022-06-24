package com.semo.peet.service.income.domain;

import com.semo.peet.service.common.Guards;

import java.time.LocalTime;

public record IncomeTime(LocalTime value) {

    public IncomeTime {
        Guards.notNull(value, "Value cannot be null.");
    }

    public static IncomeTime now() {
        return new IncomeTime(LocalTime.now());
    }

    public static IncomeTime valueOf(LocalTime value) {
        return new IncomeTime(value);
    }
}
