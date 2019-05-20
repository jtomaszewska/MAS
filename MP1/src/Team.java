import java.time.LocalDate;

public class Team extends ObjectPlusPlus {

    private String name;

    protected Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void addMember(User user, TimePeriod timePeriod) {
        new TeamUser(this, user, timePeriod);
    }

    protected void endCooperation(TeamUser teamUser, LocalDate timeEnd) {
        LocalDate timeStart = teamUser.getTimePeriod().getDateStart();
        TimePeriod period = new TimePeriod(timeStart, timeEnd);
        teamUser.setTimePeriod(period);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
