import java.util.Arrays;

import org.junit.Test;

public class WithdrawTest {
	@Test
	public void testAppR6T1() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "9999999"), Arrays.asList("1234567"),
							Arrays.asList("Please enter a valid account number:"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR6T2() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "1234567"), Arrays.asList("1234567"),
						   Arrays.asList("Enter the amount of money to withdraw in cents:", "Withdraw successfully!"),
						   Arrays.asList(""));
	}
	
	@Test
	public void testAppR6T3() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "1234567", "100001"), Arrays.asList("1234567"),
							Arrays.asList("Please enter a number between 0 - 200000:"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR6T4() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "1234567", "100000", "logout"), Arrays.asList("1234567"),
							Arrays.asList("You have exceeded the daily limit.","You have logged out."),
							Arrays.asList("WDR 1234567 100000 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR6T5() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "1234567", "99999", "logout"), Arrays.asList("1234567"),
							Arrays.asList("You have exceeded the daily limit.","You have logged out."),
							Arrays.asList("WDR 1234567 99999 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR6T6() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "withdraw", "1234567", "100000000"), Arrays.asList("1234567"),
							Arrays.asList("Please enter a number between 0 - 99999999:"),
							Arrays.asList(""));
	}
	
	@Test
	public void testAppR6T7() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "withdraw", "1234567", "99999999", "logout"), Arrays.asList("1234567"),
							Arrays.asList("Withdraw successfully!","You have logged out."),
							Arrays.asList("WDR 1234567 99999999 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR6T8() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "withdraw", "1234567", "99999998", "logout"), Arrays.asList("1234567"),
							Arrays.asList("Withdraw successfully!","You have logged out."),
							Arrays.asList("WDR 1234567 99999998 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR6T9() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "1234567", "100000", "withdraw", "1234567", "100000", "withdraw", "1234567", "100000", "withdraw", "1234567", "100000","withdraw", "1234567", "100000","withdraw", "1234567", "1","logout"), 
							Arrays.asList("1234567"),
							Arrays.asList("You have exceeded the daily limit.","You have logged out."),
							Arrays.asList("WDR 1234567 10000000 0000000 ***", "WDR 1234567 10000000 0000000 ***","WDR 1234567 10000000 0000000 ***","WDR 1234567 10000000 0000000 ***","WDR 1234567 10000000 0000000 ***","EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR6T10() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "withdraw", "1234567", "100000", "withdraw", "1234567", "100000", "withdraw", "1234567", "100000", "withdraw", "1234567", "100000","withdraw", "1234567", "100000","logout"),
							Arrays.asList("1234567"),			   
							Arrays.asList("Withdraw successfully!","You have logged out."),
							Arrays.asList("WDR 1234567 10000000 0000000 ***", "WDR 1234567 10000000 0000000 ***","WDR 1234567 10000000 0000000 ***","WDR 1234567 10000000 0000000 ***","WDR 1234567 10000000 0000000 ***","EOS 0000000 000 0000000 ***"));
	}
	
}







