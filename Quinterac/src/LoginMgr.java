import java.util.Scanner;

public class LoginMgr {
    private static boolean loggedIn = false;
    private static String mode = null;

    public static boolean isLoggedIn() {
        return loggedIn;
    }
    public static String checkMode(){
        return mode;
    }
    public static void login(String accList) {
        if(loggedIn) { System.out.println("You are already logged in."); }
        else {
            loggedIn = true;
            ValidAccListMgr.readValidAccList(accList);
            System.out.println("Enter type of Session (machine or agent):");
            while (true) {
                Scanner s = new Scanner(System.in);
                String input = s.nextLine();
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
    public static void resetLogin() { loggedIn = false; mode = null;}
}
