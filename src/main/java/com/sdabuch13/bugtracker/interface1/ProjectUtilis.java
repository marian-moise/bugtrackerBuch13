package com.sdabuch13.bugtracker.interface1;

import com.sdabuch13.bugtracker.model.Project;
import com.sdabuch13.bugtracker.service.ProjectService;

import java.util.Scanner;

public class ProjectUtilis {

    public void projectSelection(String input) {

        ProjectUtilis newProject = new ProjectUtilis();
        MenuPrintUtilis newMenu = new MenuPrintUtilis();

        switch (input) {
            case "1":
                newProject.createProject();
                break;
//            case "2":
//                newUser.showUser();
//                break;
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
            case "7":
                newMenu.showUser();
            default:
                System.out.println("Invalid input!");
        }

    }

    public void createProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectName and projectIdentifier or press 0 to exit : ");
        String name = scanner.next();

        if (name.equalsIgnoreCase("0")) {
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showProjects();
        } else {
            String identifier = scanner.next();
            createProjectFromService(name, identifier);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
            newMenu.showProjects();
        }
    }

    public Project createProjectFromService(String name, String identifier) {
        ProjectService ps = new ProjectService();
        Project newProject = ps.createProject(name, identifier);
        return newProject;
    }

    public void deleteProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce projectId to be deleted or press 0 to exit: ");
        int id = scanner.nextInt();
        if (id == 0) {
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showProjects();
        } else {
            deleteProjectFRomService(id);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
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
            MenuPrintUtilis menu = new MenuPrintUtilis();
            menu.showProjects();
        } else {
            String newProjectIdentifier = scanner.next();
            String newProjectDescription = scanner.next();
            String newName = scanner.next();
            updateProjectFromService(projectName, newProjectIdentifier, newProjectDescription, newName);
            MenuPrintUtilis newMenu = new MenuPrintUtilis();
            newMenu.showProjects();
        }
    }


    public void updateProjectFromService(String projectName, String newProjectIdentifier,
                                         String newProjectDescription, String newName) {
        ProjectService ps = new ProjectService();
        ps.updateProjectByName(projectName, newProjectIdentifier, newProjectDescription, newName);
    }



}




