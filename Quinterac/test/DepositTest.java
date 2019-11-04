import java.util.Arrays;

import org.junit.Test;

public class DepositTest {
	@Test
	public void testAppR5T1() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "9999999"), Arrays.asList("1234567"),
							Arrays.asList("Please enter a valid account number"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR5T2() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "1234567"), Arrays.asList("1234567"),
						   Arrays.asList("Enter the amount of money to deposit in cents: ", "Deposit successfully!"), 
						   Arrays.asList(""));
	}
	
	@Test
	public void testAppR5T3() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "1234567", "200001"), Arrays.asList("1234567"),
							Arrays.asList("Please enter a number between 0 - 200000"), Arrays.asList(""));
	}
	
	@Test
	public void testAppR5T4() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "1234567", "200000", "logout"), Arrays.asList("1234567"),
							Arrays.asList("Deposit successfully:", "You have logged out."), 
							Arrays.asList("DEP 1234567 200000 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR5T5() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "1234567", "199999", "logout"), Arrays.asList("1234567"),
							Arrays.asList("Deposit successfully:", "You have logged out."), 
							Arrays.asList("DEP 1234567 199999 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR5T6() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "deposit", "1234567", "100000000"), Arrays.asList("1234567"),
							Arrays.asList("Please enter a number between 0 - 99999999"),
							Arrays.asList(""));
	}
	
	@Test
	public void testAppR5T7() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "deposit", "1234567", "99999999", "logout"), Arrays.asList("1234567"),
							Arrays.asList("Deposit successfully:", "You have logged out."),
							Arrays.asList("DEP 1234567 99999999 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR5T8() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "agent", "deposit", "1234567", "99999998", "logout"), Arrays.asList("1234567"),
							Arrays.asList("Deposit successfully:", "You have logged out."),
							Arrays.asList("DEP 1234567 99999998 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR5T9() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "1234567", "200000", "deposit", "1234567", "200000", "deposit", "1234567", "100001", "logout"), 
							Arrays.asList("1234567"),
							Arrays.asList("You have exceeded the daily limit", "You have logged out."),
							Arrays.asList("DEP 1234567 20000000 0000000 ***", "DEP 1234567 20000000 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
	@Test
	public void testAppR5T10() throws Exception {
		AppTest.runAndTest(Arrays.asList("login", "machine", "deposit", "1234567", "200000", "deposit", "1234567", "200000", "deposit", "1234567", "100000", "logout"),
							Arrays.asList("1234567"),
							Arrays.asList("Deposit successfully:", "You have logged out."),
							Arrays.asList("DEP 1234567 20000000 0000000 ***","DEP 1234567 20000000 0000000 ***","DEP 1234567 10000000 0000000 ***", "EOS 0000000 000 0000000 ***"));
	}
	
}

