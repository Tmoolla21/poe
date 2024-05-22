/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poep1;
/**
 *
 * @author RC_Student_lab
 */
public final class Task {
 private final  String taskName;
 private final int taskNumber;
 private final String taskDescription;
  private final String developerDetails;
  private final int taskDuration;
  private final String taskID;
  private final String taskStatus;
     
  
    
     
     public Task(String taskName, String taskDescription, String developerDetails, int taskDuration,String taskStatus, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription =taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration= taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskNumber;
        this.taskID = createTaskID();
        
     }
                
     
     public boolean checkTaskDescription(){
        return taskDescription.length() <= 50;
     }
         public String createTaskID() {
             String[] developerNames = developerDetails.split("");
             return taskName.substring(0,2).toUpperCase()+":"+taskNumber+":"+developerNames[developerNames.length - 1 ].substring(0,3).toUpperCase();
         }
         
         public String printTaskDetails() {
             return "Task Status" + taskStatus + "\n" +
                     "Developer Details" + developerDetails + "\n" +
                     "Task Num:" + taskNumber +"\n" +
                     "Task name :" + taskName +"\n" +
                     " Task description"+ taskDescription+ "\n" +
                     "Task ID" + taskID +"\n"+
                     "Task Duration:" + taskDuration +"hrs\n";
         }
         public int getTaskDuration() {
             return taskDuration;
    
         }
}


  



