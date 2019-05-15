public enum LinksMetaData {

    TASK_USER(Task.class, User.class, "is owned by", "is responsible for"),
    USER_TASK(User.class, Task.class, "is responsible for", "is owned by"),
    USER_TEAM(User.class, Team.class, "is member of", "consist of"),
    TEAM_USER(Team.class, User.class, "consist of", "is member of");

    public Class objectClass;
    public Class targetObjectClass;
    public String roleName;
    public String reverseRoleName;

    LinksMetaData(Class objectClass, Class targetObjectClass, String roleName, String reverseRoleName) {
        this.objectClass = objectClass;
        this.targetObjectClass = targetObjectClass;
        this.roleName = roleName;
        this.reverseRoleName = reverseRoleName;
    }
}
