import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Quinterac;

public class AppTest {

	/**
	 * Helper function to run the main function and verify the output for frontend
	 * 
	 * @param terminal_input                 A list of string as the terminal input
	 *                                       to run the program
	 * 
	 * @param valid_accounts                 A list of valid accounts to be used for
	 *                                       the test case
	 * 
	 * @param expected_terminal_tails        A list of string expected at the tail
	 *                                       of terminal output
	 * 
	 * @param expected_transaction_summaries A list of string expected to be in the
	 *                                       output transaction summary file
	 * 
	 * @throws Exception
	 */
	public static void runAndTest(List<String> terminal_input, //
			List<String> valid_accounts, //
			List<String> expected_terminal_tails, //
			List<String> expected_transaction_summaries) throws Exception {

		// setup parameters for the program to run
		// create temporary files
		File valid_account_list_file = File.createTempFile("valid-accounts", ".tmp");
		Files.write(valid_account_list_file.toPath(), String.join("\n", valid_accounts).getBytes());

		File transaction_summary_file = File.createTempFile("transactions", ".tmp");

		String[] args = { "frontend", valid_account_list_file.getAbsolutePath(),
				transaction_summary_file.getAbsolutePath() };

		// setup user input
		String userInput = String.join(System.lineSeparator(), terminal_input);
		ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);

		// setup stdin & stdout:
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));

		// run the program
		Quinterac.main(args);

		// capture terminal outputs:
		String[] printed_lines = outContent.toString().split("[\r\n]+");

		// compare the tail of the terminal outputs:
		int diff = printed_lines.length - expected_terminal_tails.size();
		for (int i = 0; i < expected_terminal_tails.size(); ++i) {
			assertEquals(expected_terminal_tails.get(i), printed_lines[i + diff]);
		}

		// compare output file content to the expected content
		String actual_output = new String(Files.readAllBytes(transaction_summary_file.toPath()), "UTF-8");
		String[] lines = actual_output.split("[\r\n]+");
		for (int i = 0; i < lines.length; ++i)
			assertEquals(expected_transaction_summaries.get(i), lines[i]);

	}

	/**
	 * Helper function to run the main function and verify the output for backend
	 * 
	 * @param old_master_acc             A list of valid accounts to be used for
	 *                                   test case
	 * 
	 * @param merged_transaction_summary A list of transaction summaries to be used
	 *                                   for test case
	 * 
	 * @param expected_terminal_tails    A list of string expected at the tail of
	 *                                   terminal output
	 * 
	 * @param expected_master_acc        A list of string expected to be in the
	 *                                   output master accounts file
	 * 
	 * @param expected_valid_acc         A list of string expected to be in the
	 *                                   output valid accounts file
	 * 
	 * @throws Exception
	 */
	public static void runAndTest2(List<String> old_master_acc, //
			List<String> merged_transaction_summary, //
			List<String> expected_terminal_tails, //
			List<String> expected_master_acc, //
			List<String> expected_valid_acc) throws Exception {

		// setup parameters for the program to run
		// create temporary files
		File old_master_acc_file = File.createTempFile("old-master-acc", ".tmp");
		Files.write(old_master_acc_file.toPath(), String.join("\n", old_master_acc).getBytes());

		File merged_transaction_summary_file = File.createTempFile("merged-trans-sum", ".tmp");
		Files.write(merged_transaction_summary_file.toPath(), String.join("\n", merged_transaction_summary).getBytes());

		String[] args = { "backend", old_master_acc_file.getAbsolutePath(),
				merged_transaction_summary_file.getAbsolutePath() };

		// setup stdout:
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));

		// run the program
		Quinterac.main(args);

		// capture terminal outputs:
		String[] printed_lines = outContent.toString().split("[\r\n]+");

		// compare the tail of the terminal outputs:
		int diff = printed_lines.length - expected_terminal_tails.size();
		for (int i = 0; i < expected_terminal_tails.size(); ++i) {
			assertEquals(expected_terminal_tails.get(i), printed_lines[i + diff]);
		}

		// compare output file content to the expected content
		String actual_output1 = new String(Files.readAllBytes(old_master_acc_file.toPath()), "UTF-8");
		String[] lines = actual_output1.split("[\r\n]+");
		for (int i = 0; i < lines.length; ++i)
			assertEquals(expected_master_acc.get(i), lines[i]);

		Path currentDir = Paths.get(".");
		String parentPath = currentDir.getParent().toAbsolutePath().toString();
		List<String> lines2 = new ArrayList<String>();
		Scanner file_valid_acc = new Scanner(new File(parentPath + "\\src\\ValidAccList.txt"));
		while (file_valid_acc.hasNextLine()) {
			lines2.add(file_valid_acc.nextLine());
		}
		for (int i = 0; i < lines2.size(); ++i)
			assertEquals(expected_valid_acc.get(i), lines2.get(i));

	}

	/**
	 * Retrieve the absolute path of the files in the resources folder
	 * 
	 * @param relativePath The file's relative path in the resources folder
	 *                     (/test/resources)
	 * @return the absolute path of the file in the resource folder.
	 */
	String getFileFromResource(String relativePath) {
		return new File(this.getClass().getResource(relativePath).getFile()).getAbsolutePath();
	}
}