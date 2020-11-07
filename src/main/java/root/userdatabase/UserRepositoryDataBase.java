package root.userdatabase;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

    public class UserRepositoryDataBase {
        private List<User> userList = new ArrayList<>();
        private static final UserRepositoryDataBase usersRepository = new UserRepositoryDataBase();

        private UserRepositoryDataBase() {
            this.userList.add(new User("admin", DigestUtils.md5Hex( "admin")));
        }

        public static UserRepositoryDataBase getInstance(){
            return usersRepository;
        }
        public boolean authenticate(String login, String pass){
            for(User user : userList){
                if(user.getLogin().equals(login)){
                    if(user.getPass().equals(DigestUtils.md5Hex(pass))){
                        return true;
                    }else{
                        return false;
                    }

                }
            }
            return false;
        }
        public boolean register(String login, String pass){
            for(User currentUser : this.userList){
                if(currentUser.getLogin().equals(login)){
                    return false;
                }
            }
            this.userList.add(new User(login, DigestUtils.md5Hex(pass)));
            return true;
        }

        public List<User> getUserList() {
            return userList;
        }
    }
