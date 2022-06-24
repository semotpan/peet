package com.semo.peet.service.expense.domain;

import com.semo.peet.service.common.Guards;

import java.util.UUID;

public record ExpenseId(UUID value) {

    public ExpenseId {
        Guards.notNull(value, "Value cannot be null.");
    }

    public static ExpenseId valueOf(UUID value) {
        return new ExpenseId(value);
    }

    public static ExpenseId newExpenseId() {
        return new ExpenseId(UUID.randomUUID());
    }
}
