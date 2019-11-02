import java.util.Arrays;

import org.junit.Test;

public class CreateAccTest {
	@Test
    public void testAppR3T1() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "machine", "createacct"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please use agent mode."),
                Arrays.asList(""));
    }
}
