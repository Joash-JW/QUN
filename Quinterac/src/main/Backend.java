package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Backend {
    private static HashMap<String, ArrayList> accFile = new HashMap<>();
    private static ArrayList<String> accNums = new ArrayList<>();

    public static void mainBackend(String oldMaster, String transactionSummaryFile ) {
        try {
            Scanner file = new Scanner(new File(oldMaster));
            while (file.hasNextLine()) {
                String[] line = file.nextLine().split(" ");
                accNums.add(line[0]);
                ArrayList<Object> accData = new ArrayList<>(2);
                accData.add(line[1]);
                accData.add(line[2]);
                accFile.put(line[0], accData);
            }
            file.close();
            return;
        } catch (FileNotFoundException e) { System.out.println(e); }
        writeNewMaster(oldMaster);
    }

    public static void writeNewMaster(String newMaster) {
        Collections.sort(accNums);

        try {
            PrintWriter out = new PrintWriter(new FileWriter(newMaster));

            for (String accNum : accNums) {
                ArrayList<Object> t = accFile.get(accNum);
                String toBePrinted = accNum + " " + t.get(0) + " " + t.get(1);
                out.println(toBePrinted);
            }

            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
