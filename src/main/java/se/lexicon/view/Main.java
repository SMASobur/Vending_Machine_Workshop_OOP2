package se.lexicon.view;

import se.lexicon.model.Beverage;
import se.lexicon.model.Fruit;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;
import se.lexicon.service.IVendingMachine;
import se.lexicon.service.VendingMachineImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MenuHandler menuHandler = new MenuHandler(scanner);
    private static IVendingMachine machine;


    public static void main(String[] args) {
        // Setup initial products
        setupVendingMachine();

        int choice;
        do {
            menuHandler.displayMainMenu();

            choice = GetUserChoice.getInt(scanner, "Choice: ");

            switch (choice){
                case 1:
                    displayProducts();
                    break;
                case 2:
                    handleInsertCoin();
                    break;
                case 3:
                    handlePurchase();
                    break;
                case 4:
                    System.out.println("Available Balance: " + machine.getBalance());
                    break;
                case 0:
                    int change = machine.returnChange();
                    System.out.println("Returning change: " + change + " SEK");
                    System.out.println("...*ੈ✩༺ Goodbye ༻*ੈ✩...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1-3. 0->Exit.");
            }
        } while (choice!=0);

    }

    private static void setupVendingMachine() {
        List<Product> initialStock = new ArrayList<>();
        initialStock.add(new Snack(1, "Snickers", 25, 5, false));
        initialStock.add(new Beverage(2, "Coca Cola", 20, 10, 330));
        initialStock.add(new Fruit(3, "Apple", 10, 15, true));

        machine = new VendingMachineImpl(initialStock);
    }
    private static void displayProducts() {
        System.out.println("\n--- Available Products ---");
        for (Product p : machine.getProducts()) {
            System.out.println(p.getDescription());
        }
    }

    private static void handleInsertCoin() {
        int coin = GetUserChoice.getInt(scanner, "Insert coin (1, 2, 5, 10, 20, 50): ");
        machine.insertCoin(coin);
        System.out.println("You have inserted a coin. \nYour Balance: " + machine.getBalance());
    }

    private static void handlePurchase() {
        int id = GetUserChoice.getInt(scanner, "Enter Product ID to buy: ");
        Product bought = machine.purchaseProduct(id);

        if (bought != null) {
            System.out.println("Successfully purchased: " + bought.getName());
            System.out.println("Interaction: " + bought.getDescription());
        } else {
            System.out.println("Purchase failed! Check your balance or if the item is out of stock.");
        }
    }

}
