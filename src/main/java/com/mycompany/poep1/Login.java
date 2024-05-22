package com.mycompany.poep1;


import javax.swing.JOptionPane;

 
 
public class Login {

private String registeredUsername;
private String registeredPassword;
private String firstName;
private String lastName;

public  boolean checkUsername(String username) {

// Check if username contains an underscore and is no more than 5 characters long

return username.contains("_") && username.length() <= 5;

}


public boolean checkPasswordComplexity(String password) {

// Check if password meets complexity requirements
return password.matches(".*[A-Z].*") &&
   password.length() >= 8 &&
   password.matches(".*\\d.*")&&
   password.matches(".*[!@#$%^&*()].*");

 }

public boolean registerUser(String username, String password, String firstName, String lastName) {
    if (!checkUsername(username)) {

JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");

return false;
    }
// Check password complexity

if (!checkPasswordComplexity(password)) {

 JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");

return false;

}
this.registeredUsername =username;
this.registeredPassword =password;
this.firstName = firstName;
this.lastName = lastName;
JOptionPane.showMessageDialog(null,"username and password has been succcessfully captured");
return true;
}

public boolean loginUser(String username, String password) {
    return username.equals(registeredUsername) && password.equals(registeredPassword);
}
public String getFirstName() {
    return firstName;
}
 public String getLastName() {
     return lastName;
 }
}

        

    
   
       
       
        
     
    


        
    