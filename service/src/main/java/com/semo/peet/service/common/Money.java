package com.semo.peet.service.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

@EqualsAndHashCode
@ToString
@Getter
public final class Money {

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        Guards.notNull(amount, "Amount cannot be null.");
        Guards.notNegative(amount, "Amount cannot be negative.");
        this.amount = amount;
    }

    public Money plus(Money money) {
        return Money.valueOf(this.amount.add(money.amount));
    }

    public Money minus(Money money) {
        return Money.valueOf(this.amount.subtract(money.amount));
    }

    public static Money valueOf(BigDecimal amount) {
        return new Money(amount);
    }

    public static Money newZeroValue() {
        return new Money(ZERO);
    }

    public static Money add(Money valueOne, Money valueTwo) {
        return Money.valueOf(valueOne.amount.add(valueTwo.amount));
    }

    public static Money subtract(Money valueOne, Money valueTwo) {
        return Money.valueOf(valueOne.amount.subtract(valueTwo.amount));
    }
}
