package it.fedeb.uiadactintests.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static String getDateAddingDays(int daysToAdd) {
        LocalDate date = LocalDate.now().plusDays(daysToAdd);
        return formatLocalDateToString(date);
    }

    private static String formatLocalDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

}
