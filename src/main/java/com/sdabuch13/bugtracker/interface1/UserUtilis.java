package com.sdabuch13.bugtracker.interface1;

import com.sdabuch13.bugtracker.model.User;
import com.sdabuch13.bugtracker.service.UserService;

import java.util.Scanner;

public class UserUtilis {


    public void userSelection(String input) {
        UserUtilis newUser = new UserUtilis();
        MenuPrintUtilis newMenu = new MenuPrintUtilis();

        switch (input) {
            case "1":
                newUser.createUser();
                break;
//            case "2":
//                newUser.showUser();
//                break;
            case "3":
                newUser.updateUser();
                break;
            case "4":
                newUser.deleteUser();
                break;
            case "5":
                newMenu.showMainMenu();
            default:
                System.out.println("Invalid input!");
        }
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce userName or press 0 to exit: ");
        String input = scanner.next();
        if (input.equalsIgnoreCase("0")) {
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showUser();
        } else {
            createUserFromService(input);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
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
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showUser();
        } else {
            String username = scanner.next();
            updateUserFromService(userId, username);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
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
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showUser();
        } else {
            deleteUserFromservice(exit);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
            newMenu.showUser();
        }
    }

    public void deleteUserFromservice(int id) {
        UserService us = new UserService();
        us.deleteUser(id);
    }


}



