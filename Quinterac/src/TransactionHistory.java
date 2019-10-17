public class TransactionHistory {
	private String transactionCode;
	private String firstAccountNumber;
	private String amount;
	private String secondAccountNumber;
	private String accountName;
	
	//constructor for each transaction history
	public TransactionHistory() {
		this.transactionCode = null;
		this.firstAccountNumber = "0000000";
		this.amount = "000";
		this.secondAccountNumber = "0000000";
		this.accountName = "***";
	}
	
	//get and set for transaction code
	public String getTransactionCode() {
		return this.transactionCode;
	}
	
	public void setTransactionCode(String s) {
		this.transactionCode = s;
	}
	
	//get and set for first account number
	public String getFirstAccountNumber() {
		return this.firstAccountNumber;
	}
	
	public void setFirstAccountNumber(String s) {
		this.firstAccountNumber = s;
	}
	
	//get and set for amount
	public String getAmount() {
		return this.amount;
	}
	
	public void setAmount(String s) {
		this.amount = s;
	}
	
	//get and set for second account number
	public String getSecondAccountNumber() {
		return this.secondAccountNumber;
	}
	
	public void setSecondAccountNumber(String s) {
		this.secondAccountNumber = s;
	}
	
	//get and set for account name
	public String getAccountName() {
		return this.accountName;
	}
	
	public void setAccountName(String s) {
		this.accountName = s;
	}
}
