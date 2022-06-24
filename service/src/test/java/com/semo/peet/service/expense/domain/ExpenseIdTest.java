package com.semo.peet.service.expense.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class ExpenseIdTest {

    @Test
    void creation() {

        var uuid = UUID.randomUUID();

        assertThat(ExpenseId.valueOf(uuid))
                .isNotNull()
                .extracting(ExpenseId::value)
                .isEqualTo(uuid);

        assertThat(ExpenseId.newExpenseId())
                .isNotNull()
                .extracting(ExpenseId::value)
                .isNotNull();


        assertThat(new ExpenseId(uuid))
                .isNotNull()
                .extracting(ExpenseId::value)
                .isEqualTo(uuid);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> ExpenseId.valueOf(null))
                .withMessage("Value cannot be null.");

        assertThatNullPointerException()
                .isThrownBy(() -> new ExpenseId(null))
                .withMessage("Value cannot be null.");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ExpenseId.class)
                .withNonnullFields("value")
                .verify();
    }
}
