import java.util.Arrays;

import org.junit.Test;

public class DeleteAccTest {
    @Test
    public void testAppR4T1() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "machine", "deleteacct"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please use agent mode."),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T2() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Enter account number (7 digits):"),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T3() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct", "9999999"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter a valid account number"),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T4() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct", "1234567"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Enter account name (3 to 30 alphanumeric characters):"),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T5() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct", "1234567", "qwerty", "deposit", "1234567"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter a valid account number"),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T6() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct", "1234567", "qwerty", "withdraw", "1234567"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter a valid account number"),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T7() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct", "1234567", "qwerty", "transfer", "1234567"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter a valid account number"),
                Arrays.asList(""));
    }

    @Test
    public void testAppR4T8() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "deleteacct", "1234567", "qwerty", "logout"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account has been deleted. Please logout.", "You have logged out."),
                Arrays.asList("DEL 1234567 000 0000000 qwerty", "EOS 0000000 000 0000000 ***"));
    }
}