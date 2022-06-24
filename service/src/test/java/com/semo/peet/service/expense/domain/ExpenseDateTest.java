package com.semo.peet.service.expense.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class ExpenseDateTest {

    @Test
    void creation() {

        var date = LocalDate.now();

        assertThat(ExpenseDate.valueOf(date))
                .isNotNull()
                .extracting(ExpenseDate::value)
                .isEqualTo(date);

        assertThat(ExpenseDate.now())
                .isNotNull()
                .extracting(ExpenseDate::value)
                .isNotNull();

        assertThat(new ExpenseDate(date))
                .isNotNull()
                .extracting(ExpenseDate::value)
                .isEqualTo(date);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> ExpenseDate.valueOf(null))
                .withMessage("Value cannot be null.");

        assertThatNullPointerException()
                .isThrownBy(() -> new ExpenseDate(null))
                .withMessage("Value cannot be null.");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ExpenseDate.class)
                .withNonnullFields("value")
                .verify();
    }
}
