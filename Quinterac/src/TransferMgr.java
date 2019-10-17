import java.util.Scanner;

public class TransferMgr {
	private static double moneyNum = 0;
	private static double moneySumDaily = 0;
	private static boolean vaildAccount = LoginMgr.isLoggedIn();
	private static boolean transAccount = LoginMgr.isLoggedIn();
	private static boolean flag = (vaildAccount && transAccount);
	private static String modeName = LoginMgr.checkMode();
	
	public static void atmCheckTransferValid() {
		while (flag && (modeName == "machine")) {
			System.out.println("Enter the amount of money to transfer:");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            moneyNum = Double.parseDouble(userInput);
                
            if (moneyNum > 0 && moneyNum < 10000) {
            	System.out.println("Transfer successfully:");
                moneySumDaily += moneyNum;
                atmCheckSumTransfer(moneySumDaily);
                break;
            }
            else {
                System.out.println("Please enter a number between 0 - 10000:");	
            }
		}
	}
	
	public static void agentCheckTransferValid() {
		while (flag && (modeName == "agent")) {
			System.out.println("Enter the amount of money to Transfer:");
	        Scanner sc = new Scanner(System.in);
	        String userInput = sc.nextLine();
	        moneyNum = Double.parseDouble(userInput);
	        
	        if (moneyNum > 0 && moneyNum < 999999.99) {
	        	System.out.println("Transfer successfully:");
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number between 0 - 999999.99:");
	        }
		}
	}
	
	public static void atmCheckSumTransfer(double sumMoney) {
		if (sumMoney > 10000) {
			System.out.println("You can not Transfer more than $10000 daily.");
			flag = false;
		}
	}
}