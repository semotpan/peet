package com.semo.peet.service.income.domain;

import com.semo.peet.service.common.Description;
import com.semo.peet.service.common.Guards;
import com.semo.peet.service.common.Money;
import com.semo.peet.service.common.PaymentType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(of = {"incomeId", "amount"})
public final class Income {

    private final IncomeId incomeId;
    private final Money amount;
    private final IncomeSource incomeSource;
    private final IncomeDate incomeDate;
    private final IncomeTime incomeTime;
    private final Description description;
    private final PaymentType paymentType;

    private Income(Builder builder) {
        Guards.notNull(builder.incomeId, "Income Id cannot be null.");
        Guards.notNull(builder.amount, "Amount cannot be null.");
        Guards.notNull(builder.incomeSource, "Income Source cannot be null.");
        Guards.notNull(builder.incomeDate, "Income Date cannot be null.");
        Guards.notNull(builder.incomeTime, "Income Time cannot be null.");
        Guards.notNull(builder.paymentType, "Payment Type cannot be null.");

        this.incomeId = builder.incomeId;
        this.amount = builder.amount;
        this.incomeSource = builder.incomeSource;
        this.incomeDate = builder.incomeDate;
        this.incomeTime = builder.incomeTime;
        this.description = builder.description;
        this.paymentType = builder.paymentType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private IncomeId incomeId;
        private Money amount;
        private IncomeSource incomeSource;
        private IncomeDate incomeDate;
        private IncomeTime incomeTime;
        private Description description;
        private PaymentType paymentType;

        private Builder() {
        }

        public Builder withIncomeId(IncomeId incomeId) {
            this.incomeId = incomeId;
            return this;
        }

        public Builder withAmount(Money amount) {
            this.amount = amount;
            return this;
        }

        public Builder withIncomeSource(IncomeSource incomeSource) {
            this.incomeSource = incomeSource;
            return this;
        }

        public Builder withIncomeDate(IncomeDate incomeDate) {
            this.incomeDate = incomeDate;
            return this;
        }

        public Builder withIncomeTime(IncomeTime incomeTime) {
            this.incomeTime = incomeTime;
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

        public Income build() {
            return new Income(this);
        }
    }
}
