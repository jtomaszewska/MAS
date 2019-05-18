public enum LinksMetaData {

    TASK_USER(Task.class, User.class, "owned by", "responsible for"),
    USER_TASK(User.class, Task.class, "responsible for", "owned by"),
    USER_TEAM(User.class, Team.class, "member of", "consist of"),
    TEAM_USER(Team.class, User.class, "consist of", "member of"),
    PROJECT_REPORT(Project.class, Report.class, "documented by", "created for"),
    REPORT_PROJECT(Report.class, Project.class, "created for", "documented by");

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
