import java.util.Arrays;

import org.junit.Test;

public class WithdrawBackendTest {
	@Test
	public void withdrawTest1() throws Exception {
		AppTest.runAndTest2(Arrays.asList("1234567 200000 ***"), 
						Arrays.asList("WDR 1234567 100000 0000000 ***", "EOS 0000000 000 0000000 ***"), 
						Arrays.asList(""), 
						Arrays.asList("1234567 100000 ***"), 
						Arrays.asList("1234567"));
	}
	
	@Test
	public void withdrawTest2() throws Exception {
		AppTest.runAndTest2(Arrays.asList("1234567 100000 *** "), 
						   Arrays.asList("WDR 1234567 100001 0000000 ***", "EOS 0000000 000 0000000 ***"),
						   Arrays.asList("Transaction ignored. " + "1234567" + " would have a negative balance."),
						   Arrays.asList(""), 
						   Arrays.asList("1234567"));
	}
	
}







