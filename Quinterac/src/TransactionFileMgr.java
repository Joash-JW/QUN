import java.util.*;
import java.io.*;

public class TransactionFileMgr {
	private static ArrayList <TransactionHistory> transactionList = new ArrayList<TransactionHistory> ();
	
	public static void resetTransactionList() {
		transactionList.clear();
	}
	
	//add deposit transaction into transaction summary file
	public static void addDepTransaction (String accountNumber, String amount) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("DEP");
		t.setFirstAccountNumber(accountNumber);
		t.setAmount(amount);
		
		transactionList.add(t);
	}
	
	//add withdraw transaction into transaction summary file
	public static void addWdrTransaction (String accountNumber, String amount) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("WDR");
		t.setFirstAccountNumber(accountNumber);
		t.setAmount(amount);
		
		transactionList.add(t);
	}
	
	//add transfer transaction into transaction summary file
	public static void addXfrTransaction (String firstAccountNumber, String amount, String secondAccountNumber) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("XFR");
		t.setFirstAccountNumber(firstAccountNumber);
		t.setAmount(amount);
		t.setSecondAccountNumber(secondAccountNumber);
		
		transactionList.add(t);
	}
	
	//add create account transaction into transaction summary file
	public static void addNewTransaction (String accountNumber, String accountName) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("NEW");
		t.setFirstAccountNumber(accountNumber);
		t.setAccountName(accountName);
		
		transactionList.add(t);
	}
	
	//add delete account transaction into transaction summary file
	public static void addDelTransaction (String accountNumber, String accountName) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("DEL");
		t.setFirstAccountNumber(accountNumber);
		t.setAccountName(accountName);
		
		transactionList.add(t);
	}
	
	//writes arraylist to transaction summary file
	public static void writeToTransactionFile(String transactionSummaryFile) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(transactionSummaryFile));
			
			for (int i = 0; i < transactionList.size(); i++) {
				TransactionHistory t = transactionList.get(i);
				String toBePrinted = t.getTransactionCode() + " " + t.getFirstAccountNumber() + " " + t.getAmount() + " " 
				+ t.getSecondAccountNumber() + " " + t.getAccountName();
				//System.out.println(toBePrinted);
				out.println(toBePrinted);
			}
			out.println("EOS");
			
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
