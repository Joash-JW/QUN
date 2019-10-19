//objective of this class is to launch frontend program

import java.util.Scanner;

public class Frontend {
	//method to start frontend program
    public static void mainFrontend(String accList, String transactionSummaryFile) {
        System.out.println("Welcome to Quinterac (Frontend)! To start, please login.");
        while (true){
            Scanner s = new Scanner(System.in);
            String transactionCode = s.nextLine().trim();
            switch (transactionCode) {
                case "login": LoginMgr.login(accList); break;
                case "logout": LogoutMgr.logout(transactionSummaryFile); break;
                case "deposit": DepositMgr.deposit(); break;
                case "withdraw": WithdrawMgr.withdraw(); break;
                case "transfer": TransferMgr.transfer(); break;
                case "createacct": CreateAccMgr.createacc(); break;
                case "deleteacct": DeleteAccMgr.deleteacc(); break;
                default: System.out.println("Please enter a valid transaction code."); break;
            }
        }
    }
}
