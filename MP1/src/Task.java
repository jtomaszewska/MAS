import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task extends ObjectPlus implements Serializable {

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
    private Set<User> watchers = new HashSet<>();
    private LocalDateTime createDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Task(String title, Priority priority,
                String description, User watcher) {
        super();
        this.title = title;
        this.status = Status.to_do;
        this.priority = priority;
        this.description = description;
        this.addWatcher(watcher);
        this.createDate = LocalDateTime.now();
        this.startDate = null;
        this.endDate = null;
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

    public Set<User> getWatchers() {
        return watchers;
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

    public void addWatcher(User user) {
        this.watchers.add(user);
    }

    private void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    private void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void removeWatcher(User user) {
        this.watchers.remove(user);
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

    public String getTimeSpent() {
        if (this.getStartDate() == null) {
            return String.format("Task %s not started", getTitle());
        }
        String duration = DateTimeUtils.getDurationBetween(
                getStartDate(),
                getEndDate() != null ? getEndDate() : LocalDateTime.now());
        return String.format("Task %s:  %s time spent", getTitle(), duration);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", watchers=" + watchers +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
