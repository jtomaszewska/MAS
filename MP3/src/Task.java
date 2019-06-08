
import java.time.LocalDateTime;

public abstract class Task {
    private String title;
    private Status status;
    private Priority priority;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    //flaga załatwiająca aspekt dziedziczenia
    private TaskType type;
    private int storyPoints;//bugów nie można wyceniać, robimy w cenie taska do któego były zgłoszone

    public Task(String title, Priority priority,
                String description, TaskType type) {
        super();
        this.title = title;
        this.status = Status.created;
        this.priority = priority;
        this.description = description;
        this.createDate = LocalDateTime.now();
        this.startDate = null;
        this.endDate = null;
        this.type = type;
    }

    public Task(Task task){
        super();
        this.title = task.title;
        this.status = task.status;
        this.priority = task.priority;
        this.description = task.description;
        this.createDate = task.createDate;
        this.startDate = task.startDate;
        this.endDate = task.endDate;
        this.type = task.type;
        this.storyPoints = task.storyPoints;
    }

    public void changeStatus(Status status){
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(int storyPoints) {
        if(type == TaskType.BUG){
            System.out.println("Cant add this parameter for a bug");
            return;
        }
        this.storyPoints = storyPoints;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
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
                ", type=" + type +
                ", storyPoints=" + storyPoints +
                '}';
    }
}
