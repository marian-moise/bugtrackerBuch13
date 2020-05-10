package com.sdabuch13.bugtracker.interface1;

import com.sdabuch13.bugtracker.model.Issue;
import com.sdabuch13.bugtracker.model.Project;
import com.sdabuch13.bugtracker.service.IssueService;
import com.sdabuch13.bugtracker.service.ProjectService;

import java.util.Scanner;

public class IssueUtilis {

    public void issueSelection(String input) {

        IssueUtilis newIssue = new IssueUtilis();
        MenuPrintUtilis newMenu = new MenuPrintUtilis();

        switch (input) {
            case "1":
                newIssue.createIssue();
                break;
//            case "2":
//                newIssue.showUser();
//                break;
//            case "3":
//                newUser.showUser();
//                break;
//            case "4":
//                newIssue.updateProject();
//                break;
            case "5":
                newIssue.deleteIssue();
                break;
            case "6":
                newIssue.updateIssue();
                break;
            case "7":
                newMenu.showUser();
            default:
                System.out.println("Invalid input!");

        }
    }

    public void createIssue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectId (where you want to add the issue), issueTitle and issueDescription or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showIssues();
        } else {
            //!!!!!!!!!!!!!!!!!!
            scanner.nextLine();
            System.out.println("issue title");
            String title = scanner.nextLine();
            System.out.println("issue description");
            String identifier = scanner.nextLine();
            createIssueFromService(id, title, identifier);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
            newMenu.showIssues();
        }
    }

    public Issue createIssueFromService(int id, String title, String description) {
        IssueService is = new IssueService();
        ProjectService ps = new ProjectService();
        Project p = ps.getProjectById(id);
        Issue newIssue = new Issue(title, description, p);
        is.addIssue(newIssue);
        return newIssue;

    }

    public void deleteIssue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce issueId to be deleted or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showIssues();
        } else {
            deleteIssueFromService(id);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
            newMenu.showIssues();
        }
    }

    public void deleteIssueFromService(int id) {
        IssueService is = new IssueService();
        is.deleteIssue(id);
    }

    public void updateIssue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the issueId you want to update and newIssueTitle, " +
                "newIssueDescription or press 0 to exit: ");
        int issueId = scanner.nextInt();

        if (issueId == 0) {
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showIssues();
        } else {
            String newIssueTitle = scanner.next();
            String newIssueDescription = scanner.next();
            updateIssueFromService(issueId, newIssueTitle, newIssueDescription);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
            newMenu.showIssues();
        }
    }


    public void updateIssueFromService(int issueId, String newIssueTitle, String newIssueDescription) {
        IssueService is = new IssueService();
        is.updateIssueName(issueId, newIssueTitle, newIssueDescription);
    }
}
