import java.util.Scanner;

public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void addContact(String name, String number){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter new contact: ");
        String newContact = scanner.nextLine();
        System.out.println(newContact);
    }

    public static void main(String[] args) {
        System.out.println();
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
