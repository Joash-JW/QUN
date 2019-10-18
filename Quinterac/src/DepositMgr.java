import java.util.Scanner;
import exceptions.NotLoggedInException;

public class DepositMgr {
	private static String modeName;

	public static void deposit() {
		try {
			if (!LoginMgr.isLoggedIn()) {
				throw new NotLoggedInException();
			}

			modeName = LoginMgr.checkMode();
			if (modeName.equals("machine")) {
				atmCheckDepositValid();
			} else if (modeName.equals("agent")) {
				agentCheckDepositValid();
			}

		} catch (NotLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void atmCheckDepositValid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accountNumber)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to deposit in cents:");
			int value = sc.nextInt();

			if (value >= 0 && value <= 200000) {
				if (AccountMgr.checkDailyDepositLimit(accountNumber, value)) {
					AccountMgr.performDailyDeposit(value, accountNumber);
					TransactionFileMgr.addDepTransaction(accountNumber, Integer.toString(value));
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

	public static void agentCheckDepositValid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accountNumber)) {
				System.out.println("Please enter a valid account number");
				return;
			}

			System.out.println("Enter the amount of money to deposit in cents:");
			int value = sc.nextInt();

			if (value >= 0 && value <= 99999999) {
				System.out.println("Deposit successfully:");
				TransactionFileMgr.addDepTransaction(accountNumber, Integer.toString(value));
			} else {
				System.out.println("Please enter a number between 0 - 99999999:");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
