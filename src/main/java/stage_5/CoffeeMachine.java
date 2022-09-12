package stage_5;

import java.math.BigDecimal;
import java.util.Scanner;

public class CoffeeMachine {

    /* initial resources for coffee machine */
    private static BigDecimal money = BigDecimal.valueOf(550);
    private static int water = 400;
    private static int milk = 540;
    private static int coffeebeans = 120;
    private static int disposableCups = 9;

    /* resource demand for Cappuccino */
    private static final int WATER_FOR_CAPPUCCINO = 200;
    private static final int MILK_FOR_CAPPUCCINO = 100;
    private static final int COFFEE_FOR_CAPPUCCINO = 12;
    private static final int PRICE_FOR_CAPPUCCINO = 6;

    /* resource demand for Latte */
    private static final int WATER_FOR_LATTE = 350;
    private static final int MILK_FOR_LATTE = 75;
    private static final int COFFEE_FOR_LATTE = 20;
    private static final int PRICE_FOR_LATTE = 7;

    /* resource demand for Espresso */
    private static final int WATER_FOR_ESPRESSO = 250;
    private static final int MILK_FOR_ESPRESSO = 0;
    private static final int COFFEE_FOR_ESPRESSO = 16;
    private static final int PRICE_FOR_ESPRESSO = 4;

    public static void main(String[] args) {
        boolean shouldNotEnd = true;
        while (shouldNotEnd) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
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
                case "remaining":
                    printStatusMessage();
                    break;
                case "exit":
                    shouldNotEnd = false;
                    break;
                default:
                    System.out.println("No valid choice");
                    break;
            }
        }
    }

    /**
     * Main dialog for buying a coffee
     */
    private static void buyCoffeeDialog() {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
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
            case "back":
                break;
            default:
                System.out.println("No valid choice");
        }
    }

    /**
     * Method to take one Espresso.
     * Checks before if enough resources are available
     * Hands out an Espresso if yes, otherwise nothing happens.
     */
    private static void takeOneEspresso() {
        if (checkForResources("Espresso")) {
            servingMessage();
            water -= WATER_FOR_ESPRESSO;
            coffeebeans -= COFFEE_FOR_ESPRESSO;
            disposableCups -= 1;
            money = money.add(BigDecimal.valueOf(PRICE_FOR_ESPRESSO));
        }
    }

    /**
     * Method to take one Latte.
     * Checks before if enough resources are available
     * Hands out a Latte if yes, otherwise nothing happens.
     */
    private static void takeOneLatte() {
        if (checkForResources("Latte")) {
            servingMessage();
            water -= WATER_FOR_LATTE;
            milk -= MILK_FOR_LATTE;
            coffeebeans -= COFFEE_FOR_LATTE;
            disposableCups -= 1;
            money = money.add(BigDecimal.valueOf(PRICE_FOR_LATTE));
        }
    }

    /**
     * Method to take one Cappuccino.
     * Checks before if enough resources are available
     * Hands out a Cappuccino if yes, otherwise nothing happens.
     */
    private static void takeOneCappuccino() {
        if (checkForResources("Cappuccino")) {
            servingMessage();
            water -= WATER_FOR_CAPPUCCINO;
            milk -= MILK_FOR_CAPPUCCINO;
            coffeebeans -= COFFEE_FOR_CAPPUCCINO;
            disposableCups -= 1;
            money = money.add(BigDecimal.valueOf(PRICE_FOR_CAPPUCCINO));
        }
    }

    /**
     * Serving message for successful buy
     */
    private static void servingMessage() {
        System.out.println("I have enough resources, making you a coffee!");
    }

    /**
     * Error message for lack of resources
     */
    private static void lackOfResourcesMessage(String resource) {
        System.out.printf("Sorry not enough %s!\n", resource);
    }

    /**
     * @param coffeeType - takes the coffee type. If it does not exist,
     *                   it returns false and pops up a message
     * @return returns true if enough resources are available
     */
    private static boolean checkForResources(String coffeeType) {
        switch (coffeeType) {
            case "Cappuccino":
                boolean hasEnough = checkForWater(WATER_FOR_CAPPUCCINO)
                        && checkForMilk(MILK_FOR_CAPPUCCINO)
                        && checkForCoffee(COFFEE_FOR_CAPPUCCINO)
                        && checkForCups(1);
                if (hasEnough) {
                    return true;
                }
                break;
            case "Latte":
                hasEnough = checkForWater(WATER_FOR_LATTE)
                        && checkForMilk(MILK_FOR_LATTE)
                        && checkForCoffee(COFFEE_FOR_LATTE)
                        && checkForCups(1);
                if (hasEnough) {
                    return true;
                }
                break;
            case "Espresso":
                hasEnough = checkForWater(WATER_FOR_ESPRESSO)
                        && checkForMilk(MILK_FOR_ESPRESSO)
                        && checkForCoffee(COFFEE_FOR_ESPRESSO)
                        && checkForCups(1);
                if (hasEnough) {
                    return true;
                }
                break;
            default:
                System.out.println("No valid coffee type");
                break;
        }
        return false;
    }

    /**
     * Sub method to check for enough water
     *
     * @param waterDemand - the amount of needed water
     * @return true if it has enough water, otherwise a specific message
     * pops up, and it returns false
     */
    private static boolean checkForWater(int waterDemand) {
        if (water - waterDemand >= 0) {
            return true;
        }
        lackOfResourcesMessage("water");
        return false;
    }

    /**
     * Sub method to check for enough milk
     *
     * @param milkDemand - the amount of needed milk
     * @return true if it has enough milk, otherwise a specific message
     * pops up, and it returns false
     */
    private static boolean checkForMilk(int milkDemand) {
        if (milk - milkDemand >= 0) {
            return true;
        }
        lackOfResourcesMessage("milk");
        return false;
    }

    /**
     * Sub method to check for enough coffee beans
     *
     * @param coffeeDemand - the amount of needed coffee beans
     * @return true if it has enough coffee beans, otherwise a specific message
     * pops up, and it returns false
     */
    private static boolean checkForCoffee(int coffeeDemand) {
        if (coffeebeans - coffeeDemand >= 0) {
            return true;
        }
        lackOfResourcesMessage("coffee");
        return false;
    }

    /**
     * Sub method to check for enough cups
     *
     * @param cupDemand - the amount of needed cups
     * @return true if it has enough cups, otherwise a specific message
     * pops up, and it returns false
     */
    private static boolean checkForCups(int cupDemand) {
        if (disposableCups - cupDemand >= 0) {
            return true;
        }
        lackOfResourcesMessage("cups");
        return false;
    }

    /**
     * Hands out the collected money and pops up a message about the amount of it.
     */
    private static void takeMoneyAndPrintMessage() {
        System.out.printf("I gave you $%.0f\n", money);
        money = BigDecimal.valueOf(0);
    }

    /**
     * Input dialog to fill the coffee machine
     */
    private static void inputForFillMachine() {
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

    /**
     * Method to fill the coffee machine
     *
     * @param addWater       - amount of water to add
     * @param addMilk        - amount of milk to add
     * @param addCoffeeBeans - amount of coffee beans to add
     * @param addCups        - amount of cups to add
     */
    private static void fillMachine(int addWater, int addMilk, int addCoffeeBeans, int addCups) {
        water += addWater;
        milk += addMilk;
        coffeebeans += addCoffeeBeans;
        disposableCups += addCups;
    }

    /**
     * Prints the status about the resources for the coffee machine
     */
    private static void printStatusMessage() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%.0f of money\n\n", water, milk, coffeebeans, disposableCups, money);
    }
}
