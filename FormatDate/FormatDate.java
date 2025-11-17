import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) return null;

        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("LLL", Locale.FRENCH);

        String month = dateTime.format(monthFormatter);
        int day = dateTime.getDayOfMonth();
        int year = dateTime.getYear();

        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();

        return "Le " + day + " " + month + " de l'an " + year +
                " à " + hour + "h" + minute + "m et " + second + "s";
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) return null;

        DateTimeFormatter monthFmt = DateTimeFormatter.ofPattern("LLLL", Locale.ITALIAN);

        String month = date.format(monthFmt);
        int day = date.getDayOfMonth();
        int yearShort = date.getYear() % 100;

        return month + " " + day + " " + yearShort;
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;

        return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
