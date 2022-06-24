package com.semo.peet.service.income.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class IncomeTimeTest {

    @Test
    void creation() {

        var time = LocalTime.now();

        assertThat(IncomeTime.valueOf(time))
                .isNotNull()
                .extracting(IncomeTime::value)
                .isEqualTo(time);

        assertThat(IncomeTime.now())
                .isNotNull()
                .extracting(IncomeTime::value)
                .isNotNull();

        assertThat(new IncomeTime(time))
                .isNotNull()
                .extracting(IncomeTime::value)
                .isEqualTo(time);
    }

    @Test
    void creationFailsWhenValueIsNull() {

        assertThatNullPointerException()
                .isThrownBy(() -> IncomeTime.valueOf(null))
                .withMessage("Value cannot be null.");

        assertThatNullPointerException()
                .isThrownBy(() -> new IncomeTime(null))
                .withMessage("Value cannot be null.");
    }

    @Test
    public void equalsContract() {

        EqualsVerifier.forClass(IncomeTime.class)
                .withNonnullFields("value")
                .verify();
    }
}
