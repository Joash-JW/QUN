import java.util.Arrays;

import org.junit.Test;

public class CreateAccBackendTest {
	@Test
	public void createAccTest1() throws Exception {
		AppTest.runAndTest2(Arrays.asList("1234567 200000 qwerty"),
				Arrays.asList("NEW 1234568 000 0000000 qwertyu", "EOS 0000000 000 0000000 ***"), Arrays.asList(""),
				Arrays.asList("1234568 000 qwertyu", "1234567 200000 qwerty"),
				Arrays.asList("1234568", "1234567", "0000000"));
	}
}
