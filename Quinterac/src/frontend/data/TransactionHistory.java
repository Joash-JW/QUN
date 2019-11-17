//objective of this class is to store the information of each transaction

package frontend.data;

public class TransactionHistory {
	private String transactionCode;
	private String firstAccNum;
	private String amount;
	private String secondAccNum;
	private String accName;

	// constructor for each transaction history
	public TransactionHistory() {
		this.transactionCode = null;
		this.firstAccNum = "0000000";
		this.amount = "000";
		this.secondAccNum = "0000000";
		this.accName = "***";
	}

	// get transaction code
	public String getTransactionCode() {
		return this.transactionCode;
	}

	// set transaction code
	public void setTransactionCode(String s) {
		this.transactionCode = s;
	}

	// get first account number
	public String getFirstAccNum() {
		return this.firstAccNum;
	}

	// set first account number
	public void setFirstAccNum(String s) {
		this.firstAccNum = s;
	}

	// get amount
	public String getAmount() {
		return this.amount;
	}

	// set amount
	public void setAmount(String s) {
		this.amount = s;
	}

	// get second account number
	public String getSecondAccNum() {
		return this.secondAccNum;
	}

	// set second account number
	public void setSecondAccNum(String s) {
		this.secondAccNum = s;
	}

	// get account name
	public String getAccName() {
		return this.accName;
	}

	// set account name
	public void setAccName(String s) {
		this.accName = s;
	}
}
