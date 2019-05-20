import java.time.LocalDate;

public class Project extends ObjectPlusPlus {

    private String name;

    public Project(String name) {
        this.name = name;
    }

    protected void addReport(Report report, String qualifier) {
        report.connectToProject(this, qualifier);
    }

    protected Report getReport(String name) throws Exception {
        return (Report) this.getLinkedObject(LinksMetaData.PROJECT_REPORT.roleName, name);
    }

    protected void addSprint(String name, LocalDate start, int durationWeeks) throws Exception {
        Sprint sprint = Sprint.registerSprint(name, start, durationWeeks);
        this.addPart(LinksMetaData.PROJECT_SPRINT.roleName, LinksMetaData.PROJECT_SPRINT.reverseRoleName, sprint);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
