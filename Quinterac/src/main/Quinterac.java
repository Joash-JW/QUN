//objective of this class is to launch the Quinterac program
//program to be run in command line

package main;

import java.util.Scanner;

public class Quinterac {
	//method to start Quinterac program
	public static final Scanner s = new Scanner(System.in);
	
    public static void main(String[] args) {
        //Scanner s = new Scanner(System.in);
        /*input example
        frontend your_account_list_file.txt your_transaction_summary.txt
        */
        //String input = s.nextLine().trim();
        if (args[0].equals("frontend")) {
            Frontend.mainFrontend(args[1], args[2]);
        }
    }
}
