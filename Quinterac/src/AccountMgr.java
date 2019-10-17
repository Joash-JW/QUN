import java.util.*;

public class AccountMgr {
	private static ArrayList <Account> dailyAccountList = new ArrayList<Account> ();
	
	public static void resetDailyAccountList() {
		dailyAccountList.clear();
	}
	
	public static int checkAccountExistsInList(String accountNumber) {
		for (int i = 0; i < dailyAccountList.size(); i++) {
			if (dailyAccountList.get(i).getAccountNumber().equals(accountNumber)) {
				return i;
			}
		}
		addAccountToList(accountNumber);
		return dailyAccountList.size() - 1;
	}
	
	public static void addAccountToList(String accountNumber) {
		dailyAccountList.add(new Account(accountNumber));
	}
	
	public static boolean checkDailyDepositLimit(String accountNumber) {
		int i = checkAccountExistsInList(accountNumber);
		int dailyDeposit = dailyAccountList.get(i).getDailyDeposit();
		
		if (dailyDeposit <= 500000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void performDailyDeposit (int value, String accountNumber) {
		int i = checkAccountExistsInList(accountNumber);
		dailyAccountList.get(i).increaseDailyDeposit(value);
		System.out.println("Deposit successful!");
	}
	
	public static boolean checkDailyWithdrawLimit(String accountNumber) {
		int i = checkAccountExistsInList(accountNumber);
		int dailyWithdraw = dailyAccountList.get(i).getDailyWithdraw();
		
		if (dailyWithdraw <= 500000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void performDailyWithdraw (int value, String accountNumber) {
		int i = checkAccountExistsInList(accountNumber);
		dailyAccountList.get(i).increaseDailyWithdraw(value);
	}
	
	public static boolean checkDailyTransferLimit(String accountNumber) {
		int i = checkAccountExistsInList(accountNumber);
		int dailyTransfer = dailyAccountList.get(i).getDailyTransfer();
		
		if (dailyTransfer <= 1000000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void performDailyTransfer (int value, String accountNumber) {
		int i = checkAccountExistsInList(accountNumber);
		dailyAccountList.get(i).increaseDailyTransfer(value);
	}
}
