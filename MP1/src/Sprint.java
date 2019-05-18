import java.io.Serializable;
import java.time.LocalDate;

public class Sprint extends ObjectPlusPlus implements Serializable {

    private static int defaultDurationWeeks = 2;

    public static void setDefaultDurationWeeks(int defaultDurationWeeks) {
        Sprint.defaultDurationWeeks = defaultDurationWeeks;
    }

    public static Sprint startSprint(Project project, String name, LocalDate start, int durationWeeks){
        if(project == null){
            throw new RuntimeException("Project does not exist");
        }
        return new Sprint(name, start, durationWeeks);
    }

    public static int getDefaultDurationWeeks() {
        return defaultDurationWeeks;
    }

    private String name;
    private LocalDate start;
    private int durationWeeks;

    private Sprint(String name, LocalDate start) {
        this(name, start, defaultDurationWeeks);
    }

    private Sprint(String name, LocalDate start, int durationWeeks) {
        super();
        this.name = name;
        this.start = start;
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

    public int getDurationWeeks() {
        return durationWeeks;
    }

    public void setDurationWeeks(int durationWeeks) {
        this.durationWeeks = durationWeeks;
    }

}
