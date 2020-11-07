package root.gui;

import eu.prusaczyk.login.database.UsersRepository;
import root.userdatabase.IUserRepository;
import root.userdatabase.User;

import java.util.List;
import java.util.Scanner;

import static root.gui.GUI2.showMainMenu2;

public class GUI1 {


    private static Scanner scanner = new Scanner(System.in);
    private static IUserRepository usersRepository = UsersRepository.getInstance();

    public static void showMainMenu(){
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

    private static void showLoginScreen(){
        System.out.println("Please set your login");
        String login = scanner.nextLine();
        System.out.println("Please set your password");
        String pass = scanner.nextLine();

        boolean authenticationResult = usersRepository.authenticate(login, pass);

        if (authenticationResult) {
            showMainMenu2();
        } else {
            System.out.println("Incorrect password or login");
        }
    }

    private static void showRegisterScreen(){
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
    private static void showDatabase(){
        List<User> userList = usersRepository.getUserList();
        for(User user : userList){
            System.out.println(userList);
        }

    }
}