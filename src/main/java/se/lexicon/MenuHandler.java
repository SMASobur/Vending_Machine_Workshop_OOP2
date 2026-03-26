package se.lexicon;

import java.util.Scanner;

class MenuHandler {
    private Scanner scanner;

    public MenuHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    //Prints the interactive main menu options to the console.
    public void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. View available products");
        System.out.println("2. Select a product");
        System.out.println("3. Purchase a product");
        System.out.println("0. ➜] EXIT");
        System.out.print("Choose an option: ");
    }

}
