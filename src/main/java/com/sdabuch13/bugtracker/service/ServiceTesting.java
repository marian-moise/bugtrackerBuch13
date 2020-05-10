package com.sdabuch13.bugtracker.service;

import com.sdabuch13.bugtracker.model.HibernateUtil;
import com.sdabuch13.bugtracker.model.Issue;
import com.sdabuch13.bugtracker.model.Project;
import com.sdabuch13.bugtracker.model.User;


public class ServiceTesting {
    public static void main(String[] args) {


        /**CommentService TESTING:*/

//        CommentService cs = new CommentService();
//        Comment comment1 = cs.createComment("TestComment1");
//        Comment comment2 = cs.createComment("TestComment2");
//        Comment commentGet1 = cs.getCommentById(4);
//        Comment commentGet2 = cs.getCommentById(5);
//        cs.updateComment(1, "Bug in starting app");
//        cs.deleteComment(6);
//        cs.deleteComment(7);


        /**IssueService TESTING:*/

//        IssueService is = new IssueService();
//        ProjectService ps = new ProjectService();
//
//        Project project1 = ps.getProjectById(14);
//        Issue issue1 = new Issue("latency","latency at runtime",project1);
//        is.addIssue(issue1);





//        Issue issue2 = is.createIssue("TestIssue2","");
//        Issue getissue1 = is.getIssueById(5);
//        Issue getissue2 = is.getIssueById(6);
//        is.updateIssueName(1, "Updated","etwetwertw");
//        is.updateIssueName(6, "Updated","erwrwewe");
//        is.deleteIssue(5);
//        is.deleteIssue(6);


        /**ProjectService TESTING:*/

//        ProjectService ps = new ProjectService();
//        Project projectById = ps.getProjectById(1);
//        Project projectById1 = ps.getProjectById(2);
//        Project newProject1 = ps.createProject("Arabesque2","ARB123");
//        ps.updateProjectByName("Arabesque2","ARB123"," ","Arabesque");

//        ps.deleteProjectID(24);
//        Project projectByName1 = ps.getProjectByName("Arabesque");
//        Project projectByName2 = ps.getProjectByName("test");



        /**StatusService TESTING:*/

//        StatusService ss = new StatusService();
//        Status statusName1 = ss.createStatus("Testing");
//        Status statusName2 = ss.createStatus("Testing2");
//        Status status1 = ss.getStatus("New");
//        ss.updateStatus(4,"Testing");
//        ss.deleteStatus("Testing2");
//        System.out.println(statusName1);
//        System.out.println(statusName2);
//        System.out.println(status1);


        /**TypeService TESTING:*/

//        TypeService ts = new TypeService();
//        Type type1 = ts.createType("bnmx");
//        Type type2 = ts.createType("bnmxasdf");
//        Type type3 = ts.getType("Bug");
//        System.out.println(type1);
//        ts.updateType(4,"updated");
//        ts.updateType(5,"updated");
//        ts.deleteType(4);
//        ts.deleteType(5);


        /**UserService TESTING:*/

//        UserService us = new UserService();

//        User user1 = us.createUser("testUser1");
//        User user2 = us.createUser("testUser2");
//        User getuser1 = us.getUser("testUser1");
//        User getuser2 = us.getUser("testUser2");
//        System.out.println(getuser1);
//        System.out.println(getuser2);
//        us.updateUser(4,"del1");
//        us.updateUser(5,"del2");
//        us.deleteUser(4,"del1");
//        us.deleteUser(5,"del2");



        HibernateUtil.shutdown();
    }
}
