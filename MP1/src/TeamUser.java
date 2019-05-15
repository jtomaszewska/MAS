import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TeamUser extends ObjectPlusPlus implements Serializable {

    private LocalDate dateStart;
    private LocalDate dateEnd;

    public TeamUser(Team team, User user, LocalDate dateStart) throws Exception {
        this.dateStart = dateStart;
        if (LinksMetaData.TEAM_USER.objectClass.equals(team.getClass()) &&
                LinksMetaData.TEAM_USER.targetObjectClass.equals(user.getClass())) {
            team.addLink(LinksMetaData.TEAM_USER.roleName, LinksMetaData.TEAM_USER.reverseRoleName, this);
            user.addLink(LinksMetaData.TEAM_USER.reverseRoleName, LinksMetaData.TEAM_USER.roleName, this);
        } else {
            throw new Exception("Can't link this objects");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamUser teamUser = (TeamUser) o;
        return dateStart.equals(teamUser.dateStart) &&
                Objects.equals(dateEnd, teamUser.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd);
    }

    @Override
    public String toString() {
        String role1 = LinksMetaData.TEAM_USER.roleName;
        ObjectPlusPlus[] linksRole1 = new ObjectPlusPlus[0];
        try {
            linksRole1 = getLinks(role1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (ObjectPlusPlus link : linksRole1) {
            ((Team) link).getName();
        }
        String role2 = LinksMetaData.TEAM_USER.reverseRoleName;
        ObjectPlusPlus[] linksRole2 = getLinks(role2);
        for (ObjectPlusPlus link :
                linksRole2) {
            ((User) link).toString();
        }
        return "";
    }
}
