public class Report extends ObjectPlusPlus {

    private String name;
    private String urlToLocation;

    protected Report(String name, String urlToLocation) {
        this.name = name;
        this.urlToLocation = urlToLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlToLocation() {
        return urlToLocation;
    }

    public void setUrlToLocation(String urlToLocation) {
        this.urlToLocation = urlToLocation;
    }

    protected void connectToProject(Project project, String qualifier) {
        if (!this.objectHasNoLinks(LinksMetaData.PROJECT_REPORT.roleName)) {
            System.out.println("This report is already connected to other project");
        }
        if (project.getClass().equals(LinksMetaData.REPORT_PROJECT.targetObjectClass) &&
                this.getClass().equals(LinksMetaData.REPORT_PROJECT.objectClass)) {
            this.addLink(LinksMetaData.REPORT_PROJECT.roleName, LinksMetaData.REPORT_PROJECT.reverseRoleName, project, qualifier);
        } else {
            throw new RuntimeException(String.format("Can't link objects from class %s and %s.",
                    project.getClass().getName(), this.getClass().getName()));
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "name='" + name + '\'' +
                ", urlToLocation='" + urlToLocation + '\'' +
                '}';
    }
}
