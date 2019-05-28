public class Leader extends Worker implements IAdmin{
    public Leader(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    @Override
    public void getPermissions() {

    }
}
