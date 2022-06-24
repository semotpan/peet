package com.semo.peet.service.income.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class IncomeDateTest {

    @Test
    void creation() {

        var date = LocalDate.now();

        assertThat(IncomeDate.valueOf(date))
                .isNotNull()
                .extracting(IncomeDate::value)
                .isEqualTo(date);

        assertThat(IncomeDate.now())
                .isNotNull()
                .extracting(IncomeDate::value)
                .isNotNull();

        assertThat(new IncomeDate(date))
                .isNotNull()
                .extracting(IncomeDate::value)
                .isEqualTo(date);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> IncomeDate.valueOf(null))
                .withMessage("Value cannot be null.");

        assertThatNullPointerException()
                .isThrownBy(() -> new IncomeDate(null))
                .withMessage("Value cannot be null.");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IncomeDate.class)
                .withNonnullFields("value")
                .verify();
    }
}
