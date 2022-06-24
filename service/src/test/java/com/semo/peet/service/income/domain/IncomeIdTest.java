package com.semo.peet.service.income.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class IncomeIdTest {

    @Test
    void creation() {

        var uuid = UUID.randomUUID();

        assertThat(IncomeId.valueOf(uuid))
                .isNotNull()
                .extracting(IncomeId::value)
                .isEqualTo(uuid);

        assertThat(IncomeId.newIncomeId())
                .isNotNull()
                .extracting(IncomeId::value)
                .isNotNull();


        assertThat(new IncomeId(uuid))
                .isNotNull()
                .extracting(IncomeId::value)
                .isEqualTo(uuid);
    }

    @Test
    void creationFailsWhenValueIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> IncomeId.valueOf(null))
                .withMessage("Value cannot be null.");

        assertThatNullPointerException()
                .isThrownBy(() -> new IncomeId(null))
                .withMessage("Value cannot be null.");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(IncomeId.class)
                .withNonnullFields("value")
                .verify();
    }
}
