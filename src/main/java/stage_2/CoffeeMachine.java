package stage_2;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER = 200;
    private static final int MILK = 50;
    private static final int COFFEEBEANS = 15;

    public static void main(String[] args) {
        printCoffeeMessage();
        System.out.println("Write how many cups of coffee you will need:");
        Scanner input = new Scanner(System.in);
        int amountCups = input.nextInt();
        printIngredientResult(amountCups);
    }

    public static void printIngredientResult(int amountCups) {
        System.out.printf("For %d cups of coffee you will need:\n", amountCups);
        System.out.printf("%d ml of water\n", amountCups * WATER);
        System.out.printf("%d ml of milk\n", amountCups * MILK);
        System.out.printf("%d g of coffee beans\n", amountCups * COFFEEBEANS);
    }

    public static void printCoffeeMessage() {
        System.out.println("Starting to make a coffee\n"
                + "Grinding coffee beans\n"
                + "Boiling water\n"
                + "Mixing boiled water with crushed coffee beans\n"
                + "Pouring coffee into the cup\n"
                + "Pouring some milk into the cup\n"
                + "Coffee is ready!\n");
    }
}
