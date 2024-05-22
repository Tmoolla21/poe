/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poep1;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RC_Student_lab
 */
public class POEP1 {
    private static final List<Task> tasks = new ArrayList<> ();
    private static int taskCounter = 0;
    private static final Login login = new Login();
    private static String currentUserFirstName = "";
    private static String currentUserLastName ="";
    
    public static void main(String[] args) {
        boolean loggedIn = false;
        
        OUTER:
        while (true) {
            String [] options = {"Register","Login","Quit"};
            
            int choice = JOptionPane.showOptionDialog(null,"welcome to EasyKanban","Main Menu",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
            //register
            switch (choice) {
                case 0:
                    {
                        String username = JOptionPane.showInputDialog(" Enter Username:");
                        String password =JOptionPane.showInputDialog("Enter Password:");
                        currentUserFirstName = JOptionPane.showInputDialog("Enter First Name:");
                        currentUserLastName = JOptionPane.showInputDialog("Enter Last Namer: ");
                        boolean registrationSuccessful = login.registerUser(username, password,currentUserFirstName, currentUserLastName);
                        if(registrationSuccessful) {
                            JOptionPane.showMessageDialog(null,"registration successful ! please login .");
                        }
                        // login
                        break;
                    }
                case 1:
                    {
                        String username = JOptionPane.showInputDialog("enter your username:");
                        String password = JOptionPane.showInputDialog("Enter password:");
                        loggedIn = login.loginUser(username, password);
                        if(loggedIn) {
                            currentUserFirstName = login.getFirstName();
                            currentUserLastName = login.getLastName();
                            JOptionPane.showMessageDialog(null,"welcome " + currentUserFirstName + " " + currentUserLastName +" , it is great to see you agian.");
                            manageTasks();
                        } else {
                            JOptionPane.showMessageDialog(null,"username or password incorrect, please try agian. ");
                        }
                        //quit
                        break;
                    }
                case 2:
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private static void manageTasks() {
        OUTER:
        while (true) {
            String[] options = {"Add Task","Show Report","Quit"};
            int choice = JOptionPane.showOptionDialog(null,"welcome to EastKanban","Task Menu",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
            // add tasks
            switch (choice) {
                case 0:
                    addTask();
                    // show report
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null,"coming soon");
                    //end
                    break;
                case 2:
                    break OUTER;
                default:
                    break;
            }
        }
}
private static void addTask() {
    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
    String taskDescription = JOptionPane.showInputDialog("enter task description :");
    var developerDetails = JOptionPane.showInputDialog(" Enter developer details (first and last name):");
    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hrs:"));
    String[] statuses = {"to do","doing","done"};
    var taskStatus =(String) JOptionPane.showInputDialog(null,"Select task Status:","task status", JOptionPane.QUESTION_MESSAGE,null,statuses,statuses[0]);
    
    
        Task task = new Task(taskName,taskDescription,developerDetails,taskDuration, taskStatus, taskCounter++);
        if (task.checkTaskDescription()){
            tasks.add(task);
            JOptionPane.showMessageDialog(null,"Task successfully captured .\n"+ task.printTaskDetails());
        } else{
            JOptionPane.showMessageDialog(null,"please enter a task description of less that 50 characters.");
        }
        int totalHours =tasks.stream().mapToInt(Task::getTaskDuration).sum();
        JOptionPane.showMessageDialog(null,"Total hrs across all tasks:"+ totalHours);
}
}

            
      

    
         