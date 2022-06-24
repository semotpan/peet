package com.semo.peet.service.common;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.isBlank;

public final class Guards {

    private Guards() {}

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }

    public static void notBlank(String text, String message) {
        if (isBlank(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNegative(BigDecimal value, String message) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
