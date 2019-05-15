import java.time.LocalDate;

public class Team extends ObjectPlusPlus {

    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(User user, LocalDate dateStart) throws Exception {
        new TeamUser(this, user, dateStart);
    }
}
