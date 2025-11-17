import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        // your code here
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("EEEE dd MMMM yyyy")
                .toFormatter(Locale.ENGLISH);
        return LocalDate.parse(stringDate.toLowerCase(), formatter);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        stringDate = stringDate.toLowerCase();
        int h = extractNumber(stringDate, "hour");
        int m = extractNumber(stringDate, "minutes");
        int s = extractNumber(stringDate, "seconds");

        boolean isPM = stringDate.contains("evening") || stringDate.contains("afternoon")
                || stringDate.contains("night");
        boolean isAM = stringDate.contains("morning");
        if (isPM && h < 12)
            h += 12;
        if (isAM && h == 12)
            h = 0;

        return LocalTime.of(h, m, s);
    }

    public static int extractNumber(String text, String unit) {
        var match = java.util.regex.Pattern.compile("(\\d+)\s*" + unit).matcher(text);

        if (match.find()) {
            return Integer.parseInt(match.group(1));
        }
        return 0;
    }

}