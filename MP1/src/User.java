import java.util.ArrayList;
import java.util.List;

public class User extends ObjectPlusPlus {

    private String firstName;
    private String lastName;
    private List<String> emails = new ArrayList<>();

    public User(String firstName, String lastName, List<String> emails) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emails = emails;
    }

    public void assignTask(Task task) throws Exception {
        if (!task.objectHasNoLinks(LinksMetaData.TASK_USER.roleName)) {
            System.out.println("This task is already connected to other user");
        }
        if (task.getClass().equals(LinksMetaData.USER_TASK.targetObjectClass) &&
                this.getClass().equals(LinksMetaData.USER_TASK.objectClass)) {
            this.addLink(LinksMetaData.USER_TASK.roleName, LinksMetaData.USER_TASK.reverseRoleName, task);
        } else {
            throw new Exception("Can't link this objects");
        }
    }

    public void addToTeam(Team team, TimePeriod timePeriod) throws Exception {
        new TeamUser(team, this, timePeriod);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emails=" + emails +
                '}';
    }
}
