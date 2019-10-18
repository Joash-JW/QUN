import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class ValidAccListMgr {
    private static HashMap<String, String> validAccList = new HashMap<String, String>();
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

    public static boolean checkAccNumExist(String accNum) { return validAccList.containsKey(accNum); }

    public static void addAccNum(String accNum) {
        validAccList.put(accNum, null); return;
    }
}
