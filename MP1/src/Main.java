import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objects.txt"));
        ObjectPlus.readExtents(objectInputStream);
        System.out.println("before: ");
        ObjectPlus.logExtensions();

        User user1 = new User("Anna", "Złotopolska", "azlotopolska@gmail.com");
        User user2 = new User("Jan", "Nowak", "jnowak@gmail.com");
        User user3 = new User("Johny", "Kowalski", "jkowalski@gmail.com");
        Task myTask1 = new Task("Task 1", Priority.minor, "Some things to do", user1);
        Task myTask2 = new Task("Task 2", Priority.critical, "Do sth", user3);
        myTask1.addWatcher(user2);
        myTask1.changeStatus(Status.in_progress);
        List<Task> tasksInProgress = Task.getTasks(Status.in_progress);
        for (Task task :
                tasksInProgress) {
            System.out.println(task + ": " + Status.in_progress.toString());
        }
        System.out.println(myTask1.getTimeSpent());
        System.out.println(myTask2.getTimeSpent());

        LocalDateTime dateEnd = myTask1.getStartDate();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objects.txt"));
//        ObjectPlus.writeExtents(objectOutputStream);
        System.out.println("after: ");
        ObjectPlus.logExtensions();
    }
}
