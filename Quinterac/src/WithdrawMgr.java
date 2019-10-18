import java.util.Scanner;
import exceptions.NotLoggedInException;

public class WithdrawMgr {
	private static String modeName;

	public static void withdraw() {
		try {
			if (!LoginMgr.isLoggedIn()) {
				throw new NotLoggedInException();
			}

			modeName = LoginMgr.checkMode();
			if (modeName.equals("machine")) {
				atmCheckWithdrawValid();
			} else if (modeName.equals("agent")) {
				agentCheckWithdrawValid();
			}

		} catch (NotLoggedInException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void atmCheckWithdrawValid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accountNumber)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to withdraw in cents:");
			int value = sc.nextInt();

			if (value >= 0 && value <= 100000) {
				if (AccountMgr.checkDailyWithdrawLimit(accountNumber, value)) {
					AccountMgr.performDailyWithdraw(value, accountNumber);
					TransactionFileMgr.addWdrTransaction(accountNumber, Integer.toString(value));
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

	public static void agentCheckWithdrawValid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accountNumber)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to withdraw in cents:");
			int value = sc.nextInt();

			if (value >= 0 && value <= 99999999) {
				System.out.println("Withdraw successfully:");
				TransactionFileMgr.addWdrTransaction(accountNumber, Integer.toString(value));
			} else {
				System.out.println("Please enter a number between 0 - 99999999:");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
