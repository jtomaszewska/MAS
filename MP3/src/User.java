import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private String firstName;
    private String lastName;
    private List<String> emails = new ArrayList<>();

    public User(String firstName, String lastName, List<String> emails) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emails = emails;
    }

    public abstract void sendEmail(Email email);
}
