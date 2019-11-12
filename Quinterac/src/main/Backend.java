package main;

import backend.applogic.*;
import backend.data.Account;
import java.util.ArrayList;
import java.util.HashMap;

public class Backend {
    public static void mainBackend(String oldMaster, String transactionSummaryFile ) {
        HashMap<String, Account> accData = FileHandler.readOldMasterFile(oldMaster);
        ArrayList<String[]> transactionFile = FileHandler.readTransactionSummaryFile(transactionSummaryFile);
        accData = TransactionProcessor.executeTransactions(accData, transactionFile);
        FileHandler.writeNewFiles(accData, oldMaster, "../ValidAccList.txt");
    }
}
