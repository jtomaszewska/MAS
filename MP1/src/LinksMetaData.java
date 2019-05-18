public enum LinksMetaData {

    TASK_USER(Task.class, User.class, "owned by", "responsible for"),
    USER_TASK(User.class, Task.class, "responsible for", "owned by"),
    USER_TEAM(User.class, Team.class, "member of", "consist of"),
    TEAM_USER(Team.class, User.class, "consist of", "member of"),
    PROJECT_REPORT(Project.class, Report.class, "implies", "created for"),
    REPORT_PROJECT(Report.class, Project.class, "created for", "implies"),
    PROJECT_SPRINT(Project.class, Sprint.class, "composed of", "belongs to"),
    SPRINT_PROJECT(Sprint.class, Project.class, "belongs to", "composed of");

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
