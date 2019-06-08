public class Main {
    public static void main(String[] args){

        //wieloaspektowe
        //Task->type(Feature, Bug, Improvement, Technical)-enum jako atrybut/flaga dająca znać jaka to klasa
        //Task->state(backlog, sprint, archived)-zwyczajne dziedziczenie
        //dynamic BacklogTask-> SprintTask -> ArchiveTask

        Task t1 = new BacklogTask("Zadanie 1", Priority.major, "AAA", TaskType.FEATURE);
        t1.setStoryPoints(5);
        System.out.println(t1);
        t1 = new SprintTask(t1);
        System.out.println(t1);
        t1.setStatus(Status.closed);
        t1 = new ArchiveTask(t1);
        System.out.println(t1);

        t1.setStoryPoints(5);
        System.out.println(t1.getStoryPoints());
        Task bug = new SprintTask("Bug 1", Priority.major, "AAA", TaskType.BUG);
        bug.setStoryPoints(2);


        //Klasa abstrakcyjna to Task
        //polimorfizm dla zadań w metodzie changeStatus()-każda klasa ma swoje ograniczenia i dopuszczalne stany
        t1.setStatus(Status.in_progress);
        bug.setStatus(Status.to_do);
        System.out.println(bug.getStatus());

        //overlapping
        //Employee->function(Analyst/Tester/Leader/Programmer)

        Employee employee1 = new Employee("Anna", "Nowak", "anowak@a.pl", PositionType.ANALYST);
        employee1.addFunction(PositionType.SCRUM_MASTER);

        System.out.println(employee1.getBonusRate());


        //wielodziedziczenie
        //User->Admin/Employee
        Admin admin = new Admin("Olga", "Nowak", "o.nowak@admini.com");


    }
}
