import java.util.Scanner;

public class WithdrawMgr {
	private static double moneyNum = 0;
	private static double moneySumDaily = 0;
	private static boolean vaildAccount = LoginMgr.isLoggedIn();
	private static boolean flag = vaildAccount;
	private static String modeName = LoginMgr.checkMode();
	
	public static void atmCheckWithdrawValid() {
		while (flag && (modeName == "machine")) {
			System.out.println("Enter the amount of money to withdraw:");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            moneyNum = Double.parseDouble(userInput);
                
            if (moneyNum > 0 && moneyNum < 1000) {
            	System.out.println("withdraw successfully:");
                moneySumDaily += moneyNum;
                atmCheckSumWithdraw(moneySumDaily);
                break;
            }
            else {
                System.out.println("Please enter a number between 0 - 1000:");	
            }
		}
	}

	
	public static void agentCheckWithdrawValid() {
		while (flag && (modeName == "agent")) {
			System.out.println("Enter the amount of money to withdraw:");
	        Scanner sc = new Scanner(System.in);
	        String userInput = sc.nextLine();
	        moneyNum = Double.parseDouble(userInput);
	        
	        if (moneyNum > 0 && moneyNum < 999999.99) {
	        	System.out.println("withdraw successfully:");
	        	break;
	        }
	        else {
	        	System.out.println("Please enter a number between 0 - 999999.99:");
	        }
		}
	}
	
	public static void atmCheckSumWithdraw(double sumMoney) {
		if (sumMoney > 5000) {
			System.out.println("You can not Withdraw more than $5000 daily.");
			flag = false;
		}
	}
}
