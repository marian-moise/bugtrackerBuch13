package com.sdabuch13.bugtracker.interface1;

import java.util.Scanner;

public class InterfaceRunner {
    public static void main(String[] args) {


/**
 * LA DESCRIPTION NU ACCEPTA STRINGURI CU SPATII - WHY???????
 */

        MenuPrintUtilis mainMenu = new MenuPrintUtilis();
        mainMenu.showMainMenu();

        while (true) {

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            MenuPrintUtilis newMenu = new MenuPrintUtilis();

            if (input.equalsIgnoreCase("1")) {
                newMenu.showUser();
                while (true) {
                    String input2 = scanner.next();
                    if (input2.equalsIgnoreCase("5")){
                        newMenu.showMainMenu();
                        break;
                    }
                    UserUtilis newUser = new UserUtilis();
                    newUser.userSelection(input2);
                }
            } else if (input.equalsIgnoreCase("2")) {
                newMenu.showProjects();
                while (true) {
                    String input3 = scanner.next();
                    if (input3.equalsIgnoreCase("7")) {
                        newMenu.showMainMenu();
                        break;
                    }
                    ProjectUtilis newProject = new ProjectUtilis();
                    newProject.projectSelection(input3);
                }
            } else if (input.equalsIgnoreCase("3")) {
                newMenu.showIssues();
                while (true) {
                    String input4 = scanner.next();
                    if (input4.equalsIgnoreCase("7")){
                        newMenu.showMainMenu();
                        break;
                    }
                    IssueUtilis newIssue = new IssueUtilis();
                    newIssue.issueSelection(input4);
                }
            } else if (input.equalsIgnoreCase("0")) {
                System.out.println("GoodBye!!!");
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
