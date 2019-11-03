import java.util.Arrays;

import org.junit.Test;

public class LogoutTest {
    @Test
    public void testAppR2T1() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout", "logout"),
                Arrays.asList("1234567"),
                Arrays.asList("Please login first."),
                null);
    }
    
    
    @Test
    public void testAppR2T2() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout", "createacct"),
                Arrays.asList("1234567"),
                Arrays.asList("Please login first."),
                null);
    }
    
    
    @Test
    public void testAppR2T3() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout", "deleteacct"),
                Arrays.asList("1234567"),
                Arrays.asList("Please login first."),
                null);
    }
    
    
    @Test
    public void testAppR2T4() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout", "deposit"),
                Arrays.asList("1234567"),
                Arrays.asList("Please login first."),
                null);
    }
    
    
    @Test
    public void testAppR2T5() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout", "withdraw"),
                Arrays.asList("1234567"),
                Arrays.asList("Please login first."),
                null);
    }
    
    
    @Test
    public void testAppR2T6() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout", "transfer"),
                Arrays.asList("1234567"),
                Arrays.asList("Please login first."),
                null);
    }
    
    
    @Test
    public void testAppR2T7() throws Exception {
         AppTest.runAndTest(Arrays.asList("login", "machine", "logout"),
                Arrays.asList("1234567"),
                Arrays.asList("You have logged out."),
                null);
    }
}
    
