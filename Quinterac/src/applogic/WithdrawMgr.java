//the objective of this class is to manage all withdraw operations and exceptions

package applogic;
import java.util.Scanner;
import main.Quinterac;
import exceptions.NotLoggedInException;

public class WithdrawMgr {
	//method to perform withdraw operation
	public static void withdraw() {
		try {
			if (!LoginMgr.isLoggedIn()) {
				throw new NotLoggedInException();
			}

			//Scanner s = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accNum = Quinterac.s.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accNum)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to withdraw in cents:");
			int amount = Quinterac.s.nextLine();
			
			String modeName = LoginMgr.checkMode();
			if (modeName.equals("machine")) {
				atmCheckWithdrawValid(accNum, amount);
			} else if (modeName.equals("agent")) {
				agentCheckWithdrawValid(accNum, amount);
			}

		} catch (NotLoggedInException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	//method to check if withdraw amount is valid in machine mode
	public static void atmCheckWithdrawValid(String accNum, int amount) {
		try {
			if (amount >= 0 && amount <= 100000) {
				if (AccMgr.checkDailyWithdrawLimit(accNum, amount)) {
					AccMgr.performDailyWithdraw(amount, accNum);
					TransactionFileMgr.addWdrTransaction(accNum, Integer.toString(amount));
				} else {
					System.out.println("You have exceeded the daily limit");
				}
			} else {
				System.out.println("Please enter a number between 0 - 200000");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	//method to check if withdraw amount is valid in agent mode
	public static void agentCheckWithdrawValid(String accNum, int amount) {
		try {
			if (amount >= 0 && amount <= 99999999) {
				System.out.println("Withdraw successfully:");
				TransactionFileMgr.addWdrTransaction(accNum, Integer.toString(amount));
			} else {
				System.out.println("Please enter a number between 0 - 99999999:");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
