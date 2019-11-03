import java.util.Arrays;

import org.junit.Test;

public class LogoutTest {
    @Test
    public void testAppR2T1() throws Exception {
        runAndTest(Arrays.asList("login", "machine", "logout", "logout"),
                Arrays.asList("1234567"),
                Arrays.asList("Please use agent mode."),
                null);
    }
    
    
    @Test
    public void testAppR2T2() throws Exception {
        runAndTest(Arrays.asList("login", "machine", "logout", "createacct"),
                Arrays.asList("1234567"),
                Arrays.asList("Please use agent mode."),
                null);
    }
    
    
    @Test
    public void testAppR2T3() throws Exception {
        runAndTest(Arrays.asList("login", "machine", "logout", "deleteacct"),
                Arrays.asList("1234567"),
                Arrays.asList("Please use agent mode."),
                null);
    }
    
