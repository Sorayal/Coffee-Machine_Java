package stage_4;

import java.math.BigDecimal;
import java.util.Scanner;

public class CoffeeMachine {

    private static final int WATER = 200;
    private static final int MILK = 50;
    private static final int COFFEEBEANS = 15;

    private static BigDecimal money = BigDecimal.valueOf(550);
    private static int water = 400;
    private static int milk = 540;
    private static int coffeebeans = 120;
    private static int disposableCups = 9;

    public static void main(String[] args) {
        printStatusMessage();
        System.out.println("Write action (buy, fill, take):");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice) {
            case "buy":
                buyCoffeeDialog();
                break;
            case "fill":
                inputForFillMachine();
                break;
            case "take":
                takeMoneyAndPrintMessage();
                break;
            default:
                System.out.println("No valid choice");
                break;
        }
        printStatusMessage();

        // askingForIngredientsAndCoffee();
        // printIngredientResult(wantedCups);
        // printCoffeeProcessMessage();
    }

    public static void buyCoffeeDialog() {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                takeOneEspresso();
                break;
            case "2":
                takeOneLatte();
                break;
            case "3":
                takeOneCappuccino();
                break;
            default:
                System.out.println("No valid choice");
        }
    }

    public static void takeOneEspresso() {
        water -= 250;
        coffeebeans -= 16;
        disposableCups -= 1;
        money = money.add(BigDecimal.valueOf(4));
    }

    public static void takeOneLatte() {
        water -= 350;
        milk -= 75;
        coffeebeans -= 20;
        disposableCups -= 1;
        money = money.add(BigDecimal.valueOf(7));
    }

    public static void takeOneCappuccino() {
        water -= 200;
        milk -= 100;
        coffeebeans -= 12;
        disposableCups -= 1;
        money = money.add(BigDecimal.valueOf(6));
    }

    public static void takeMoneyAndPrintMessage() {
        System.out.printf("I gave you $%.0f\n", money);
        money = BigDecimal.valueOf(0);
    }

    public static void inputForFillMachine() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int addWater = input.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = input.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addCoffeeBeans = input.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCups = input.nextInt();
        fillMachine(addWater, addMilk, addCoffeeBeans, addCups);
    }

    public static void fillMachine(int addWater, int addMilk, int addCoffeeBeans, int addCups) {
        water += addWater;
        milk += addMilk;
        coffeebeans += addCoffeeBeans;
        disposableCups += addCups;
    }

    public static void printStatusMessage() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%.0f of money\n\n", water, milk, coffeebeans, disposableCups, money);
    }

    public static void askingForIngredientsAndCoffee() {
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
        returnMessageAboutCoffeeOrder(wantedCups, possibleCups);
    }

    public static void returnMessageAboutCoffeeOrder(int wantedCups, int possibleCups) {
        if (wantedCups > possibleCups) {
            System.out.printf("No, I can make only %d cup(s) of coffee", possibleCups);
        } else if (wantedCups == possibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("Yes, I can make that amount of coffee and even %d more of that",
                    possibleCups - wantedCups);
        }
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

    public static void printCoffeeProcessMessage() {
        System.out.println("Starting to make a coffee\n"
                + "Grinding coffee beans\n"
                + "Boiling water\n"
                + "Mixing boiled water with crushed coffee beans\n"
                + "Pouring coffee into the cup\n"
                + "Pouring some milk into the cup\n"
                + "Coffee is ready!\n");
    }
}
