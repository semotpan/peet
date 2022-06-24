package com.semo.peet.service.expense.domain;

import com.semo.peet.service.common.Description;
import com.semo.peet.service.common.Guards;
import com.semo.peet.service.common.Money;
import com.semo.peet.service.common.PaymentType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(of = {"expenseId", "amount"})
public final class Expense {

    private final ExpenseId expenseId;
    private final Money amount;
    private final ExpenseCategory expenseCategory;
    private final ExpenseDate expenseDate;
    private final ExpenseTime expenseTime;
    private final Description description;
    private final PaymentType paymentType;

    private Expense(Builder builder) {

        Guards.notNull(builder.expenseId, "Expense Id cannot be null.");
        Guards.notNull(builder.amount, "Amount cannot be null.");
        Guards.notNull(builder.expenseCategory, "Expense Category cannot be null.");
        Guards.notNull(builder.expenseDate, "Expense Date cannot be null.");
        Guards.notNull(builder.expenseTime, "Expense Time cannot be null.");
        Guards.notNull(builder.paymentType, "Payment Type cannot be null.");

        this.expenseId = builder.expenseId;
        this.amount = builder.amount;
        this.expenseCategory = builder.expenseCategory;
        this.expenseDate = builder.expenseDate;
        this.expenseTime = builder.expenseTime;
        this.paymentType = builder.paymentType;
        this.description = builder.description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private ExpenseId expenseId;
        private Money amount;
        private ExpenseCategory expenseCategory;
        private ExpenseDate expenseDate;
        private ExpenseTime expenseTime;
        private Description description;
        private PaymentType paymentType;

        private Builder() {
        }

        public Builder withExpenseId(ExpenseId expenseId) {
            this.expenseId = expenseId;
            return this;
        }

        public Builder withExpenseCategory(ExpenseCategory expenseCategory) {
            this.expenseCategory = expenseCategory;
            return this;
        }

        public Builder withAmount(Money amount) {
            this.amount = amount;
            return this;
        }

        public Builder withExpenseDate(ExpenseDate expenseDate) {
            this.expenseDate = expenseDate;
            return this;
        }

        public Builder withExpenseTime(ExpenseTime expenseTime) {
            this.expenseTime = expenseTime;
            return this;
        }

        public Builder withDescription(Description description) {
            this.description = description;
            return this;
        }

        public Builder withPaymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }
}

