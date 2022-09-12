package stage_3;

import java.util.Scanner;

public class CoffeeMachine {

    private static final int WATER = 200;
    private static final int MILK = 50;
    private static final int COFFEEBEANS = 15;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int amountWater = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int amountMilk = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int amountBeans = input.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int wantedCups = input.nextInt();

        int possibleCups = countPossibleCups(amountWater, amountMilk, amountBeans);

        if (wantedCups > possibleCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", possibleCups);
        } else if (wantedCups == possibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("Yes, I can make that amount of coffee and even %d more of that",
                    possibleCups - wantedCups);
        }

        // printIngredientResult(wantedCups);
        // printCoffeeMessage();
    }

    public static int countPossibleCups(int amountWater,
                                        int amountMilk,
                                        int amountBeans) {
        int cups = amountWater / WATER;
        if (amountMilk / MILK < cups) {
            cups = amountMilk / MILK;
        } else if (amountBeans / COFFEEBEANS < cups) {
            cups = amountBeans / COFFEEBEANS;
        }
        return cups;
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