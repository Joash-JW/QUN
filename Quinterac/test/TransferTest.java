import java.util.Arrays;

import org.junit.Test;

public class TransferTest {
	@Test
	public void testAppR7T1() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "9999999"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a valid account number"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR7T2() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567"), Arrays.asList("1234567", "1234568"),
						   Arrays.asList("Enter account number to accept your transfer: ", "Please enter a valid account number"), 
						   Arrays.asList(""));
	}
	
	@Test
	public void testAppR7T3() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567", "9999999"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a valid account number"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR7T4() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567", "1234568"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Enter the amount of money to transfer in cents: ", "Transfer successful!"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR7T5() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567", "1234568", "1000001"), Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a number between 0 - 1000000"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR7T6() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567", "1234568", "1000000", "logout"), 
							Arrays.asList("1234567", "1234568"),
							Arrays.asList("Transfer successful!", "You have logged out."),
							Arrays.asList("XFR 1234567 1000000 1234568 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR7T7() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567", "1234568", "999999", "logout"), 
							Arrays.asList("1234567", "1234568"),
							Arrays.asList("Transfer successful!", "You have logged out."),
							Arrays.asList("XFR 1234567 999999 1234568 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR7T8() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "transfer", "1234567", "1234568", "100000000"), 
							Arrays.asList("1234567", "1234568"),
							Arrays.asList("Please enter a number between 0 - 99999999"),
							Arrays.asList(""));
	}
	
	@Test
	public void testAppR7T9() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "transfer", "1234567", "1234568", "99999999", "logout"), 
							Arrays.asList("1234567", "1234568"),
							Arrays.asList("Transfer successful!", "You have logged out."),
							Arrays.asList("XFR 1234567 99999999 1234568 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR7T10() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "transfer", "1234567", "1234568", "99999998", "logout"), 
							Arrays.asList("1234567", "1234568"),
							Arrays.asList("Transfer successful!", "You have logged out."),
							Arrays.asList("XFR 1234567 99999998 1234568 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR7T11() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "transfer", "1234567", "1234568", "1000000", "transfer", "1234567", "1234568", "1", "logout"), 
							Arrays.asList("1234567", "1234568"),
							Arrays.asList("You have exceeded the daily limit", "You have logged out."),
							Arrays.asList("XFR 1234567 1000000 1234568 ***", "EOS 0000000 000 0000000 ***"));
	}
}
