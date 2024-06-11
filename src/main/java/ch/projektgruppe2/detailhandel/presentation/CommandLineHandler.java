package ch.projektgruppe2.detailhandel.presentation;
import java.util.InputMismatchException;
import java.util.Scanner;

import ch.projektgruppe2.detailhandel.business.Product;
import ch.projektgruppe2.detailhandel.business.ProductFactory;

public class CommandLineHandler {
    private final ProductFactory productFactory;

    public CommandLineHandler() {
        this.productFactory = ProductFactory.getInstance();
    }

    public void handleCreateProduct() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Produkt Name: ");
            String name = scanner.nextLine();

            System.out.print("Produkt Beschreibung: ");
            String description = scanner.nextLine();

            System.out.print("Produkt Inventar: ");
            int inventory = scanner.nextInt();


            Product product = productFactory.createProduct(name, description, inventory);
            productFactory.saveProduct(product);
            System.out.println("Produkt erfolgreich erstellt!" + product);
        } catch (InputMismatchException e) {
            System.out.println("Falsche Eingabe. Numerische Eingabe erwartet. Produkt Erstellung abgebrochen");
        }
    }

    public void handleShowProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Produkt ID: ");
        try {
            long id = scanner.nextLong();

            Product product = productFactory.displayProduct(id);
            if (product != null) {
                System.out.println("Produkt ID: " + product.getId());
                System.out.println("Produkt Name: " + product.getName());
                System.out.println("Produkt Beschreibung: " + product.getDescription());
                System.out.println("Produkt Inventar: " + product.getInventory());
            } else {
                System.out.println("Produkt nicht gefunden.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Falsche Eingabe.");
        }
        
    }

    public static void main(String[] args) {
        CommandLineHandler handler = new CommandLineHandler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sie haben folgende Möglichkeiten");
            System.out.println("1. Produkt erstellen");
            System.out.println("2. Produkt anzeigen");
            System.out.println("3. Beenden");
            System.out.print("Auswahl: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handler.handleCreateProduct();
                    break;
                case 2:
                    handler.handleShowProduct();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Ungültige Auswahl. Bitte erneut versuchen.");
            }
        }
    }
}
