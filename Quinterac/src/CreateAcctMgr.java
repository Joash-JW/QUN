import java.util.Scanner;
import exceptions.*;

public class CreateAcctMgr {
    public static void createacct() {
        try {
            if (LoginMgr.isLoggedIn()) {
                if (LoginMgr.checkMode().equals("agent")) {
                    System.out.println("Enter new account number (7 digits):");
                    String accNum = checkAccNum(); //to be changed
                    System.out.println("Enter new account name (3 to 30 alphanumeric characters):");
                    String accName = checkAccName();
                }
                else throw new InvalidModeException();
            }
            else throw new NotLoggedInException();
        } catch (NotLoggedInException e) { System.out.println(e.getMessage()); }
        catch (InvalidModeException e) { System.out.println(e.getMessage()); }
    }

    public static String checkAccNum() {
        String input;
        while (true) {
            Scanner s = new Scanner(System.in);
            input = s.nextLine().trim();
            if(input.length()==7 && !ValidAccListMgr.checkAccNumExist(input)) {
                return input;
            }
        }
    }

    public static String checkAccName() {
        String input;
        while (true) {
            Scanner s = new Scanner(System.in);
            input = s.nextLine().trim();
            if(input.length()>=3 && input.length()<=30) {
                return input;
            }
        }
    }

}
