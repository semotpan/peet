package com.semo.peet.service.expense.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class ExpenseTimeTest {

    @Test
    void creation() {

        var time = LocalTime.now();

        assertThat(ExpenseTime.valueOf(time))
                .isNotNull()
                .extracting(ExpenseTime::value)
                .isEqualTo(time);

        assertThat(ExpenseTime.now())
                .isNotNull()
                .extracting(ExpenseTime::value)
                .isNotNull();

        assertThat(new ExpenseTime(time))
                .isNotNull()
                .extracting(ExpenseTime::value)
                .isEqualTo(time);
    }

    @Test
    void creationFailsWhenValueIsNull() {

        assertThatNullPointerException()
                .isThrownBy(() -> ExpenseTime.valueOf(null))
                .withMessage("Value cannot be null.");

        assertThatNullPointerException()
                .isThrownBy(() -> new ExpenseTime(null))
                .withMessage("Value cannot be null.");
    }

    @Test
    public void equalsContract() {

        EqualsVerifier.forClass(ExpenseTime.class)
                .withNonnullFields("value")
                .verify();
    }
}
