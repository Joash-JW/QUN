//the objective of this class is to manipulate account data based on 
//transactions from the merged transaction summary file

package backend.applogic;

import java.util.ArrayList;
import java.util.HashMap;

import backend.data.Account;

public class TransactionProcessor {
	private static HashMap<String, Account> accData;

	// manipulates account data based on transaction summary file
	public static HashMap<String, Account> executeTransactions(HashMap<String, Account> data,
			ArrayList<String[]> transList) {
		accData = data;
		for (String[] arr : transList) {
			String toAccNum = arr[1];
			int amount = Integer.parseInt(arr[2]);
			String fromAccNum = arr[3];
			String accName = arr[4];

			switch (arr[0]) {
			case "DEP":
				deposit(toAccNum, amount);
				break;
			case "WDR":
				withdraw(fromAccNum, amount);
				break;
			case "XFR":
				transfer(toAccNum, fromAccNum, amount);
				break;
			case "NEW":
				create(toAccNum, accName);
				break;
			case "DEL":
				delete(toAccNum, accName);
				break;
			// case "EOS":
			// break;
			default:
				crash("Transaction summary code is incorrect.");
			}
		}
		return accData;
	}

	// creates new account in list of accData
	private static void create(String accNum, String accName) {
		accData.put(accNum, new Account(accNum, "0", accName));
	}

	// removes old account from list of accData
	private static void delete(String accNum, String accName) {
		Account acc = accData.get(accNum);
		if (acc.getAmount() == 0 && acc.getAccName().equals(accName)) {
			accData.remove(accNum);
		} else {
			System.out.println("Transaction ignored. Delete conditions not met");
		}
	}

	// withdraws money from relevant account
	private static void withdraw(String accNum, int amount) {
		Account acc = accData.get(accNum);
		int newBalance = acc.getAmount() - amount;
		if (newBalance >= 0) {
			acc.setAmount(newBalance);
		} else {
			System.out.println("Transaction ignored. " + accNum + " would have a negative balance.");
		}
	}

	// deposits money into relevant account
	private static void deposit(String accNum, int amount) {
		Account acc = accData.get(accNum);
		int newBalance = acc.getAmount() + amount;
		if (newBalance <= 99999999) {
			acc.setAmount(newBalance);
		} else {
			System.out.println("Transaction ignored. " + accNum + " would exceed max amount.");
		}
	}

	// transfers money into relevant account
	private static void transfer(String toAccNum, String fromAccNum, int amount) {
		Account fromAcc = accData.get(fromAccNum);
		if (fromAcc.getAmount() - amount < 0) {
			System.out.println("Transaction ignored. " + fromAccNum + " would have a negative balance.");
			return;
		}
		Account toAcc = accData.get(toAccNum);
		if (toAcc.getAmount() + amount > 99999999) {
			System.out.println("Transaction ignored. " + toAccNum + " would exceed max amount.");
			return;
		}
		withdraw(fromAccNum, amount);
		deposit(toAccNum, amount);
	}

	// terminates program when error encountered
	private static void crash(String msg) {
		System.out.println(msg);
		System.exit(1);
	}

}
