//the objective of this class is to manage all transfer operations and exceptions

package frontend.applogic;

import frontend.exceptions.NotLoggedInException;
import main.Quinterac;

public class TransferMgr {
	// method to perform transfer operation
	public static void transfer() {
		try {
			if (!LoginMgr.isLoggedIn()) {
				throw new NotLoggedInException();
			}

			// Scanner s = new Scanner(System.in);
			System.out.println("Enter account number to transfer to: ");
			String accNum = "";
			if (Quinterac.s.hasNextLine())
				accNum = Quinterac.s.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accNum)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter account number to transfer from: ");
			String accNumB = "";
			if (Quinterac.s.hasNextLine())
				accNumB = Quinterac.s.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accNumB)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to transfer in cents: ");
			int amount = 0;
			if (Quinterac.s.hasNextInt())
				amount = Integer.parseInt(Quinterac.s.nextLine());

			String modeName = LoginMgr.checkMode();
			if (modeName.equals("machine")) {
				atmCheckTransferValid(accNum, amount, accNumB);
			} else if (modeName.equals("agent")) {
				agentCheckTransferValid(accNum, amount, accNumB);
			}

		} catch (NotLoggedInException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// method to check if transfer amount is valid in machine mode
	public static void atmCheckTransferValid(String accNum, int amount, String accNumB) {
		try {
			if (amount >= 0 && amount <= 1000000) {
				if (AccMgr.checkDailyTransferLimit(accNum, amount)) {
					AccMgr.performDailyTransfer(amount, accNum);
					TransactionFileMgr.addXfrTransaction(accNum, Integer.toString(amount), accNumB);
					System.out.println("Transfer successful!");
				} else {
					System.out.println("You have exceeded the daily limit");
				}
			} else {
				System.out.println("Please enter a number between 0 - 1000000");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// method to check if transfer amount is valid in agent mode
	public static void agentCheckTransferValid(String accNum, int amount, String accNumB) {
		try {
			if (amount >= 0 && amount <= 99999999) {
				System.out.println("Transfer successful!");
				TransactionFileMgr.addXfrTransaction(accNum, Integer.toString(amount), accNumB);
			} else {
				System.out.println("Please enter a number between 0 - 99999999");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}