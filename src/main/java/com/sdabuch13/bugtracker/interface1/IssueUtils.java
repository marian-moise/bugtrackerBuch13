package com.sdabuch13.bugtracker.interface1;

import com.sdabuch13.bugtracker.model.Comment;
import com.sdabuch13.bugtracker.model.Issue;
import com.sdabuch13.bugtracker.model.Project;
import com.sdabuch13.bugtracker.service.CommentService;
import com.sdabuch13.bugtracker.service.IssueService;
import com.sdabuch13.bugtracker.service.ProjectService;

import java.util.List;
import java.util.Scanner;

public class IssueUtils {

    public void issueSelection(String input) {

        IssueUtils newIssue = new IssueUtils();
        MenuPrintUtils newMenu = new MenuPrintUtils();

        switch (input) {
            case "1":
                newIssue.createIssue();
                break;
            case "2":
                newIssue.showAllIssuesFromService();
                newMenu.showIssues();
                break;
            case "3":
                newIssue.showAllIssuesByProjectIdFromService();
                break;
            case "4":
                newIssue.deleteIssue();
                break;
            case "5":
                newIssue.updateIssue();
                break;
            case "6":
                newIssue.showAllCommentsByIssueIdfromService();
                break;
            case "0":
                newMenu.showMainMenu();
            default:
                System.out.println("Invalid input!");

        }
    }

    public void createIssue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectId (where you want to add the issue), issueTitle and issueDescription or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showIssues();
        } else {
            scanner.nextLine();
            System.out.println("issue title");
            String title = scanner.nextLine();
            System.out.println("issue description");
            String identifier = scanner.nextLine();
            createIssueFromService(id, title, identifier);
            MenuPrintUtils newMenu = new MenuPrintUtils();
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

    public void showAllIssuesFromService() {
        IssueService ps = new IssueService();
        System.out.println(ps.showAllIssues());
    }

    public void showAllIssuesByProjectIdFromService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectId to show issues or press 0 to exit: ");
        int id = scanner.nextInt();
        MenuPrintUtils menu = new MenuPrintUtils();
        if (id == 0) {
            menu.showIssues();
        } else {
            IssueService is = new IssueService();
            ProjectService ps = new ProjectService();
            Project p = ps.getProjectById(id);
            System.out.println(is.showAllIssuesByProject(p));;
            menu.showIssues();
        }
    }

    public void showAllCommentsByIssueIdfromService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce issueId to to show comments or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showIssues();
        } else {
            IssueService is = new IssueService();
            Issue i = is.getIssueById(id);
            CommentService cs = new CommentService();
            List<Comment> c =  cs.showAllCommentsByIssueId(i);
            System.out.println(c);
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showIssues();
        }
    }


    public void deleteIssue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce issueId to be deleted or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showIssues();
        } else {
            deleteIssueFromService(id);
            MenuPrintUtils newMenu = new MenuPrintUtils();
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
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showIssues();
        } else {
            scanner.nextLine();
            System.out.println("New issue title");
            String newIssueTitle = scanner.nextLine();
            System.out.println("New issue description");
            String newIssueDescription = scanner.nextLine();
            updateIssueFromService(issueId, newIssueTitle, newIssueDescription);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showIssues();
        }
    }


    public void updateIssueFromService(int issueId, String newIssueTitle, String newIssueDescription) {
        IssueService is = new IssueService();
        is.updateIssueName(issueId, newIssueTitle, newIssueDescription);
    }
}
