//the objective of this class is to handle the reading in of the valid accounts list file and check if an account number is valid

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ValidAccListMgr {
    private static HashMap<String, String> validAccList = new HashMap<String, String>();
    
    //reads in the valid account list file
    public static void readValidAccList(String accList) {
        try {
            Scanner file = new Scanner(new File(accList));
            while (file.hasNextLine()) {
                validAccList.put(file.nextLine(), null);
            }
            file.close();
            //System.out.println(validAccList);
            return;
        } catch (FileNotFoundException e) { System.out.println(e); }
        catch (IOException e) { System.out.println(e); }
    }

    //checks if the account number exists in the file
    public static boolean checkAccNumExist(String accNum) { return validAccList.containsKey(accNum); }

    //add account number to hashMap
    public static void addAccNum(String accNum) {
        validAccList.put(accNum, null); return;
    }
    
    //remove account number from hashMap
    public static void removeAccNum(String accNum) {
    	validAccList.remove(accNum);
    }
}
