import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Task extends ObjectPlusPlus implements Serializable {

    public static List<Task> getTasks(Status status) {
        List<Task> allTasks = getTasks();
        return allTasks.stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
    }

    public static List<Task> getTasks(){
        return allExtents.get(Task.class).stream().map(obj -> (Task) obj)
                .collect(Collectors.toList());
    }

    private String title;
    private Status status;
    private Priority priority;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

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

    public void assignOwner(User user) throws Exception {
        user.assignTask(this);
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * Gets the value of the task start date
     *
     * @return start date if was set before or null if task is not started
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Gets the value of the task end date
     *
     * @return end date if task was ended or null otherwise
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    private void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    private void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
        switch (status) {
            case closed:
                setEndDate(LocalDateTime.now());
            case in_progress:
                setStartDate(LocalDateTime.now());
        }
    }

    public Duration getTimeSpent() {
        if (this.getStartDate() == null) {
            return null;
        }
        Duration duration = DateTimeUtils.getDurationBetween(
                getStartDate(),
                getEndDate() != null ? getEndDate() : LocalDateTime.now());
        return duration;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
