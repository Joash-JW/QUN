//objective of this class is to launch the Quinterac program
//program to be run in command line

package main;

import java.util.Scanner;

public class Quinterac {
	//method to start Quinterac program
	public static final Scanner s = new Scanner(System.in);
	
    public static void main(String[] args) {
        if (args[0].equals("frontend")) {
            Frontend.mainFrontend(args[1], args[2]);
        }
        else if (args[0].equals("backend")) {
            Backend.mainBackend(args[1], args[2]);
        }
    }
    
}
