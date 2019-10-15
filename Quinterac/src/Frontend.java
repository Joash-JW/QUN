import java.util.Scanner;

public class Frontend {
    public static void mainFrontend(String accList, String transactionSummaryFile) {
        System.out.println("Welcome to Quinterac! To start, please login.");
        while (true){
            Scanner s = new Scanner(System.in);
            String transactionCode = s.nextLine();
            switch (transactionCode) {
                case "login": LoginMgr.login(accList); break;
                default: System.out.println("Please enter a valid transaction code."); break;
            }
        }
    }
}
