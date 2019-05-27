import java.util.List;

public class Email {

    private String subject;
    private String content;
    private String from;
    private List<Object> attachments;

    public Email(String subject, String content, String from, List<Object> attachments) {
        this.subject = subject;
        this.content = content;
        this.from = from;
        this.attachments = attachments;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }
}
