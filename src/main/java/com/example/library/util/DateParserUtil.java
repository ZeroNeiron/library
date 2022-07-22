package com.example.library.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParserUtil {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static LocalDate stringToDate(String string) {
        return LocalDate.parse(string, DATE_FORMATTER);
    }

    public static String dateToString(LocalDate date) {
        return DATE_FORMATTER.format(date);
    }
}
