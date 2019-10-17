import java.util.Scanner;

public class DepositMgr {
	private static boolean isLoggedIn = LoginMgr.isLoggedIn();
	private static String modeName = LoginMgr.checkMode();
	
	public static void atmCheckDepositValid() {
	    Scanner sc = new Scanner(System.in);
		if (isLoggedIn == false) {
			System.out.println("Please login first!");
			return;
		}
		
		if (modeName == "machine") {
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();
			//check if account is valid
			//not done
			
			System.out.println("Enter the amount of money to deposit in cents:");
            int value = sc.nextInt();
                
            if (value >= 0 && value <= 200000) {
            	if (AccountMgr.checkDailyDepositLimit(accountNumber)) {
            		AccountMgr.performDailyDeposit(value, accountNumber);
            		TransactionFileMgr.addDepTransaction(accountNumber, Integer.toString(value));
            	}
            	else {
            		System.out.println("You have exceeded the daily limit");
            	}	
            }
            else {
                System.out.println("Please enter a number between 0 - 200000");	
            }
		}
	}

	
	public static void agentCheckDepositValid() {
		if (isLoggedIn == false) {
			System.out.println("Please login first!");
			return;
		}
		
		if (modeName == "agent") {
	        Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();
			//check if account is valid
			//not done
			
			System.out.println("Enter the amount of money to deposit in cents:");
            int value = sc.nextInt();
	        
	        if (value >= 0 && value <= 99999999) {
	        	System.out.println("Deposit successfully:");
	        	TransactionFileMgr.addDepTransaction(accountNumber, Integer.toString(value));
	        }
	        else {
	        	System.out.println("Please enter a number between 0 - 99999999:");
	        }
		}
	}
}
