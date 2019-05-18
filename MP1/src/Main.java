import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objects.txt"));
//        ObjectPlus.readExtents(objectInputStream);
//        System.out.println("before: ");
//        ObjectPlus.logExtents();

        String user1Email1 = "azlotopolska@gmail.com";
        List<String> user1Emails = new ArrayList<>();
        user1Emails.add(user1Email1);
        user1Emails.add("azlotopolska2@gmail.com");
        User user1 = new User("Anna", "Złotopolska", user1Emails);
        Task myTask1 = new Task("Task 1", Priority.minor, "Some things to do");
        myTask1.changeStatus(Status.in_progress);
        List<Task> tasksInProgress = Task.getTasks(Status.in_progress);
        for (Task task : tasksInProgress) {
            System.out.println(task + ": " + Status.in_progress.toString());
        }
        System.out.println(myTask1.getTimeSpent());
        Task task2 = new Task("Task 2", Priority.critical, "Nanana");
        Task task3 = new Task("Task 3", Priority.major, "Desc 3");

        //zwykła 1..*
        user1.assignTask(myTask1);
        user1.assignTask(task2);
        task3.assignOwner(user1);

        user1.showLinks(LinksMetaData.USER_TASK.roleName, System.out);
        task2.showLinks(LinksMetaData.USER_TASK.reverseRoleName, System.out);

        Team team1 = new Team("Team 1");
        Team team2 = new Team("Team 2");
        User user2 = new User("Jan", "Studencki", Arrays.asList("jstudencki@js.pl", "jan.studencki@gmail.com"));

        // Z atrybutem *..* User-Team

        TimePeriod timePeriod = new TimePeriod(LocalDate.now(), null);
        team1.addMember(user1, timePeriod);
        team1.addMember(user2, timePeriod);

        user1.addToTeam(team2, timePeriod);

        user1.showLinks(LinksMetaData.USER_TEAM.roleName, System.out);
        user2.showLinks(LinksMetaData.USER_TEAM.roleName, System.out);
        team1.showLinks(LinksMetaData.TEAM_USER.roleName, System.out);
        team2.showLinks(LinksMetaData.TEAM_USER.roleName, System.out);

        // kwalifikowana 1..* Project-Report qualifier:name

        Project project1 = new Project("Project 1");
        Report reportFin = new Report("Financial1", "\\\\repots.abc.pl\\project1\\fin1");
        Report reportTech = new Report("Technical1", "\\\\repots.abc.pl\\project1\\tech1");

        project1.addReport(reportFin, reportFin.getName());
//        reportTech.connectToProject(project1, reportTech.getName());
//        Project project2 = new Project("Project 2");
//        project1.showLinks(LinksMetaData.PROJECT_REPORT.roleName, System.out);
//        reportFin.showLinks(LinksMetaData.REPORT_PROJECT.roleName, System.out);
//        reportTech.showLinks(LinksMetaData.REPORT_PROJECT.roleName, System.out);
        System.out.println(project1.getReport("Financial1").toString());

        //kompozycja Project - Sprint


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objects.txt"));
        ObjectPlus.writeExtents(objectOutputStream);
        System.out.println("after: ");
        ObjectPlus.logExtents();


        /*// Create new objects (no links)
        Actor a1 = new Actor("Arnold Schwarzenegger");
        Actor a2 = new Actor("Michael Biehn");
        Actor a3 = new Actor("Kristanna Loken");
        Movie f1 = new Movie("Terminator 1");
        Movie f3 = new Movie("Terminator 3");
        Group g1 = new Group(1);
        Group g2 = new Group(2);
        // Add info about links
        f1.addLink("actor", "movie", a1);
        // f1.addLink("actor", "movie", a2);
        f1.addLink("actor", "movie", a2, "MB"); // use the qualified association
        f3.addLink("actor", "movie", a1);
        f3.addLink("actor", "movie", a3);
        g1.addPart("part", "whole", a1);
        g1.addPart("part", "whole", a2);
        g2.addPart("part", "whole", a3);
        // g2.addPart("part", "whole", a1); // an exception because the part already belongs to another
        whole (group)
        */

        /*
        public static void testAssociationsObjectPlus() throws Exception {
            // [...]
            // Show infos
            f1.showLinks("actor", System.out);
            f3.showLinks("actor", System.out);
            a1.showLinks("movie", System.out);
            g1.showLinks("part", System.out);
            // Test the qualified association
            System.out.println(f1.getLinkedObject("actor", "MB"));
        }

         */
    }
}
