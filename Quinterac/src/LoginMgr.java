import java.util.Scanner;

public class LoginMgr {
    private static boolean loggedIn = false;
    private static String mode;
    public static void login(String accList) {
        if(loggedIn) { System.out.println("You are already logged in"); }
        else { loggedIn = true; ValidAccListMgr.readValidAccList(accList);}
        System.out.println("Enter type of Session (machine or agent):");
        while (true) {
            Scanner s = new Scanner(System.in);
            if (s.nextLine().equals("machine") || s.nextLine().equals("agent")) {
                mode = s.nextLine();
                break;
            }
            else {
                System.out.println("Please enter a valid session type");
            }
        }

    }
    public static boolean isLoggedIn() {
        return loggedIn;
    }
    public static String checkMode(){
        return mode;
    }
}
