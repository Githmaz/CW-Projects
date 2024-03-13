import java.util.Scanner;

public class PlaneManagement {
    private static final int[][] seats = {new int[14], new int[12], new int[12], new int[14]};
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("               _                          \n" +
                "              | |                         \n" +
                " __      _____| | ___ ___  _ __ ___   ___ \n" +
                " \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\\n" +
                "  \\ V  V /  __/ | (_| (_) | | | | | |  __/\n" +
                "   \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|");
        System.out.println(" ____  __     ____  _  _  ___   \n" +
                "(_  _)/  \\   (_  _)( )( )(  _)  \n" +
                "  )( ( () )    )(   )__(  ) _)  \n" +
                " (__) \\__/    (__) (_)(_)(___)  ");
        System.out.println("______ _                   ___  ___                                                  _                       _ _           _   _             \n" +
                "| ___ \\ |                  |  \\/  |                                                 | |                     | (_)         | | (_)            \n" +
                "| |_/ / | __ _ _ __   ___  | .  . | __ _ _ __   __ _  __ _  ___ _ __ ___   ___ _ __ | |_    __ _ _ __  _ __ | |_  ___ __ _| |_ _  ___  _ __  \n" +
                "|  __/| |/ _` | '_ \\ / _ \\ | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '_ ` _ \\ / _ \\ '_ \\| __|  / _` | '_ \\| '_ \\| | |/ __/ _` | __| |/ _ \\| '_ \\ \n" +
                "| |   | | (_| | | | |  __/ | |  | | (_| | | | | (_| | (_| |  __/ | | | | |  __/ | | | |_  | (_| | |_) | |_) | | | (_| (_| | |_| | (_) | | | |\n" +
                "\\_|   |_|\\__,_|_| |_|\\___| \\_|  |_/\\__,_|_| |_|\\__,_|\\__, |\\___|_| |_| |_|\\___|_| |_|\\__|  \\__,_| .__/| .__/|_|_|\\___\\__,_|\\__|_|\\___/|_| |_|");

        while (true) {
            titleDesign("MENU OPTIONS");
            System.out.println("\n 1) Buy a Seat");
            System.out.println(" 2) Cancel a Seat");
            System.out.println(" 3) Find First Available Seat");
            System.out.println(" 4) Show Seating Plan");
            System.out.print("\nPlease Enter your option : ");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    buy_seat();
                    break;
                case 2:
                    cancel_seat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                default:
                    System.out.println("\nInvalid Option, Try again");
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
                }else System.out.print("\nSorry, Seat is already Sold");
                // Ask user try again or not
                System.out.print("\n\nEnter 'Y' to buy a seat again , or Any-Other key to go to menu : ");
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
                int rowNumber = row - 'A';
                // Get user's seat number selection
                System.out.printf("Enter the seat number (1 to %d) : ", seats[rowNumber].length);
                int seatNumber = scanner.nextInt();
                // Check the seat Sold or not
                if (seats[rowNumber][seatNumber-1] == 1) {
                    System.out.println("\nThe Seat is available now , Thank you");
                    seats[rowNumber][seatNumber-1] = 0;
                } else System.out.println("\nSorry, Seat is not Sold");
                // Ask user try again or not
                System.out.print("\nEnter 'Y' to Cancel a seat again , or Any-Other key to go to menu : ");
                char option = scanner.next().charAt(0);
                if (option != 'y' && option != 'Y') return;
                //invalid Input handler
            } catch (Exception e) {
                System.out.println("\nInvalid Row or Seat number");
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
                    break outerLoop; // Will break the outer for loop
                }
            }
            if (i == seats.length-1) System.out.println("\nAll the Seats are Sold");
        }
        System.out.print("\nPress Any-Key to go back to menu : ");
        scanner.next();
    }

    // --------- Show Seating Plan ---------- //
    public static void show_seating_plan(){
        titleDesign("Show Seating Plan");
        for (int[] row : seats) {
            for (int seat : row) {
                System.out.print(seat == 0 ? " O " : " X ");
            }
            System.out.println();
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


