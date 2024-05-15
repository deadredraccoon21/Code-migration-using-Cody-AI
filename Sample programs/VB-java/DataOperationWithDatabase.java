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
  
  public class DataOperationWithDatabase {
      public static void main(String[] args) {
          try {
              System.out.println("Welcome to Data Operation Program");
  
              // Input operation type
              System.out.print("Enter operation type (A for Addition, S for Subtraction): ");
              char operationType = Character.toUpperCase(System.console().readLine().charAt(0));
  
              // Input number
              System.out.print("Enter a number: ");
              int inputNumber = Integer.parseInt(System.console().readLine());
  
              DataOperation operation;
  
              // Perform operation based on user input
              switch (operationType) {
                  case 'A':
                      operation = new AdditionOperation();
                      break;
                  case 'S':
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
              updateDatabase(operationType, inputNumber, outputNumber);
  
          } catch (Exception ex) {
              System.out.println("Error: " + ex.getMessage());
          }
      }
  
      private static void updateDatabase(char operationType, int inputNumber, int outputNumber) {
          System.out.println("Updating database with operation: " + operationType + ", Input: " + inputNumber + ", Output: " + outputNumber);
          // Code to update the database with the operation details
      }
  }
  