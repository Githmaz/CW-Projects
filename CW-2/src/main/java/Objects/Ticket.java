package Objects;
import Design.DesignElements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String seat;
    private int price;
    private Person person;

    // Constructor with parameters for seat, price, and person
    public Ticket(String seat, int price, Person person) {
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public Ticket() {
    }

    public String getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void print_ticket_info(){
        DesignElements.title_Design(seat+" Seat Ticket");
        System.out.printf("*\t      Seat number : %-3s                             *\n",this.seat);
        System.out.printf("*\t      Price       : %-3s$                            *\n",this.price);
        System.out.println("*\t      Person info                                   *");
        this.person.print_Person_info();
        System.out.println("+-------------------------------------------------------+");
    }

    public void save() {
        try {
            // Create a FileWriter object to write to the file
            FileWriter fileWriter = new FileWriter("src/main/java/Tickets/" + this.seat + ".txt");

            // Write the ticket information to the file
            fileWriter.write("+-------------------------------------------------------+\n");
            fileWriter.write("                    " + this.seat + " Seat Ticket\n");
            fileWriter.write("+-------------------------------------------------------+\n");
            fileWriter.write("\t      Seat number : " + this.seat + "\n");
            fileWriter.write("\t      Price       : " + this.price + "$\n");
            fileWriter.write("\t      Person info \n");
            fileWriter.write("             Name    : " + this.person.getName() + "\n");
            fileWriter.write("             Surname : " + this.person.getSurname() + "\n");
            fileWriter.write("             Email   : " + this.person.getEmail() + "\n");
            fileWriter.write("+-------------------------------------------------------+\n");

            // Close the FileWriter to release resources
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error saving ticket info");
        }
    }
}
