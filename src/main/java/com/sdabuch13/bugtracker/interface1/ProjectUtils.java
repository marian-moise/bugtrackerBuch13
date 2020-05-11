package com.sdabuch13.bugtracker.interface1;

import com.sdabuch13.bugtracker.model.Project;
import com.sdabuch13.bugtracker.service.ProjectService;

import java.util.Scanner;

public class ProjectUtils {

    public void projectSelection(String input) {

        ProjectUtils newProject = new ProjectUtils();
        MenuPrintUtils newMenu = new MenuPrintUtils();

        switch (input) {
            case "1":
                newProject.createProject();
                break;
            case "2":
                newProject.showAllProjectsFromService();
                newMenu.showProjects();
                break;
            case "3":
                newProject.updateProject();
                break;
            case "4":
                newProject.deleteProject();
                break;
//            case "5":
//                newProject.showMainMenu();
//                break;
//            case "6":
//                newProject.showMainMenu();
//                break;
            case "0":
                newMenu.showUser();
            default:
                System.out.println("Invalid input!");
        }

    }

    public void createProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectName and projectIdentifier or press 0 to exit: ");
        String name = scanner.next();

        if (name.equalsIgnoreCase("0")) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showProjects();
        } else {
            scanner.nextLine();
            System.out.println("Introduce projectIdentifier: ");
            String identifier = scanner.nextLine();
            System.out.println("Introduce projectDescription: ");
            String description = scanner.nextLine();
            createProjectFromService(name, identifier, description);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showProjects();
        }
    }

    public Project createProjectFromService(String name, String identifier, String description) {
        ProjectService ps = new ProjectService();
        Project newProject = ps.createProject(name, identifier, description);
        return newProject;
    }

    public void showAllProjectsFromService() {
        ProjectService ps = new ProjectService();
        System.out.println(ps.showAllProjects());
    }

    public void deleteProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectId to be deleted or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showProjects();
        } else {
            deleteProjectFRomService(id);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showProjects();
        }
    }

    public void deleteProjectFRomService(int id) {
        ProjectService ps = new ProjectService();
        ps.deleteProjectID(id);
    }

    public void updateProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the projectName you want to update and newProjectIdentifier, " +
                "newProjectDescription, newProjectName or press 0 to exit: ");
        String projectName = scanner.next();

        if (projectName.equalsIgnoreCase("0")) {
            MenuPrintUtils menu = new MenuPrintUtils();
            menu.showProjects();
        } else {
            scanner.nextLine();
            System.out.println("Introduce new projectIdentifier: ");
            String newProjectIdentifier = scanner.nextLine();
            System.out.println("Introduce new projectDescription: ");
            String newProjectDescription = scanner.nextLine();
            System.out.println("Introduce new projectName: ");
            String newName = scanner.next();
            updateProjectFromService(projectName, newProjectIdentifier, newProjectDescription, newName);
            MenuPrintUtils newMenu = new MenuPrintUtils();
            newMenu.showProjects();
        }
    }


    public void updateProjectFromService(String projectName, String newProjectIdentifier,
                                         String newProjectDescription, String newName) {
        ProjectService ps = new ProjectService();
        ps.updateProjectByName(projectName, newProjectIdentifier, newProjectDescription, newName);
    }



}




