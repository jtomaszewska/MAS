import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task extends ObjectPlus implements Serializable {

    private String title;
    private Status status;
    private Priority priority;
    private String description;
    /*atrybut powtarzalny*/
    /*Powtarzalne. Należy wykorzystać tablice lub
    kontenery (rozwiązanie preferowane gdy liczba
    wartości jest zmienna*/
    private Set<User> watchers = new HashSet<>();
    /*atrybut złożony*/
    private LocalDateTime dateCreate;
    /*atrybut opcjonalny + musi być zaprezentowane wykorzystanie tej opcjionalności*/
    /*Opcjonalne
        • Właściwe zapamiętanie informacji lub jej braku.
        • Odpowiednie przetwarzanie obu przypadków.
        • Dla atrybutów złożonych przechowujemy null jako
        informację o braku wartości.
        • Co z atrybutami prostymi? Klasy opakowujące!
        • Warto również zadbać o specjalny dostęp do
        takiego atrybutu (bo może nie mieć wartości!).
        */
    private LocalDateTime dateStart;
    /*atrybut opcjonalny*/
    private LocalDateTime dateEnd;

    //konstruktor odwołuje się do konstruktora z nadklasy - super
    public Task(String title, Priority priority,
                String description, User watcher) {
        super();
        this.title = title;
        this.status = Status.to_do;
        this.priority = priority;
        this.description = description;
        this.addWatcher(watcher);
        this.dateCreate = LocalDateTime.now();
        this.dateStart = null;
        this.dateEnd = null;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    /*metoda prezentująca atrybut opcjonalny
    np podaj datę zakończenia zadania, może ono jeszcze nie mieć wartości*/
    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void addWatcher(User user) {
        this.watchers.add(user);
    }

    public void removeWatcher(User user) {
        this.watchers.remove(user);
    }

    /*metoda obiektu*/
    public void changeStatus(Status newStatus) {
        this.status = newStatus;
        switch (status) {
            case closed:
                dateEnd = LocalDateTime.now();
            case in_progress:
                dateStart = LocalDateTime.now();
        }
    }

    /*
    metoda klasowa
    np wypisz zadania w danym statusie
    wypisz zadania przypisane do danej osoby
    wypisz zadania w których jednym z watchers jest podany user
    */
    public static List<Task> getTasks(Status status) {
        List<Task> allTasks = getTasks();
        return allTasks.stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
    }

    /*przykład na przeciążanie*/
    public static List<Task> getTasks(){
        return allExtents.get(Task.class).stream().map(obj -> (Task) obj)
                .collect(Collectors.toList());
    }

    /*atrybut pochodny - realizowany przez metodę, ma getter, brak settera, nie przechowujemy go
     * np podaj bieżący czas realizacji zadania, jesli nie rozpoczete to 0,
     * jesli trwa to data dziś - data rozpoczecia prac,
     * jest zakończone to data zakończenia - data rozpoczęcia prac*/
    public String getTimeSpent() {
        if (dateStart == null) {
            return this.title + " not started";
        }
        if (dateEnd == null) {
            return this.title +": "+ DateTimeUtils.getDurationBetween(this.getDateStart(), LocalDateTime.now())+" time spent";
        }
        return this.title +": "+ DateTimeUtils.getDurationBetween(this.getDateStart(), this.getDateEnd())+" time spent";
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", watchers=" + watchers +
                ", dateCreate=" + dateCreate +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
