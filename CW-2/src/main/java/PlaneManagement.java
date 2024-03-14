import Objects.Person;
import Objects.Ticket;
import Design.DesignElements;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {
    private static final int[][] seats = {new int[14], new int[12], new int[12], new int[14]};
    private static Ticket[] tickets = new Ticket[0];
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Display welcome message
        DesignElements.display_welcome_message();
        while (true) {
            // Display menu
            DesignElements.display_menu();
            try {
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
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    default:
                        System.out.println("\n\""+option+"\" : Invalid Option, Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please Enter a number Next time.");
                scanner.next();
            }
        }
    }


    // --------- Buy Seat Method ---------- //
    public static void buy_seat(){
        // Set title for Buy seats
        DesignElements.title_Design("Buy Seats");
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
                    // Get Personal Details
                    System.out.print("\n*** Personal Details *** \n");
                    System.out.print("Enter your First name    : ");
                    // Person Name
                    String name = scanner.next();
                    System.out.print("Enter your Surname       : ");
                    // Person Surname
                    String surname = scanner.next();
                    // Person Email
                    String email;
                    while (true){
                        System.out.print("Enter your Email         : ");
                        email = scanner.next();
                        // Email Validation
                        if (email.contains("@") && email.contains(".")) break;
                        System.out.println("\nInvalid email! Please enter a valid email containing '@' and '.'\n");
                    }
                    // Booking the Seat
                    seats[rowNumber][seatNumber-1] = 1;
                    add_new_ticket(new Ticket(row+""+seatNumber,get_seat_value(seatNumber),new Person(name,surname,email)));
                    System.out.printf("\n%c%d Seat is sold to %s , Thank you",row,seatNumber,name+" "+surname);
                }else {
                    System.out.print("\nSorry, Seat is already Sold");
                }
                // Invalid Input handler
            }catch (Exception e){
                System.out.println("\nInvalid Row or Seat number");
            }
            // Ask user try again or not
            System.out.print("\n\nEnter 'Y' to buy a seat again , or Any-Other key to go to menu : ");
            char option = scanner.next().charAt(0);
            if (option != 'y' && option != 'Y') return;

        }
    }

    // --------- Cancel Seat Method ---------- //
    public static void cancel_seat(){
        DesignElements.title_Design("Cancel Seat");
        // Check is any seat is sold or not
        if (tickets.length == 0){
            DesignElements.title_Design("\b\b\b\b\b\bAll the seats are available ");
        }
        while (tickets.length != 0) {
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
                    remove_ticket(row+""+seatNumber);
                    System.out.println("\nThe Seat is available now , Thank you");
                    seats[rowNumber][seatNumber-1] = 0;
                } else System.out.println("\nSorry, Seat is not Sold");
                //invalid Input handler
            } catch (Exception e) {
                System.out.println("\nInvalid Row or Seat number");
            }
            // Ask user try again or not
            System.out.print("\nEnter 'Y' to Cancel a seat again , or Any-Other key to go to menu : ");
            char option = scanner.next().charAt(0);
            if (option != 'y' && option != 'Y') return;
        }
    }

    // --------- Find First Available Method ---------- //
    public static void find_first_available(){
        // Set title for find first available
        DesignElements.title_Design("Find First Available");
        // loop for find the first available seat
        outerLoop:
        for(int i = 0; i < seats.length; i++) {
            for(int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.printf("\nFirst Available Seat is : %c%d \n", (char)('A' + i), j+1);
                    break outerLoop;
                }
            }
            // If all seats are sold
            if (i == seats.length-1) System.out.println("\nAll the Seats are Sold");
        }
        // Wait for user input to return to the menu
        System.out.print("\nPress Any-Key to go back to menu : ");
        scanner.next();
    }

    // --------- Show Seating Plan Method ---------- //
    public static void show_seating_plan(){
        // Set title for show seating plan
        DesignElements.title_Design("Show Seating Plan");
        // loop for print all the seats
        for (int[] row : seats) {
            for (int seat : row) {
                System.out.print(seat == 0 ? " O " : " X ");
            }
            System.out.println();
        }
        // Wait for user input to return to the menu
        System.out.print("\nPress Any-Key to go back to menu : ");
        scanner.next();
    }


    // --------- Print Tickets Info Method ---------- //
    public static void print_tickets_info(){
        // Loop to print ticket info and cal total
        int total = 0;
        for(Ticket ticket :tickets){
            ticket.print_ticket_info();
            total+=ticket.getPrice();
        }
        // Print the Total value
        DesignElements.title_Design("\b\bTotal price is : "+total+"$     ");
        // Wait for user input to return to the menu
        System.out.print("\nPress Any-Key to go back to menu : ");
        scanner.next();
    }

    // --------- Search Ticket Method ---------- //
    private static void search_ticket() {
        // Set title for search ticket
        DesignElements.title_Design("Search ticket");
        // Check is any seat is sold or not
        if (tickets.length == 0){
            DesignElements.title_Design("\b\b\b\b\b\bAll the seats are available ");
        }
        while (tickets.length != 0) {
            try {
                // Get user's row selection
                System.out.print("\nEnter the Row (A,B,C,D) : ");
                char row = scanner.next().charAt(0);
                int rowNumber = row - 'A';
                // Get user's seat number selection
                System.out.printf("Enter the seat number (1 to %d) : ", seats[rowNumber].length);
                int seatNumber = scanner.nextInt();
                // Check the seat Sold or not
                for (int i=0; i<tickets.length;i++) {
                    if (tickets[i].getSeat().equals(row+""+seatNumber)) {
                        tickets[i].print_ticket_info();
                        break;
                    }
                    if (i == tickets.length - 1){
                        DesignElements.title_Design("\b\b\b\bThis seat is available    ");
                    }
                }
                // Invalid Input handler
            } catch (Exception e) {
                System.out.println("\nInvalid Row or Seat number");
            }
            // Ask user try again or not
            System.out.print("\nEnter 'Y' to Cancel a seat again , or Any-Other key to go to menu : ");
            char option = scanner.next().charAt(0);
            if (option != 'y' && option != 'Y') return;
        }
    }



    // ----------- Get Seat Value Method ---------- //
    public static int get_seat_value(int seatNumber){
        if(seatNumber>9) return 180;
        if(seatNumber>5) return 150;
        return 200;
    }

    // --------- adding New ticket to array method  ---------- //
    public static void add_new_ticket(Ticket newTicket){
        // Create a new array with space for the new ticket
        Ticket[]  updatedTickets = new Ticket[tickets.length+1];
        // Copy existing tickets
        for(int i = 0; i<tickets.length ;i++){
            updatedTickets[i] = tickets[i];
        }
        // add the new ticket and update the tickets reference
        updatedTickets[tickets.length] = newTicket;
        tickets = updatedTickets;
    }

    // --------- remove ticket from Array method ---------- //
    public static void remove_ticket(String seatNumber){
        // Create a new array with one less slot
        Ticket[] updatedTickets = new Ticket[tickets.length - 1];
        int updatedIndex = 0;// Index for the updated array
        for (Ticket ticket : tickets) {
            // Skip the ticket to be removed
            if (ticket.getSeat().equals(seatNumber)) {
                continue;
            }
            // Copy other tickets to the updated array
            updatedTickets[updatedIndex++] = ticket;
        }
        // Update the tickets reference
        tickets = updatedTickets;
    }
}


