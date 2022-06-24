package com.semo.peet.service.common;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static org.assertj.core.api.Assertions.*;

@Tag("unit")
class MoneyTest {

    @Test
    void creation() {
        assertThat(Money.newZeroValue())
                .isNotNull()
                .extracting(Money::getAmount)
                .isEqualTo(ZERO);


        assertThat(Money.valueOf(TEN))
                .isNotNull()
                .extracting(Money::getAmount)
                .isEqualTo(TEN);
    }

    @Test
    void creationFailsWhenAmountIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Money.valueOf(null))
                .withMessage("Amount cannot be null.");

    }

    @Test
    void creationFailsWhenAmountIsNegative() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.valueOf(BigDecimal.valueOf(-10L)))
                .withMessage("Amount cannot be negative.");

    }

    @Test
    void addingToExistingAmountAndGetNewInstance() {

        var money = Money.valueOf(TEN);
        var result = money.plus(Money.valueOf(ONE));

        assertThat(result)
                .isNotNull()
                .extracting(Money::getAmount)
                .isEqualTo(BigDecimal.valueOf(11L));

        assertThat(result)
                .isNotEqualTo(money);
    }

    @Test
    void subtractingFromExistingAmountAndGetNewInstance() {

        var money = Money.valueOf(TEN);
        var result = money.minus(Money.valueOf(ONE));

        assertThat(result)
                .isNotNull()
                .extracting(Money::getAmount)
                .isEqualTo(BigDecimal.valueOf(9L));

        assertThat(result)
                .isNotEqualTo(money);
    }

    @Test
    void addingTwoMoneyObjects() {

        var valueOne = Money.valueOf(TEN);
        var valueTwo = Money.valueOf(ONE);

        var result = Money.add(valueOne, valueTwo);

        assertThat(result)
                .isNotNull()
                .extracting(Money::getAmount)
                .isEqualTo(BigDecimal.valueOf(11L));
    }

    @Test
    void subtractingTwoMoneyObjects() {

        var valueOne = Money.valueOf(TEN);
        var valueTwo = Money.valueOf(ONE);

        var result = Money.subtract(valueOne, valueTwo);

        assertThat(result)
                .isNotNull()
                .extracting(Money::getAmount)
                .isEqualTo(BigDecimal.valueOf(9L));
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Money.class)
                .suppress(Warning.BIGDECIMAL_EQUALITY)
                .verify();
    }

}
