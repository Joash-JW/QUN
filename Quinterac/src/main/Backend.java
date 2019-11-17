//objective of this class is to launch backend program

package main;

import java.util.ArrayList;
import java.util.HashMap;

import backend.applogic.FileHandler;
import backend.applogic.TransactionProcessor;
import backend.data.Account;

public class Backend {
	// method to start backend program
	public static void mainBackend(String oldMaster, String transactionSummaryFile) {
		HashMap<String, Account> accData = FileHandler.readOldMasterFile(oldMaster);
		ArrayList<String[]> transactionFile = FileHandler.readTransactionSummaryFile(transactionSummaryFile);
		accData = TransactionProcessor.executeTransactions(accData, transactionFile);
		FileHandler.writeNewFiles(accData, oldMaster, "../ValidAccList.txt");
	}
}
