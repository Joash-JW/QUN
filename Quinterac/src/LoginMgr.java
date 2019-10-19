//the objective of this class is to manage login operations and exceptions

import java.util.Scanner;

public class LoginMgr {
    private static boolean loggedIn = false;
    private static String mode = null;

    // checks if user is logged in
    public static boolean isLoggedIn() {
        return loggedIn;
    }
    
    //checks the current mode (machine or agent)
    public static String checkMode(){
        return mode;
    }
    
    // method to perform login operation
    public static void login(String accList) {
        if(loggedIn) { System.out.println("You are already logged in."); }
        else {
            loggedIn = true;
            ValidAccListMgr.readValidAccList(accList);
            System.out.println("Enter type of Session (machine or agent):");
            while (true) {
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();
                if (input.equals("machine") || input.equals("agent")) {
                    mode = input;
                    System.out.println("You have logged in.");
                    break;
                }
                else {
                    System.out.println("Please enter a valid session type.");
                }
            }
        }
        return;
    }
    
    //sets loggedIn to false and mode to null
    public static void resetLogin() { loggedIn = false; mode = null;}
}
