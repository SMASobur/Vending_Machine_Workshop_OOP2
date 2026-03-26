package se.lexicon;
// This will help to choice the int type value for the menu selection in Main.java
import java.util.Scanner;

public class GetUserChoice {

    public static int getInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            // Check if the user just pressed Enter or typed only spaces
            if (input.trim().isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue; // Restart the loop to ask again
            }

            try {
                // Attempt to convert the string input into an integer
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Catches errors if the input contains letters or symbols
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}