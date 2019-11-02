import java.util.Arrays;

public class TransferTest {
	public void transferTestR7T1() throws Exception {
		AppTest.runAndTest(Arrays.asList("frontend ValidAccList.txt TransactionSummary.txt",
											"login", "machine", "transfer", "9999999"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a valid account number"), Arrays.asList(""));
	}
	
	public void transferTestR7T2() throws Exception {
		AppTest.runAndTest(Arrays.asList("frontend ValidAccList.txt TransactionSummary.txt",
											"login", "machine", "transfer", "1234567"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Enter account number to accept your transfer: "), Arrays.asList(""));
	}
	
	public void transferTestR7T3() throws Exception {
		AppTest.runAndTest(Arrays.asList("frontend ValidAccList.txt TransactionSummary.txt",
											"login", "machine", "transfer", "1234567", "9999999"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a valid account number"), Arrays.asList(""));
	}
	
	public void transferTestR7T4() throws Exception {
		AppTest.runAndTest(Arrays.asList("frontend ValidAccList.txt TransactionSummary.txt",
											"login", "machine", "transfer", "1234567", "1234568"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Enter the amount of money to transfer in cents: "), Arrays.asList(""));
	}
	
	public void transferTestR7T5() throws Exception {
		AppTest.runAndTest(Arrays.asList("frontend ValidAccList.txt TransactionSummary.txt",
											"login", "machine", "transfer", "1234567", "1234568", "1000001"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a number between 0 - 1000000"), Arrays.asList(""));
	}
	
	//edit this
	public void transferTestR7T6() throws Exception {
		AppTest.runAndTest(Arrays.asList("frontend ValidAccList.txt TransactionSummary.txt",
											"login", "machine", "transfer", "1234567", "1234568", "1000000",
											"logout"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Enter the amount of money to transfer in cents: "), 
							Arrays.asList("XFR 1234567 1000000 1234568 ***", "EOS 0000000 000 0000000 ***"));
	}
}
