import java.util.Scanner;

abstract class DataOperation {
    public abstract int performOperation(int input);
}

class AdditionOperation extends DataOperation {
    @Override
    public int performOperation(int input) {
        return input + 10;
    }
}

class SubtractionOperation extends DataOperation {
    @Override
    public int performOperation(int input) {
        return input - 5;
    }
}

class DatabaseUpdater {
    public static void updateDatabase(String operationName, int input, int output) {
        System.out.println("Updating database with operation: " + operationName + ", Input: " + input + ", Output: " + output);
        // Code to update the database with the operation details
    }
}

public class DataOperationWithDatabase {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Data Operation Program");

            // Input operation type
            System.out.print("Enter operation type (A for Addition, S for Subtraction): ");
            String operationType = scanner.nextLine().toUpperCase();

            // Input number
            System.out.print("Enter a number: ");
            int inputNumber = scanner.nextInt();

            // Perform operation based on user input
            DataOperation operation;
            switch (operationType) {
                case "A":
                    operation = new AdditionOperation();
                    break;
                case "S":
                    operation = new SubtractionOperation();
                    break;
                default:
                    System.out.println("Invalid operation type.");
                    return;
            }

            int outputNumber = operation.performOperation(inputNumber);

            // Output result to the user
            System.out.println("Result: " + outputNumber);

            // Update database with operation details
            DatabaseUpdater.updateDatabase(operationType, inputNumber, outputNumber);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
