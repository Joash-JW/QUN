//the objective of this class is to manage delete account operations and exceptions

package applogic;
import exceptions.InvalidModeException;
import exceptions.NotLoggedInException;

import java.util.Scanner;

public class DeleteAccMgr {
	//method to perform delete account operations
    public static void deleteacc() {
        try {
            if (LoginMgr.isLoggedIn()) {
                if (LoginMgr.checkMode().equals("agent")) {
                    System.out.println("Enter account number (7 digits):");
                    Scanner s = new Scanner(System.in);
                    String accNum = s.nextLine();
                    
                    if (!ValidAccListMgr.checkAccNumExist(accNum)) {
        				System.out.println("Please enter a valid account number");
        				return;
        			}
                    
                    System.out.println("Enter account name (3 to 30 alphanumeric characters):");
                    String accName =  s.nextLine();
                    ValidAccListMgr.removeAccNum(accNum);
                    TransactionFileMgr.addDelTransaction(accNum, accName);
                    System.out.println("Account has been deleted. Please logout.");
                    
                    //not a system requirement - can remove
                    //while (true) {
                        //Scanner s = new Scanner(System.in);
                        //if (s.nextLine().trim().equals("logout")) { LogoutMgr.logout(); return; }
                        //System.out.println("Please logout.");
                    //}
                }
                else throw new InvalidModeException();
            }
            else throw new NotLoggedInException();
        } catch (NotLoggedInException e) { System.out.println(e.getMessage()); }
        catch (InvalidModeException e) { System.out.println(e.getMessage()); }
    }
}
