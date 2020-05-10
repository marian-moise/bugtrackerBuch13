package com.sdabuch13.bugtracker.interface1;

public class MenuPrintUtilis {

    public void showMainMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("|             [ BUGTRACKER MAIN ]              |");
        System.out.println("------------------------------------------------");
        System.out.println("[1] ---> USERNAMES");
        System.out.println("[2] ---> PROJECTS");
        System.out.println("[3] ---> ISSUES");
        System.out.println("[0] ---> EXIT");
    }

    public void showUser() {
        System.out.println("------------------------------------------------");
        System.out.println("|                [ USERNAMES ]                 |");
        System.out.println("------------------------------------------------");
        System.out.println("[1] ---> Create username");
        System.out.println("[2] ---> Display all users");
        System.out.println("[3] ---> Update username");
        System.out.println("[4] ---> Delete username");
        System.out.println("[5] ---> Back");
    }

    public void showProjects() {
        System.out.println("------------------------------------------------");
        System.out.println("|                [ PROJECTS ]                  |");
        System.out.println("------------------------------------------------");
        System.out.println("[1] ---> Create new project");
        System.out.println("[2] ---> Display all projects");
        System.out.println("[3] ---> Update project");
        System.out.println("[4] ---> Delete project");
        System.out.println("[5] ---> Show Done projects");
        System.out.println("[6] ---> Show InProgress projects");
        System.out.println("[7] ---> Back");
    }

    public void showIssues() {
        System.out.println("------------------------------------------------");
        System.out.println("|                 [ ISSUES ]                   |");
        System.out.println("------------------------------------------------");
        System.out.println("[1] ---> Create new issue");
        System.out.println("[2] ---> Show all issues");
        System.out.println("[3] ---> Show Done issues");
        System.out.println("[4] ---> Show InProgress issues");
        System.out.println("[5] ---> Delete issue");
        System.out.println("[6] ---> Update issue");
        System.out.println("[7] ---> Back");
    }

}
