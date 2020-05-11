package com.sdabuch13.bugtracker.interface1;

import com.sdabuch13.bugtracker.model.User;
import com.sdabuch13.bugtracker.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserUtils {


    public void userSelection(String input) {
        UserUtils newUser = new UserUtils();
        MenuPrintUtils newMenu = new MenuPrintUtils();

        switch (input) {
            case "1":
                newUser.createUser();
                break;
            case "2":
                System.out.println( newUser.showAllUsersFromService());
                newMenu.showUser();
                break;
            case "3":
                newUser.updateUser();
                break;
            case "4":
                newUser.deleteUser();
                break;
            case "0":
                newMenu.showMainMenu();
            default:
                System.out.println("Invalid input!");
        }
    }


    public List<User> showAllUsersFromService() {
        UserService us = new UserService();
        return us.findAllUsers();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce userName or press 0 to exit: ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("0")) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showUser();
        } else {
            createUserFromService(input);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showUser();
        }
    }

    public User createUserFromService(String input) {
        UserService us = new UserService();
        User newUser = us.createUser(input);
        return newUser;
    }

    public void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the userId you want to update and new userName or press 0 to exit: ");
        int userId = scanner.nextInt();
        if (userId == 0) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showUser();
        } else {
            System.out.println("Introduce the newUsername: ");
            String username = scanner.next();
            updateUserFromService(userId, username);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showUser();
        }
    }

    public void updateUserFromService(int id, String newName) {
        UserService us = new UserService();
        us.updateUser(id, newName);
    }

    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce userId to be deleted or press 0 to exit: ");
        int exit = scanner.nextInt();
        if (exit == 0) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showUser();
        } else {
            deleteUserFromservice(exit);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showUser();
        }
    }

    public void deleteUserFromservice(int id) {
        UserService us = new UserService();
        us.deleteUser(id);
    }


}



