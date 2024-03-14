package Objects;
import Design.DesignElements;

public class Ticket {
    private String seat;
    private int price;
    private Person person;

    public Ticket(){}
    public Ticket(String seat, int price, Person person) {
        this.seat = seat;
        this.price = price;
        this.person = person;
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
        DesignElements.title_Design(seat+"Seat Ticket");
        System.out.printf("*\t Seat number : %-3s                             *\n",this.seat);
        System.out.printf("*\t Price       : %-3s$                            *\n",this.price);
        System.out.println("*\t Person info                                   *");
        this.person.print_Person_info();
        System.out.println("+--------------------------------------------------+");
    }
}
