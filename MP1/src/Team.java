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

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
