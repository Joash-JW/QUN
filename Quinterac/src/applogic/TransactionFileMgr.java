//the objective of this class is to manage all the transactions performed in the day

package applogic;
import java.util.*;
import java.io.*;
import data.TransactionHistory;

public class TransactionFileMgr {
	private static ArrayList <TransactionHistory> transactionList = new ArrayList<TransactionHistory> ();
	
	//clears the arraylist of transactions
	public static void resetTransactionList() {
		transactionList.clear();
	}
	
	//add deposit transaction into transaction summary file
	public static void addDepTransaction (String accNum, String amount) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("DEP");
		t.setFirstAccNum(accNum);
		t.setAmount(amount);
		
		transactionList.add(t);
	}
	
	//add withdraw transaction into transaction summary file
	public static void addWdrTransaction (String accNum, String amount) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("WDR");
		t.setFirstAccNum(accNum);
		t.setAmount(amount);
		
		transactionList.add(t);
	}
	
	//add transfer transaction into transaction summary file
	public static void addXfrTransaction (String firstAccNum, String amount, String secondAccNum) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("XFR");
		t.setFirstAccNum(firstAccNum);
		t.setAmount(amount);
		t.setSecondAccNum(secondAccNum);
		
		transactionList.add(t);
	}
	
	//add create account transaction into transaction summary file
	public static void addNewTransaction (String accNum, String accName) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("NEW");
		t.setFirstAccNum(accNum);
		t.setAccName(accName);
		
		transactionList.add(t);
	}
	
	//add delete account transaction into transaction summary file
	public static void addDelTransaction (String accNum, String accName) {
		TransactionHistory t = new TransactionHistory();
		t.setTransactionCode("DEL");
		t.setFirstAccNum(accNum);
		t.setAccName(accName);
		
		transactionList.add(t);
	}
	
	//write arraylist to transaction summary file
	public static void writeToTransactionFile(String transactionSummaryFile) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(transactionSummaryFile));
			
			for (int i = 0; i < transactionList.size(); i++) {
				TransactionHistory t = transactionList.get(i);
				String toBePrinted = t.getTransactionCode() + " " + t.getFirstAccNum() + " " + t.getAmount() + " " 
				+ t.getSecondAccNum() + " " + t.getAccName();
				out.println(toBePrinted);
			}
			out.println("EOS 0000000 000 0000000 ***");
			
			out.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
