package backend.applogic;

import backend.data.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class FileHandler {

    public static HashMap readOldMasterFile(String oldMasterFile) {
        HashMap<String, Account> data = new HashMap<>();
        try {
            Scanner file = new Scanner(new File(oldMasterFile));
            while (file.hasNextLine()) {
                String[] line = file.nextLine().split(" ");
                data.put(line[0], new Account(line[0], line[1], line[2]));
            }
            file.close();
        } catch (FileNotFoundException e) { System.out.println(e); }
        finally {
            return data;
        }
    }

    public static void writeNewFiles(HashMap<String, Account> data, String newMaster, String validAccList) {
        ArrayList<String> accNums = new ArrayList<>(data.keySet());
        Collections.sort(accNums);
        Collections.reverse(accNums);

        try {
            PrintWriter out1 = new PrintWriter(new FileWriter(newMaster));
            PrintWriter out2 = new PrintWriter(new FileWriter(validAccList));

            for (String accNum : accNums) {
                Account acc = data.get(accNum);
                String toBePrinted = acc.getAccNum() + " " + acc.getAmount() + " " + acc.getAccName();
                out1.println(toBePrinted);
                String newValidAccList = acc.getAccNum();
                out2.println(newValidAccList);
            }
            out1.close();
            out2.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList readTransactionSummaryFile(String transactionSummaryFile) {
        ArrayList<String[]> transactionFile = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(transactionSummaryFile));
            while (file.hasNextLine()) {
                String[] line = file.nextLine().split(" ");
                if (!line[0].equals("EOS")) transactionFile.add(line);
            }
            file.close();
        } catch (FileNotFoundException e) { System.out.println(e); }
        finally {
            return transactionFile;
        }
    }
}
