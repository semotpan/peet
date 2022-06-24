package com.semo.peet.service.common;

public enum PaymentType {

    CASH("Cash"),
    BANK("Bank");

    private final String value;

    PaymentType(String value) {
        Guards.notNull(value, "Value cannot be null.");
        this.value = value;
    }

    public String value() {
        return value;
    }
}
