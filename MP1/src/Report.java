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
        if (project.getClass().equals(LinksMetaData.REPORT_PROJECT.targetObjectClass) &&
                this.getClass().equals(LinksMetaData.REPORT_PROJECT.objectClass)) {
            this.addLink(LinksMetaData.REPORT_PROJECT.roleName, LinksMetaData.REPORT_PROJECT.reverseRoleName, project, qualifier);
        } else {
            throw new RuntimeException("Can't link this objects");
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
