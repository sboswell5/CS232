///Shelby Boswell
/// CS231-001
///Oct 15 2023


package WeekOfOct9.PasswordManager;

import java.util.Scanner; //Importing so we can use Scanner to get User Input
import java.util.ArrayList; //Importing so we can make an array list!

public class PasswordManager {
    
    public static void main(String[] args){

        //Going to Use ARRAY LIST to hold User Objects

        //Create a Password Manager class that has a list of User objects: 


        ArrayList<User> users = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        //Variable to Hold User Selection

        int userSelection;


        //Make Our Menu: 

        //We're choosing to do a do-while loop so that the menu is always displayed at least once,
        //regardless of user input. 
        do {
            System.out.println("Select from One of the Following Options: ");
            
            System.out.println("1. Add User");

            System.out.println("2. Change Password for Existing User");

            System.out.println("3. Check Password Strength");

            System.out.println("4. Display All Users and Passwords");

            System.out.println("5. Remove Existing User");

            System.out.println("6. Exit Menu");


            //Getting User Selection after Displaying our Menu

            userSelection = input.nextInt();

            //SwitchCase for All Possible Options

            switch (userSelection) {

                case 1: 

                    System.out.print("Enter Username: ");

                    String username = input.next();

                    System.out.print("Enter Password: \n Password must be at least 8 character, use at least one uppercase letter, and one special character. ");

                    String password = input.next();

                    if(checkPasswordStrength(password)){

                        users.add(new User(username, password));
            

                    } else {

                        System.out.println("The password you entered does not meet our requirements. ");
    
                    }

                    break;


                case 2:

                System.out.println("Enter Username: ");

                String changingUsername = input.next();

                System.out.println("Enter New Password: ");

                String newPassword = input.next();

                boolean userExists = false;

                for(User user : users) {

                    if(user.username.equals(changingUsername)){
                        userExists = true;
                        user.password = new StringBuilder(newPassword);

                        System.out.println("Your password has been changed.  ");
                        
                        break;
                    }

                    if (!userExists){

                        System.out.println("This user does not exist.");

                    }

                  }
                
                    break;


                case 3: 

                    System.out.print("Enter password to check security: ");

                    String passwordGiven = input.next();

                    if (checkPasswordStrength(passwordGiven)){

                        System.out.println("Strong Password!");
                        
                    } else {

                        System.out.println("Not a strong password. :(");

                    }
                    break; 

                case 4: 
                    for(User user : users){

                        System.out.println("Username: " + user.username + " Password: " + user.password.toString());

                    }
                    break;

                case 5: 
                    System.out.println("Which Username Should we Remove?");
                    
                    String removeUsername = input.next();

                    boolean removed = false;

                    for(User user : users) {

                            if(user.username.equals(removeUsername)){

                                users.remove(user);
                                removed = true;

                                System.out.println("Done!");
                                break;
                            }
                    }

                    if(!removed) {

                        System.out.println("User does not exist.");

                    }
                    break;

                    case 6: 
                    
                    return;

                default:

                System.out.println("Your selection was not an option. ");
                break;
            }
            //As long as the user selection is not 6, we're going to continue going
            //through the loop!
        } while (userSelection != 6);
    }

      //Check Password Strength

      public static boolean checkPasswordStrength(String password){


        //Given Criteria to check: 

        String upperCasePattern = ".*[A-Z].*";

        String lowerCasePattern = ".*[a-z].*";

        String specialCharPattern = ".*[^a-zA-Z].*";

        //This will return true if password is minimum 8 characters,
        // one uppercase, one lowercase, and one special character.
        

        return password.length() >= 8 &&

            password.matches(upperCasePattern) &&

            password.matches(lowerCasePattern) &&

            password.matches(specialCharPattern);

    }
}
