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
	
	@Test
    public void testAppR3T2() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Enter new account number (7 digits):", "Enter new account name (3 to 30 alphanumeric characters):", 
                		      "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T3() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "0123456"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account number cannot begin with 0.", "Please enter it again.", 
                		"Enter new account name (3 to 30 alphanumeric characters):", "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T4() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "qwertyu"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account number can only contain digits.", "Please enter it again.", 
                		"Enter new account name (3 to 30 alphanumeric characters):", "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T5() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "12345678"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account number must be of length 7.", "Please enter it again.", 
                		"Enter new account name (3 to 30 alphanumeric characters):", "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T6() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "123456"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account number must be of length 7.", "Please enter it again.", 
                		"Enter new account name (3 to 30 alphanumeric characters):", "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T7() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Enter new account name (3 to 30 alphanumeric characters):", "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T8() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234567"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account number already exists.", "Please enter it again.", 
                		"Enter new account name (3 to 30 alphanumeric characters):", "Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T9() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", " qw"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account name cannot begin with a space.", "Please enter it again.", 
                		"Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T10() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "qw "),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account name cannot end with a space.", "Please enter it again.", 
                		"Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T11() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "qw"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter account name between 3 and 30 characters.", "Please enter it again.", 
                		"Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T12() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "abcdefghijklmnopqrstuvwxyzabcde"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter account name between 3 and 30 characters.", "Please enter it again.", 
                		"Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T13() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "qw@"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter alphanumeric characters.", "Please enter it again.", 
                		"Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T14() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "qwe"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T15() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "abcdefghijklmnopqrstuvwxyzabcd"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account has been created. Please logout."),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T16() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "qwerty", "deposit", "1234569"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Please enter a valid account number"),
                Arrays.asList(""));
    }
	
	@Test
    public void testAppR3T17() throws Exception {
        AppTest.runAndTest(Arrays.asList("login", "agent", "createacct", "1234569", "qwerty", "logout"),
                Arrays.asList("1234567", "1234568"),
                Arrays.asList("Account has been created. Please logout.", "You have logged out."),
                Arrays.asList("NEW 1234569 000 0000000 qwerty", "EOS 0000000 000 0000000 ***"));
        //
    }
}
