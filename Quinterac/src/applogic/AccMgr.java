//objective of this class is to manage the hashMap of accounts which perform transactions in each day

package applogic;
import java.util.*;
import data.Acc;

public class AccMgr {
	private static Map<String, Acc> dailyAccMap = new HashMap<String, Acc>();
	
	//clears the hashMap of accounts
	public static void resetDailyAccMap() {
		dailyAccMap.clear();
	}
	
	//checks if the account exists in dailyAccountMap
	public static void checkAccExistsInMap(String accNum) {
		if (dailyAccMap.containsKey(accNum)){
			return;
		}
		else 
			addAccToMap(accNum);
	}
	
	//adds an account to dailyAccountMap
	public static void addAccToMap(String accNum) {
		dailyAccMap.put(accNum, new Acc(accNum));
	}
	
	//checks dailyDepositLimit for a particular account
	public static boolean checkDailyDepositLimit(String accNum, int value) {
		checkAccExistsInMap(accNum);
		int dailyDeposit = dailyAccMap.get(accNum).getDailyDeposit() + value;
		
		if (dailyDeposit <= 500000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//increase dailyDeposit amount for a particular account
	public static void performDailyDeposit (int value, String accNum) {
		checkAccExistsInMap(accNum);
		dailyAccMap.get(accNum).increaseDailyDeposit(value);
		System.out.println("Deposit successfully!");
	}
	
	//checks dailyWithdrawLimit for a particular account
	public static boolean checkDailyWithdrawLimit(String accNum, int value) {
		checkAccExistsInMap(accNum);
		int dailyWithdraw = dailyAccMap.get(accNum).getDailyWithdraw() + value;
		
		if (dailyWithdraw <= 500000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//increase dailyWithdraw amount for a particular account
	public static void performDailyWithdraw (int value, String accNum) {
		checkAccExistsInMap(accNum);
		dailyAccMap.get(accNum).increaseDailyWithdraw(value);
		System.out.println("Withdraw successfully!");
	}
	
	//checks dailyTransferLimit for a particular account
	public static boolean checkDailyTransferLimit(String accNum, int value) {
		checkAccExistsInMap(accNum);
		int dailyTransfer = dailyAccMap.get(accNum).getDailyTransfer() + value;
		
		if (dailyTransfer <= 1000000) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//increase dailyTransfer amount for a particular account
	public static void performDailyTransfer (int value, String accNum) {
		checkAccExistsInMap(accNum);
		dailyAccMap.get(accNum).increaseDailyTransfer(value);
		System.out.println("Transfer successful!");
	}
}
