import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {
    public static String getCurrentDateForDisplay() {
        return getCurrentDateForDisplay(Instant.now());
    }

    public static String getCurrentDateForDisplay(Instant instant) {
        // Convert Instant to LocalDate in UTC
        LocalDate date = instant.atZone(ZoneId.of("UTC")).toLocalDate();

        // Format LocalDate to String in YYYY-MM-DD format
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate getUTCdate() {
        return Instant.now().atZone(ZoneId.of("UTC")).toLocalDate();
    }

    public static LocalDate convertToDate(String dateString){
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static long daysBetween(LocalDate date1, LocalDate date2) {
        return  ChronoUnit.DAYS.between(date1, date2);
    }

}
