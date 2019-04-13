import java.io.Serializable;
import java.time.LocalDate;

public class Sprint extends ObjectPlus implements Serializable {

    private static int defaultDurationWeeks = 2;

    public static void setDefaultDurationWeeks(int defaultDurationWeeks) {
        Sprint.defaultDurationWeeks = defaultDurationWeeks;
    }

    public static int getDefaultDurationWeeks() {
        return defaultDurationWeeks;
    }

    private String name;
    private LocalDate start;
    private LocalDate end;
    private int durationWeeks;

    public Sprint(String name, LocalDate start, LocalDate end) {
        this(name, start, end, defaultDurationWeeks);
    }

    public Sprint(String name, LocalDate start, LocalDate end, int durationWeeks) {
        super();
        this.name = name;
        this.start = start;
        this.end = end;
        this.durationWeeks = durationWeeks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
    }
}
