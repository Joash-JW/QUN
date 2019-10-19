//objective of this class is to launch the Quinterac program
//as input, enter 'frontend ValidAccList.txt TransactionSummary.txt'
//program to be run in command line

import java.util.Scanner;

public class Quinterac {
	//method to start Quinterac program
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().trim().split(" ");
        if (input[0].equals("frontend")) {
            Frontend.mainFrontend(input[1], input[2]);
        }
    }
}
