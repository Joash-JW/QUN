public class Account {
	private String accountNumber;
	private int dailyDeposit;
	private int dailyWithdraw;
	private int dailyTransfer;
	
	public Account (String accountNumber) {
		this.accountNumber = accountNumber;
		this.dailyDeposit = 0;
		this.dailyWithdraw = 0;
		this.dailyTransfer = 0;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public int getDailyDeposit() {
		return this.dailyDeposit;
	}
	
	public void increaseDailyDeposit(int x) {
		this.dailyDeposit += x;
	}
	
	public int getDailyWithdraw() {
		return this.dailyWithdraw;
	}
	
	public void increaseDailyWithdraw(int x) {
		this.dailyWithdraw += x;
	}
	
	public int getDailyTransfer() {
		return this.dailyTransfer;
	}
	
	public void increaseDailyTransfer(int x) {
		this.dailyTransfer += x;
	}
}
