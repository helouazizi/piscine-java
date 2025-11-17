import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("LLLL", Locale.FRENCH);

        String day = String.valueOf(dateTime.getDayOfMonth());
        String month = dateTime.format(monthFormatter);
        int year = dateTime.getYear();

        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();

        return "Le " + day + " " + month + " de l'an " + year +
               " à " + hour + "h" + minute + "m et " + second + "s";
    }

    public static String formatSimple(LocalDate date) {
        DateTimeFormatter italianFmt = DateTimeFormatter.ofPattern("LLLL", Locale.ITALIAN);
        String month = date.format(italianFmt);

        int day = date.getDayOfMonth();
        int yearShort = date.getYear() % 100; 

        return month + " " + day + " " + yearShort;
    }

    public static String formatIso(LocalTime time) {
        DateTimeFormatter isoFmt = DateTimeFormatter.ofPattern("HH:mm:ss.nnnnnnnnn");
        return time.format(isoFmt);
    }
}
