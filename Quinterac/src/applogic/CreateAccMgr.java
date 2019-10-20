//the objective of this class is to manage create account operations and exceptions

package applogic;
import java.util.Scanner;
import exceptions.*;

public class CreateAccMgr {
	//method to perform create account operations
    public static void createacc() {
        try {
            if (LoginMgr.isLoggedIn()) {
                if (LoginMgr.checkMode().equals("agent")) {
                    System.out.println("Enter new account number (7 digits):");
                    String accNum = checkAccNum(); //to be changed
                    System.out.println("Enter new account name (3 to 30 alphanumeric characters):");
                    String accName = checkAccName();
                    
                    TransactionFileMgr.addNewTransaction(accNum, accName);
                    System.out.println("Account has been created. Please logout.");
                }
                else throw new InvalidModeException();
            }
            else throw new NotLoggedInException();
        } catch (NotLoggedInException e) { System.out.println(e.getMessage()); }
        catch (InvalidModeException e) { System.out.println(e.getMessage()); }
    }

    //checks the validity of the account number
    public static String checkAccNum() {
        String input;
        while (true) {
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
            
            if (input.charAt(0) == '0') {
            	System.out.println("Account number cannot begin with 0.");
            }
            else if (input.length() != 7) {
            	System.out.println("Account number must be of length 7.");
            }
            else if (ValidAccListMgr.checkAccNumExist(input)) {
            	System.out.println("Account number already exists.");
            }
            else
            	return input;
            
            System.out.println("Please enter it again.");
        }
    }

    //checks the validity of the account name
    public static String checkAccName() {
        String input;
        while (true) {
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
            
            if (input.charAt(0) == (' ')) {
            	System.out.println("Account name cannot begin with a space.");
            }
            else if (input.charAt(input.length() - 1) == (' ')) {
            	System.out.println("Account name cannot end with a space.");
            }
            else if (!input.matches("[a-zA-Z0-9 ]+")) {
            	System.out.println("Please enter alphanumeric characters.");
            }
            else if (input.length() < 3 || input.length() > 30) {
            	System.out.println("Please enter account name between 3 and 30 characters.");
            }
            else
            	return input;
            
            System.out.println("Please enter it again.");
        }
    }

}
