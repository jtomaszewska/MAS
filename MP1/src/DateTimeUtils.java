import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    public static Duration getDurationBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        Duration duration = Duration.between(dateFrom, dateTo);
        return duration;
    }

    public static String getDurationStringBetween(Duration duration) {
        long millis = duration.toMillis();

        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }
}
