package com.semo.peet.service.income.domain;

import com.semo.peet.service.common.Description;
import com.semo.peet.service.common.Money;
import com.semo.peet.service.common.PaymentType;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@Tag("unit")
class IncomeTest {

    @Test
    void creation() {

        var uuid = UUID.randomUUID();
        var date = LocalDate.now();
        var time = LocalTime.now();
        var text = "Some description";

        assertThat(Income.builder()
                    .withIncomeId(IncomeId.valueOf(uuid))
                    .withAmount(Money.valueOf(BigDecimal.TEN))
                    .withIncomeSource(IncomeSource.BUSINESS)
                    .withPaymentType(PaymentType.BANK)
                    .withIncomeDate(IncomeDate.valueOf(date))
                    .withIncomeTime(IncomeTime.valueOf(time))
                    .withDescription(new Description(text))
                    .build())
                .isNotNull()
                .extracting(
                        Income::getIncomeId,
                        Income::getAmount,
                        Income::getIncomeSource,
                        Income::getPaymentType,
                        Income::getIncomeDate,
                        Income::getIncomeTime,
                        Income::getDescription
                )
                .containsExactly(
                        IncomeId.valueOf(uuid),
                        Money.valueOf(BigDecimal.TEN),
                        IncomeSource.BUSINESS,
                        PaymentType.BANK,
                        IncomeDate.valueOf(date),
                        IncomeTime.valueOf(time),
                        new Description(text)
                );
    }

    @Test
    void creationFailsWhenIncomeIdIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Income.builder()
                        .build())
                .withMessage("Income Id cannot be null.");
    }

    @Test
    void creationFailsWhenAmountIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Income.builder()
                        .withIncomeId(IncomeId.newIncomeId())
                        .build())
                .withMessage("Amount cannot be null.");
    }

    @Test
    void creationFailsWhenIncomeSourceIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Income.builder()
                        .withIncomeId(IncomeId.newIncomeId())
                        .withAmount(Money.newZeroValue())
                        .build())
                .withMessage("Income Source cannot be null.");
    }

    @Test
    void creationFailsWhenIncomeDateIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Income.builder()
                        .withIncomeId(IncomeId.newIncomeId())
                        .withAmount(Money.newZeroValue())
                        .withIncomeSource(IncomeSource.LOAN)
                        .build())
                .withMessage("Income Date cannot be null.");
    }

    @Test
    void creationFailsWhenIncomeTimeIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Income.builder()
                        .withIncomeId(IncomeId.newIncomeId())
                        .withAmount(Money.newZeroValue())
                        .withIncomeSource(IncomeSource.SALARY)
                        .withIncomeDate(IncomeDate.now())
                        .build())
                .withMessage("Income Time cannot be null.");
    }

    @Test
    void creationFailsWhenPaymentTypeIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Income.builder()
                        .withIncomeId(IncomeId.newIncomeId())
                        .withAmount(Money.newZeroValue())
                        .withIncomeSource(IncomeSource.SALARY)
                        .withIncomeDate(IncomeDate.now())
                        .withIncomeTime(IncomeTime.now())
                        .build())
                .withMessage("Payment Type cannot be null.");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Income.class)
                .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
                .verify();
    }
}
