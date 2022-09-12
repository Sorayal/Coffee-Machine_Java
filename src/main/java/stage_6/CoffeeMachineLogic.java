package stage_6;

public class CoffeeMachineLogic {
    private states state = states.MAIN_CHOICE;
    private final CoffeeResources resources = CoffeeResources.build();
    private static CoffeeMachineLogic logic = null;

    /**
     * Creates a singleton instance of this logic class
     *
     * @return the logic instance of the coffee machine
     */
    public static CoffeeMachineLogic build() {
        if (null == logic) {
            logic = new CoffeeMachineLogic();
        }
        return logic;
    }

    /**
     * Preventing from creating more instances from outside.
     */
    private CoffeeMachineLogic() {
    }

    private enum states {
        MAIN_CHOICE,
        COFFEE_CHOICE,
        FILL
    }

    public void processingInput(String input) {
        if (state == states.MAIN_CHOICE) {
            switch (input) {
                case "buy":
                    state = states.COFFEE_CHOICE;
                    return;
                case "fill":
                    state = states.FILL;
                    break;
                case "take":
                    resources.takeMoneyAndPrintMessage();
                    break;
                case "remaining":
                    resources.printStatusMessage();
                    break;
                default:
                    System.out.println("Not a valid choice.");
                    break;
            }
        }

        if (state == states.COFFEE_CHOICE) {
            resources.buyCoffeeDialog(input);
            state = states.MAIN_CHOICE;
        }

        if (state == states.FILL) {
            // Need to add fill dialog, splitting method
            resources.inputForFillMachine();
            state = states.MAIN_CHOICE;
        }

    }

    public void getCoffeeMachineState() {
        switch (state) {
            case MAIN_CHOICE:
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            case COFFEE_CHOICE:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case FILL:
                break;
            default:
                System.out.println("Invalid state");
                break;
        }
    }
}
