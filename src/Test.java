import java.io.IOException;
import java.util.Scanner;
import java.nio.file.*;

public class Test {
    public static void main(String[] args) {

        Path directoryPath = Paths.get("src/contactList");
        try {
            if (Files.notExists(directoryPath)) {
                Files.createDirectory(directoryPath);
            } else {
                System.out.println("already created");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Path txt = Paths.get(String.valueOf(directoryPath), "contacts.txt");
        try {
            if (Files.notExists(txt)) {
                Files.createFile(txt);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        boolean goOut = false;
        int option;
        Agenda phonebook = new Agenda();
        String name;
        String number;
        Contact c;

        while (!goOut) {
            System.out.println("1. Add contact");
            System.out.println("2. View contacts");
            System.out.println("3. Search contacts");
            System.out.println("4. Exist contact");
            System.out.println("5. Delete contact");
//            System.out.println("6. Agenda is full?");
//            System.out.println("7. Contact available");
            System.out.println("6.Exit!");
            try {
                System.out.println("Enter one of the options");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        name = scanner.nextLine();
//                        scanner.nextLine();
                        System.out.println("Enter a number");
                        number = scanner.nextLine();
                        c = new Contact(name, number);

                        phonebook.addContact(c, txt);
                        break;
                    case 2:
                        phonebook.contactList();
                        break;
                    case 3:
                        System.out.println("Enter a name");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        phonebook.searchName(txt,name);
                        break;
                    case 4:
                        System.out.println("Enter a name");
                        name = scanner.nextLine();
                        number = scanner.nextLine();
                        c = new Contact(name, number);
                        if (phonebook.existContact(c)) {
                            System.out.println("Exist this contact");
                        } else {
                            System.out.println("This contact no Exist");
                        }
                        break;
                    case 5:
                        System.out.println("Enter a name");// remove contact only requires name?
                        name = scanner.nextLine();
                        number = scanner.nextLine();
                        c = new Contact(name, number);
                        phonebook.removeContact(c);
                        break;
//                    case 6:
//                        System.out.println("There are " + phonebook.fullAgenda() + "contacts");
//                        break;
//                    case 7:
//                        if (phonebook.fullAgenda()) {
//                            System.out.println("Agenda is full");
//                        } else {
//                            System.out.println("You can still add contacts");
//                        }
//                        break;
                    case 6:
                        goOut = true;
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
