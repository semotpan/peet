package com.semo.peet.service.income.domain;

import com.semo.peet.service.common.Guards;

import java.util.UUID;

public record IncomeId(UUID value) {

    public IncomeId {
        Guards.notNull(value, "Value cannot be null.");
    }

    public static IncomeId valueOf(UUID value) {
        return new IncomeId(value);
    }

    public static IncomeId newIncomeId() {
        return new IncomeId(UUID.randomUUID());
    }

}
