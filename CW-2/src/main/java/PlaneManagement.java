import java.util.Scanner;

public class PlaneManagement {
    private static final int[][] seats = {new int[14], new int[12], new int[12], new int[14]};
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");

        while (true) {
            titleDesign("MENU OPTIONS");
            System.out.print("Please Enter your option : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 0:

                    return;
            }
        }
    }

    // --------- Buy Seat Method ---------- //
    public static void buy_seat(){
        titleDesign("Buy Seats");
        while (true) {
            try {
                // Get user's row selection
                System.out.print("\nEnter the Row (A,B,C,D) : ");
                char row = Character.toUpperCase(scanner.next().charAt(0));
                int rowNumber = row - 'A' ;
                // Get user's seat number selection
                System.out.printf("Enter the seat number (1 to %d) : ", seats[rowNumber].length);
                int seatNumber = scanner.nextInt();
                // Check the seat Sold or not
                if (seats[rowNumber][seatNumber-1] == 0) {
                    System.out.printf("\nSeat is sold %c%d , Thank you",row,seatNumber);
                    seats[rowNumber][seatNumber-1] = 1;
                }else System.out.println("\nSorry, Seat is already Sold");
                // Ask user try again or not
                System.out.print("\nEnter 'Y' to buy a seat again , or Any-Other key to go to menu : ");
                char option = scanner.next().charAt(0);
                if (option != 'y' && option != 'Y') return;
                // Invalid Input handler
            }catch (Exception e){
                System.out.println("\nInvalid Row or Seat number");
            }
        }
    }


    // --------- Cancel Seat Method ---------- //
    public static void cancel_seat(){
        titleDesign("Cancel Seat");
        while (true) {
            try {
                // Get user's row selection
                System.out.print("\nEnter the Row (A,B,C,D) : ");
                char row = scanner.next().charAt(0);
                int rowNumber = row - 'A' + 1;
                // Get user's seat number selection
                System.out.printf("Enter the seat number (1 to %d) : ", seats[rowNumber].length);
                int seatNumber = scanner.nextInt();
                // Check the seat Sold or not
                if (seats[rowNumber][seatNumber-1] == 1) {
                    System.out.println("The Seat is available now , Thank you");
                    seats[rowNumber][seatNumber-1] = 0;
                } else System.out.println("\nSorry, Seat is not Sold");
                // Ask user try again or not
                System.out.print("\nEnter 'Y' to Cancel a seat again , or Any-Other key to go to menu : ");
                char option = scanner.next().charAt(0);
                if (option != 'y' && option != 'Y') return;
                //invalid Input handler
            } catch (Exception e) {
                System.out.println("Invalid Row or Seat number");
            }
        }
    }

    // --------- Find First Available Method ---------- //
    public static void find_first_available(){
        titleDesign("Find First Available");
        outerLoop:
        for(int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.printf("\nFirst Available Seat is : %c%d \n", (char)('A' + i), j+1);
                    break outerLoop;
                }
            }
            if (i == seats.length-1) System.out.println("\nAll the Seats are Sold");
        }
        System.out.print("\nPress Any-Key to go back to menu ");
        scanner.next();
    }
    public static void titleDesign(String title){
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.printf("*                   %-19s            *\n", title);
        System.out.println("+--------------------------------------------------+");
    }
}


