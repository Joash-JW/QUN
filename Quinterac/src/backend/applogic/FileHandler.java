//the objective of this class is to handle the reading in of merged transaction summary file and old master accounts file 
//and the writing out of new masters account file and new valid accounts list

package backend.applogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import backend.data.Account;

public class FileHandler {
	// reads in the old master accounts file and processes it to the right format
	public static HashMap<String, Account> readOldMasterFile(String oldMasterFile) {
		HashMap<String, Account> data = new HashMap<>();
		try {
			Scanner file = new Scanner(new File(oldMasterFile));
			while (file.hasNextLine()) {
				String[] line = file.nextLine().split(" ");
				data.put(line[0], new Account(line[0], line[1], line[2]));
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally {
			return data;
		}
	}

	// writes out new valid account list file and new master accounts file
	public static void writeNewFiles(HashMap<String, Account> data, String newMaster, String validAccList) {
		ArrayList<String> accNums = new ArrayList<>(data.keySet());
		Collections.sort(accNums);
		Collections.reverse(accNums);

		try {
			PrintWriter out1 = new PrintWriter(new FileWriter(newMaster));
			PrintWriter out2 = new PrintWriter(new FileWriter(validAccList));

			for (String accNum : accNums) {
				String toBePrinted = "";
				Account acc = data.get(accNum);
				if (acc.getAmount() < 100) {
					toBePrinted = acc.getAccNum() + " " + String.format("%03d", acc.getAmount()) + " "
							+ acc.getAccName();
				} else {
					toBePrinted = acc.getAccNum() + " " + acc.getAmount() + " " + acc.getAccName();
				}
				out1.println(toBePrinted);
				String newValidAccList = acc.getAccNum();
				out2.println(newValidAccList);
			}
			out2.println("0000000");
			out1.close();
			out2.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	// reads in the transaction summary file and processes it to the right format
	public static ArrayList<String[]> readTransactionSummaryFile(String transactionSummaryFile) {
		ArrayList<String[]> transactionFile = new ArrayList<>();
		try {
			Scanner file = new Scanner(new File(transactionSummaryFile));
			while (file.hasNextLine()) {
				String[] line = file.nextLine().split(" ");
				if (!line[0].equals("EOS"))
					transactionFile.add(line);
			}
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} finally {
			return transactionFile;
		}
	}
}
