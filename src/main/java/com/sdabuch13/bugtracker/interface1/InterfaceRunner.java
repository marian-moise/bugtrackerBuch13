package com.sdabuch13.bugtracker.interface1;

import java.util.Scanner;

public class InterfaceRunner {
    public static void main(String[] args) {



        MenuPrintUtils mainMenu = new MenuPrintUtils();
        mainMenu.showMainMenu();

        while (true) {

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            MenuPrintUtils newMenu = new MenuPrintUtils();

            if (input.equalsIgnoreCase("1")) {
                newMenu.showUser();
                while (true) {
                    String input2 = scanner.next();
                    if (input2.equalsIgnoreCase("0")){
                        newMenu.showMainMenu();
                        break;
                    }
                    UserUtils newUser = new UserUtils();
                    newUser.userSelection(input2);
                }
            } else if (input.equalsIgnoreCase("2")) {
                newMenu.showProjects();
                while (true) {
                    String input3 = scanner.next();
                    if (input3.equalsIgnoreCase("0")) {
                        newMenu.showMainMenu();
                        break;
                    }
                    ProjectUtils newProject = new ProjectUtils();
                    newProject.projectSelection(input3);
                }
            } else if (input.equalsIgnoreCase("3")) {
                newMenu.showIssues();
                while (true) {
                    String input4 = scanner.next();
                    if (input4.equalsIgnoreCase("0")){
                        newMenu.showMainMenu();
                        break;
                    }
                    IssueUtils newIssue = new IssueUtils();
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
