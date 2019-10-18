import java.util.Scanner;

public class Quinterac {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().trim().split(" ");
        if (input[0].equals("frontend")) {
            Frontend.mainFrontend(input[1], input[2]);
        }
    }
}
