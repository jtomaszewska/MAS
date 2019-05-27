import javafx.scene.layout.Priority;

import java.time.LocalDateTime;
import java.util.EnumSet;

public class Task {
    private String title;
    private Status status;
    private Priority priority;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EnumSet<TaskType> types;

    public Task(String title, Priority priority,
                String description) {
        super();
        this.title = title;
        this.status = Status.to_do;
        this.priority = priority;
        this.description = description;
        this.createDate = LocalDateTime.now();
        this.startDate = null;
        this.endDate = null;
    }
}
