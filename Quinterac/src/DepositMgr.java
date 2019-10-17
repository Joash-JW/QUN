import java.util.Scanner;

public class DepositMgr {
	private static double moneyNum = 0;
	private static double moneySumDaily = 0;
	private static boolean vaildAccount = LoginMgr.isLoggedIn();
	private static boolean flag = vaildAccount;
	private static String modeName = LoginMgr.checkMode();
	
	public static void atmCheckDepositValid() {
		while (flag && (modeName == "machine")) {
			System.out.println("Enter the amount of money to Deposit:");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            moneyNum = Double.parseDouble(userInput);
                
            if (moneyNum > 0 && moneyNum < 2000) {
            	System.out.println("Deposit successfully:");
                moneySumDaily += moneyNum;
                atmCheckSumDeposit(moneySumDaily);
                break;
            }
            else {
                System.out.println("Please enter a number between 0 - 2000:");	
            }
		}
	}

	
	public static void agentCheckDepositValid() {
		while (flag && (modeName == "agent")) {
			System.out.println("Enter the amount of money to Deposit:");
	        Scanner sc = new Scanner(System.in);
	        String userInput = sc.nextLine();
	        moneyNum = Double.parseDouble(userInput);
	        
	        if (moneyNum > 0 && moneyNum < 999999.99) {
	        	System.out.println("Deposit successfully:");
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number between 0 - 999999.99:");
	        }
		}
	}
	
	public static void atmCheckSumDeposit(double sumMoney) {
		if (sumMoney > 5000) {
			System.out.println("You can not deposit more than $5000 daily.");
			flag = false;
		}
	}
}
