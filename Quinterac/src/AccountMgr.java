import java.util.*;

public class AccountMgr {
	private static Map<String, Account> dailyAccountMap = new HashMap<String, Account>();
	
	public static void resetDailyAccountMap() {
		dailyAccountMap.clear();
	}
	
	public static void checkAccountExistsInMap(String accountNumber) {
		if (dailyAccountMap.containsKey(accountNumber)){
			return;
		}
		else 
			addAccountToMap(accountNumber);
	}
	
	public static void addAccountToMap(String accountNumber) {
		dailyAccountMap.put(accountNumber, new Account(accountNumber));
	}
	
	public static boolean checkDailyDepositLimit(String accountNumber, int value) {
		checkAccountExistsInMap(accountNumber);
		int dailyDeposit = dailyAccountMap.get(accountNumber).getDailyDeposit() + value;
		
		if (dailyDeposit <= 500000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void performDailyDeposit (int value, String accountNumber) {
		checkAccountExistsInMap(accountNumber);
		dailyAccountMap.get(accountNumber).increaseDailyDeposit(value);
		System.out.println("Deposit successful!");
	}
	
	public static boolean checkDailyWithdrawLimit(String accountNumber, int value) {
		checkAccountExistsInMap(accountNumber);
		int dailyWithdraw = dailyAccountMap.get(accountNumber).getDailyWithdraw() + value;
		
		if (dailyWithdraw <= 500000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void performDailyWithdraw (int value, String accountNumber) {
		checkAccountExistsInMap(accountNumber);
		dailyAccountMap.get(accountNumber).increaseDailyWithdraw(value);
	}
	
	public static boolean checkDailyTransferLimit(String accountNumber, int value) {
		checkAccountExistsInMap(accountNumber);
		int dailyTransfer = dailyAccountMap.get(accountNumber).getDailyTransfer() + value;
		
		if (dailyTransfer <= 1000000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void performDailyTransfer (int value, String accountNumber) {
		checkAccountExistsInMap(accountNumber);
		dailyAccountMap.get(accountNumber).increaseDailyTransfer(value);
	}
}
