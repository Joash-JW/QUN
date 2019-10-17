import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ValidAccListMgr {
    private static ArrayList<String> validAccList = new ArrayList<String>();
    public static void readValidAccList(String accList) {
        try {
            Scanner file = new Scanner(new File(accList));
            while (file.hasNextLine()) {
                validAccList.add(file.nextLine());
            }
            file.close();
            Collections.sort(validAccList);
            //System.out.println(validAccList);
            return;
        } catch (FileNotFoundException e) { System.out.println(e); }
        catch (IOException e) { System.out.println(e); }
    }

    public static boolean checkAccNumExist(String input) {
        return validAccList.contains(input);
    }
}
