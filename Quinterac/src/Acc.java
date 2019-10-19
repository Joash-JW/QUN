//objective of this class is to keep track of the daily deposit, withdraw and transfer limits of each account

public class Acc {
	private String accNum;
	private int dailyDeposit;
	private int dailyWithdraw;
	private int dailyTransfer;
	
	//constructor for each account
	public Acc (String accNum) {
		this.accNum = accNum;
		this.dailyDeposit = 0;
		this.dailyWithdraw = 0;
		this.dailyTransfer = 0;
	}
	
	//get account number
	public String getAccNum() {
		return this.accNum;
	}
	
	//get daily deposit amount
	public int getDailyDeposit() {
		return this.dailyDeposit;
	}
	
	//increase the daily deposit amount
	public void increaseDailyDeposit(int x) {
		this.dailyDeposit += x;
	}
	
	//get daily withdraw amount
	public int getDailyWithdraw() {
		return this.dailyWithdraw;
	}
	
	//increase the daily withdraw amount
	public void increaseDailyWithdraw(int x) {
		this.dailyWithdraw += x;
	}
	
	//get daily transfer amount
	public int getDailyTransfer() {
		return this.dailyTransfer;
	}
	
	//increase the daily transfer amount
	public void increaseDailyTransfer(int x) {
		this.dailyTransfer += x;
	}
}
