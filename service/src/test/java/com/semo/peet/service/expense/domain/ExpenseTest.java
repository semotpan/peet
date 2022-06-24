package com.semo.peet.service.expense.domain;

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
class ExpenseTest {

    @Test
    void creation() {

        var uuid = UUID.randomUUID();
        var date = LocalDate.now();
        var time = LocalTime.now();
        var text = "Some description";

        assertThat(Expense.builder()
                    .withExpenseId(ExpenseId.valueOf(uuid))
                    .withAmount(Money.valueOf(BigDecimal.TEN))
                    .withExpenseCategory(ExpenseCategory.CLOTHING)
                    .withPaymentType(PaymentType.BANK)
                    .withExpenseDate(ExpenseDate.valueOf(date))
                    .withExpenseTime(ExpenseTime.valueOf(time))
                    .withDescription(new Description(text))
                    .build())
                .isNotNull()
                .extracting(
                        Expense::getExpenseId,
                        Expense::getAmount,
                        Expense::getExpenseCategory,
                        Expense::getPaymentType,
                        Expense::getExpenseDate,
                        Expense::getExpenseTime,
                        Expense::getDescription
                )
                .containsExactly(
                        ExpenseId.valueOf(uuid),
                        Money.valueOf(BigDecimal.TEN),
                        ExpenseCategory.CLOTHING,
                        PaymentType.BANK,
                        ExpenseDate.valueOf(date),
                        ExpenseTime.valueOf(time),
                        new Description(text)
                );
    }

    @Test
    void creationFailsWhenExpenseIdIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Expense.builder()
                        .build())
                .withMessage("Expense Id cannot be null.");
    }

    @Test
    void creationFailsWhenAmountIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Expense.builder()
                        .withExpenseId(ExpenseId.newExpenseId())
                        .build())
                .withMessage("Amount cannot be null.");
    }

    @Test
    void creationFailsWhenExpenseCategoryIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Expense.builder()
                        .withExpenseId(ExpenseId.newExpenseId())
                        .withAmount(Money.newZeroValue())
                        .build())
                .withMessage("Expense Category cannot be null.");
    }

    @Test
    void creationFailsWhenExpenseDateIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Expense.builder()
                        .withExpenseId(ExpenseId.newExpenseId())
                        .withAmount(Money.newZeroValue())
                        .withExpenseCategory(ExpenseCategory.FOOD)
                        .build())
                .withMessage("Expense Date cannot be null.");
    }

    @Test
    void creationFailsWhenExpenseTimeIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Expense.builder()
                        .withExpenseId(ExpenseId.newExpenseId())
                        .withAmount(Money.newZeroValue())
                        .withExpenseCategory(ExpenseCategory.FOOD)
                        .withExpenseDate(ExpenseDate.now())
                        .build())
                .withMessage("Expense Time cannot be null.");
    }

    @Test
    void creationFailsWhenPaymentTypeIsNull() {
        assertThatNullPointerException()
                .isThrownBy(() -> Expense.builder()
                        .withExpenseId(ExpenseId.newExpenseId())
                        .withAmount(Money.newZeroValue())
                        .withExpenseCategory(ExpenseCategory.FOOD)
                        .withExpenseDate(ExpenseDate.now())
                        .withExpenseTime(ExpenseTime.now())
                        .build())
                .withMessage("Payment Type cannot be null.");
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Expense.class)
                .suppress(Warning.ALL_FIELDS_SHOULD_BE_USED)
                .verify();
    }
}
