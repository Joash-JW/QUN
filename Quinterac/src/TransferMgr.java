import java.util.Scanner;

public class TransferMgr {
	private static String modeName;

	public static void transfer() {
		try {
			if (!LoginMgr.isLoggedIn()) {
				throw new NotLoggedInException();
			}

			modeName = LoginMgr.checkMode();
			if (modeName.equals("machine")) {
				atmCheckTransferValid();
			} else if (modeName.equals("agent")) {
				agentCheckTransferValid();
			}

		} catch (NotLoggedInException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void atmCheckTransferValid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accountNumber)) {
				System.out.println("Please enter a valid account number");
				return;
			}
			
			System.out.println("Enter account number to accept your transfer: ");
			String accountNumberB = sc.nextLine();
			
			if (!ValidAccListMgr.checkAccNumExist(accountNumberB)) {
				System.out.println("Please enter a valid account number: ");
				return;
			}

			System.out.println("Enter the amount of money to transfer in cents:");
			int value = sc.nextInt();

			if (value >= 0 && value <= 1000000) {
				if (AccountMgr.checkDailyTransferLimit(accountNumber, value)) {
					AccountMgr.performDailyTransfer(value, accountNumber);
					TransactionFileMgr.addXfrTransaction(accountNumber, Integer.toString(value), accountNumberB);
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

	public static void agentCheckTransferValid() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter account number: ");
			String accountNumber = sc.nextLine();

			if (!ValidAccListMgr.checkAccNumExist(accountNumber)) {
				System.out.println("Please enter a valid account number");
				return;
			}
			
			System.out.println("Enter account number to accept your transfer: ");
			String accountNumberB = sc.nextLine();
			
			if (!ValidAccListMgr.checkAccNumExist(accountNumberB)) {
				System.out.println("Please enter a valid account number: ");
				return;
			}

			System.out.println("Enter the amount of money to transfer in cents:");
			int value = sc.nextInt();

			if (value >= 0 && value <= 99999999) {
				System.out.println("Transfer successfully:");
				TransactionFileMgr.addXfrTransaction(accountNumber, Integer.toString(value), accountNumberB);
			} else {
				System.out.println("Please enter a number between 0 - 99999999:");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}