import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

public class Test {
    public static void main(String[] args) {
        String contactFilePath = "src/contactList";
        Path directoryPath = Paths.get(contactFilePath);
        try {
            if (Files.notExists(directoryPath)) {
                Files.createDirectory(directoryPath);
            } else {
                System.out.println("already created");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Path txt = Paths.get(contactFilePath, "contacts.txt");
        try {
            if (Files.notExists(txt)) {
                Files.createFile(txt);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        boolean running = true;
        int option;
        Agenda phonebook = new Agenda();
        String name;
        String number;
        Contact c;

        while (running) {
            System.out.println("1. Add contact");
            System.out.println("2. View contacts");
            System.out.println("3. Search contacts");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit!");
            try {
                Scanner scanner = new Scanner(System.in);
                scanner.useDelimiter("\n");
                System.out.println("Enter one of the options");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        System.out.println("Enter a number");
                        number = scanner.nextLine();
                        c = new Contact(name, number);
                        phonebook.addContact(c);
                        System.out.println(c.getName() + " successfully added to contacts!");
                        break;
                    case 2:
                        phonebook.contactList();
                        break;
                    case 3:
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        c = phonebook.findContact(name);
                        if(c == null) {
                            System.out.println("No contact found for " + name);
                        } else {
                            System.out.println("Contact found!");
                            System.out.println(c.toFileString());
                        }
                        break;
                    case 4:
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        phonebook.removeContact(name);
                        System.out.println(name + " successfully deleted from contacts");
                        break;
                    case 5:
                        phonebook.saveContacts();
                        running = false;
                        break;
                    default:
                        System.out.println("default case change later");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
