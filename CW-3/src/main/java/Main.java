import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static int rowCount;
    static int bookedSeatCount;
    public static void main(String arg[]){
        System.out.println("\nWelcome to the MC\n");
        while(rowCount <= 0) {
            try {
                System.out.print("How many rows in the cinema hall ? ");
                rowCount = scanner.nextInt();
                System.out.println((rowCount >0)? "\n" : "The number of rows must be greater than 0. Please try again.\n");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value. \n");
                scanner.next();
            }
        }

        while (true){
            System.out.println("Cinema Hall have "+rowCount+" and "+rowCount*10+" Seats ! ");

            System.out.println("---------  Menu ---------");
            System.out.println(" [1] Booking");
            System.out.println(" [2] Refund");
            System.out.println(" [3] Statistics Report ");
            System.out.println(" [4] Exit ");
            int option = 0;

            while ((option<=0 || option >5)) {
                try {
                    System.out.print("Option ? ");
                    option = scanner.nextInt();
                    System.out.println((option > 0 && option < 5) ? "\n" : "option needs to be between 1 to 4.\n");
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a numeric value. \n");
                    scanner.next();
                }
            }

           switch (option) {
                    case 1:
                        booking();
                        break;
                    case 2:
                        System.out.println("Refund option selected.");
                        break;
                    case 3:
                        System.out.println("Statistics Report option selected.");
                        break;
                    case 4:
                        System.out.println("Exiting the program. Goodbye!");
                        return;
                }
        }
    }

    public static void booking(){
        System.out.println("Booking option selected.");
    }
}
