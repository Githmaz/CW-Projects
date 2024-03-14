package Objects;
public class Person {
    private String name;
    private String surname;
    private String email;


    // Constructor with parameters for name, surname, and email
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void print_Person_info(){
        System.out.printf("*             Name    : %-20s            *\n",this.name);
        System.out.printf("*             Surname : %-20s            *\n",this.surname);
        System.out.printf("*             Email   : %-20s            *\n",this.email);
    }
}
