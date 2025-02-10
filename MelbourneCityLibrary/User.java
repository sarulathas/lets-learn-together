import java.util.UUID;

public class User {
    private UUID userId;
    private String userName;

    public User(String userName) {
        this.userId = UUID.randomUUID();
        this.userName = userName;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userId + "\t" + userName;
    }

}
