//the objective of this class is to manage all deposit operations and exceptions

package frontend.applogic;
import main.Quinterac;
import frontend.exceptions.NotLoggedInException;

public class DepositMgr {
	//method to perform deposit operation
	public static void deposit() {
		try {
			if (!LoginMgr.isLoggedIn()) {
				throw new NotLoggedInException();
			}

			//Scanner s = new Scanner(System.in);
			System.out.println("Enter account number:");
			String accNum = "";
			if (Quinterac.s.hasNextLine())
				accNum = Quinterac.s.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accNum)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to deposit in cents:");
			int amount = 0;
			if (Quinterac.s.hasNextInt()) amount = Integer.parseInt(Quinterac.s.nextLine());
			
			String modeName = LoginMgr.checkMode();
			if (modeName.equals("machine")) {
				atmCheckDepositValid(accNum, amount);
			} else if (modeName.equals("agent")) {
				agentCheckDepositValid(accNum, amount);
			}

		} catch (NotLoggedInException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// method to check if deposit amount is valid in machine mode
	public static void atmCheckDepositValid(String accNum, int amount) {
		try {
			if (amount >= 0 && amount <= 200000) {
				if (AccMgr.checkDailyDepositLimit(accNum, amount)) {
					AccMgr.performDailyDeposit(amount, accNum);
					TransactionFileMgr.addDepTransaction(accNum, Integer.toString(amount));
					System.out.println("Deposit successfully!");
				} else {
					System.out.println("You have exceeded the daily limit.");
				}
			} else {
				System.out.println("Please enter a number between 0 - 200000:");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	//method to check if deposit amount is valid in agent mode
	public static void agentCheckDepositValid(String accNum, int amount) {
		try {
			if (amount >= 0 && amount <= 99999999) {
				System.out.println("Deposit successfully!");
				TransactionFileMgr.addDepTransaction(accNum, Integer.toString(amount));
			} else {
				System.out.println("Please enter a number between 0 - 99999999:");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
