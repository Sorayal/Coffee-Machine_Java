package stage_6;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeeMachineLogic logic = CoffeeMachineLogic.build();

        while (true) {
            logic.getCoffeeMachineState();
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            if (choice.equals("exit")) {
                break;
            }
            logic.processingInput(choice);
        }
    }
}
