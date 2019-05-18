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

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
