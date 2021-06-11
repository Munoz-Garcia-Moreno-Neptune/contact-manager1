import java.util.ArrayList;

public class Contact {
    private String name;
    private int number;
    private ArrayList<String> contacts;


    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public Contact(String name) {
        this.name = name;
        this.number = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean equals(Contact c) {
        if (this.name.equalsIgnoreCase(c.getName())) {
            return true;
        }
        return false;
    }


    @Override

    public String toString() {
        return "Name: " + name + ", Number: " + number;
    }
}
//    private String name;
//    private String number;
//    private ArrayList<String> contacts;
//
//    public Contacts(String name, String number) {
//        this.name = name;
//        this.number = number;
//        this.contacts = new ArrayList<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    public ArrayList<String> getContacts() {
//        return contacts;
//    }
//
//    public void setContacts(ArrayList<String> contacts) {
//        this.contacts = contacts;
//    }
//
//    public void addContact(String newContacts) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter new contact: ");
//        String newContact = scanner.nextLine();
//        contacts.add(newContact);
//        System.out.println(contacts);
//    }
//
//
//    public static void main(String[] args) {
//
//    }
//}