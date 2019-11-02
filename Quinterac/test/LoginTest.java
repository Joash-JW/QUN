import java.util.Arrays;

import org.junit.Test;

public class LoginTest {
	@Test
    public void testAppR1T1() throws Exception {
        AppTest.runAndTest(Arrays.asList("logout"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please login first."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR1T2() throws Exception {
        AppTest.runAndTest(Arrays.asList("createacct"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please login first."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR1T6() throws Exception {
        AppTest.runAndTest(Arrays.asList("login"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Enter type of Session (machine or agent):"),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR1T10() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "machine"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("You have logged in."),
                Arrays.asList(""));
    }
}
