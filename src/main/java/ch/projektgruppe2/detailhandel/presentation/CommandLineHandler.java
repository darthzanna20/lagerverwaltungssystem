package ch.projektgruppe2.detailhandel.presentation;
import java.util.Scanner;

import ch.projektgruppe2.detailhandel.business.BCProduct;
import ch.projektgruppe2.detailhandel.business.Product;
import ch.projektgruppe2.detailhandel.business.ProductFactory;

public class CommandLineHandler {
    private final ProductFactory productFactory;

    public CommandLineHandler() {
        this.productFactory = ProductFactory.getInstance();
    }

    public void handleCreateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Produkt ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();  

        System.out.print("Produkt Name: ");
        String name = scanner.nextLine();

        System.out.print("Produkt Beschreibung: ");
        String description = scanner.nextLine();

        System.out.print("Produkt Inventar: ");
        int inventory = scanner.nextInt();

        Product product = new BCProduct();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setInventory(inventory);

        productFactory.createProduct(product);

        System.out.println("Produkt erfolgreich erstellt!");
    }

    public void handleShowProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Produkt ID anzeigen: ");
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
    }

    public static void main(String[] args) {
        CommandLineHandler handler = new CommandLineHandler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
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
