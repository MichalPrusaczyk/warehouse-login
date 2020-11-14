package root.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import root.userdatabase.IUserRepository;
import root.userdatabase.User;


import java.util.List;
import java.util.Scanner;


@Component
public class GUI1 {
    private Scanner scanner = new Scanner(System.in);
    @Autowired
    private IUserRepository usersRepository;
    @Autowired
    GUI2 gui2;

    public  void showMainMenu(){
        System.out.println("1. Login");
        System.out.println("2. Register");

        switch (scanner.nextLine()){
            case "1":
                showLoginScreen();
                showMainMenu();
                break;
            case"2":
                showRegisterScreen();
                showMainMenu();
                break;
            case "3":
                System.exit(0);
            case"9":
                showDatabase();
                showMainMenu();
            default:
                System.out.println("Incorrect choice");
                showMainMenu();
                break;
        }
    }

    private  void showLoginScreen(){
        System.out.println("Please set your login");
        String login = scanner.nextLine();
        System.out.println("Please set your password");
        String pass = scanner.nextLine();

        boolean authenticationResult = usersRepository.authenticate(login, pass);

        if (authenticationResult) {
            gui2.showMainMenu2();
        } else {
            System.out.println("Incorrect password or login");
        }
    }

    private  void showRegisterScreen(){
        System.out.println("Set login");
        String login = scanner.nextLine();
        System.out.println("Set password");
        String pass = scanner.nextLine();

        boolean registerResult = usersRepository.register(login, pass);

        if(registerResult){
            System.out.println("Registration correct");
        }else {
            System.out.println("Invalid login");
        }
    }
    private  void showDatabase(){
        List<User> userList = usersRepository.getUserList();
        for(User user : userList){
            System.out.println(userList);
        }

    }
}