import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class PlaneManagement {
    static int[][] seats = {new int[14], new int[12], new int[12], new int[14]};
    static Scanner scanner = new Scanner(System.in);
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
                case 0:
                    return;
            }
        }
    }

    // --------- Buy Seat Method ---------- //
    public static void buy_seat(){
        while (true) {
            titleDesign("Buy Seats");
            try {
                System.out.print("Enter the Row (A,B,C,D) : ");
                char row = scanner.next().charAt(0);
                int rowNumber = row - 'A' + 1;
                System.out.printf("Enter the seat number (1 to %d) : ", seats[rowNumber].length);
                int seatNumber = scanner.nextInt();
                if (seats[rowNumber][seatNumber] == 0) {
                    System.out.println("seat is booked , Thank you");
                    seats[rowNumber][seatNumber] = 1;
                }
                System.out.print("Enter 'Y' to buy a seat again , or Any-Other key to go to menu : ");
                char option = scanner.next().charAt(0);
                if (option != 'y' && option != 'Y') return;
            }catch (Exception e){
                System.out.println("Invalid Row or Seat number");
            }
        }
    }

    public static void titleDesign(String title){
        System.out.println("\n\n+--------------------------------------------------+");
        System.out.printf("*                   %-19s            *\n", title);
        System.out.println("+--------------------------------------------------+\n");
    }

    // --------- Buy Seat Method ---------- //
    public static void cancel_seat(){
        while (true) {
            titleDesign("Cancel Seat");
            System.out.print("Enter the Row (A,B,C,D) : ");
            char row = scanner.next().charAt(0);
            int rowNumber = row - 'A' + 1;
            System.out.printf("Enter the seat number (1 to %d) : ", seats[rowNumber].length);
            int seatNumber = scanner.nextInt();
            if(seats[rowNumber][seatNumber] == 1){
                System.out.println("seat is booked , Thank you");
                seats[rowNumber][seatNumber] = 0;
            }else{
                System.out.println("seat is already Sold");
            }
            System.out.print("\n Enter 'Y' to Cancel a seat again , or Any-Other key to go to menu : ");
            char option = scanner.next().charAt(0);
            if(option != 'y' && option != 'Y') return;
        }
    }
}


