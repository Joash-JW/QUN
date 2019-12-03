//objective of this class is to launch frontend program

package main;

import frontend.applogic.CreateAccMgr;
import frontend.applogic.DeleteAccMgr;
import frontend.applogic.DepositMgr;
import frontend.applogic.LoginMgr;
import frontend.applogic.LogoutMgr;
import frontend.applogic.TransferMgr;
import frontend.applogic.WithdrawMgr;

public class Frontend {
	// method to start frontend program
	static int count = 0;

	public static void mainFrontend(String accList, String transactionSummaryFile) {
		System.out.println("Welcome to Quinterac (Frontend)! To start, please login.");
		while (Quinterac.s.hasNextLine()) {
			// Scanner s = new Scanner(System.in);
			String transactionCode = Quinterac.s.nextLine().trim();
			switch (transactionCode) {
			case "login":
				LoginMgr.login(accList);
				break;
			case "logout":
				LogoutMgr.logout(transactionSummaryFile);
				return;
			case "deposit":
				DepositMgr.deposit();
				break;
			case "withdraw":
				WithdrawMgr.withdraw();
				break;
			case "transfer":
				TransferMgr.transfer();
				break;
			case "createacct":
				CreateAccMgr.createacc();
				break;
			case "deleteacct":
				DeleteAccMgr.deleteacc();
				break;
			default:
				System.out.println("Please enter a valid transaction code.");
				break;
			}
		}
	}
}
