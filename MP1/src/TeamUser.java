import java.io.Serializable;

public class TeamUser extends ObjectPlusPlus implements Serializable {

    private TimePeriod timePeriod;

    public TeamUser(Team team, User user, TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
        if (LinksMetaData.TEAM_USER.objectClass.equals(team.getClass()) &&
                LinksMetaData.TEAM_USER.targetObjectClass.equals(user.getClass())) {
            team.addLink(LinksMetaData.TEAM_USER.roleName, LinksMetaData.TEAM_USER.reverseRoleName, this);
            user.addLink(LinksMetaData.TEAM_USER.reverseRoleName, LinksMetaData.TEAM_USER.roleName, this);
        } else {
            throw new RuntimeException("Can't link this objects");
        }
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder objectsToReturn = new StringBuilder();

        for (ObjectPlusPlus link :
                this.getLinks(LinksMetaData.TEAM_USER.roleName)) {
            objectsToReturn.append(link.toString());
        }
        for (ObjectPlusPlus link :
                this.getLinks(LinksMetaData.USER_TEAM.roleName)) {
            objectsToReturn.append(link.toString());
        }
        return objectsToReturn.toString();
    }

}
