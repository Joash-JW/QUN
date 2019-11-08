package backend.data;

public class Account {
  private String accNum;// number of the account
  private int amount;//amount of money in the account
  private String accName;// name of the accoount
  
  //creation of a new account
  public Account (String accNum, String amount, String accName) {
		this.accNum = accNum;
		this.accName = accName;
		this.amount = Integer.parseInt(amount);
	}
  
  //return the amount of money in the account
  public int getAmount () {
    return this.amount;
  }
  
  //return the name of the account
  public String getAccName () {
    return this.accName;
  }
  
  //return the number of the account
  public String getAccNum () {
    return this.accNum;
  }
  
  //change the money in the account for the value given as a 
  public void setAmount(int amount){
    this.amount = amount;
  }
  
}
