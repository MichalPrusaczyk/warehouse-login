package root.userdatabase;

import java.util.List;

public interface IUserRepository {
    boolean authenticate(String login, String pass);
    boolean register(String login, String pass);
    List<User> getUserList();

}
