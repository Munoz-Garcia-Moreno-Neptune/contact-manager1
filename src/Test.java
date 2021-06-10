import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        boolean goOut = false;
        int option;
        Agenda phonebook = new Agenda(3);
        String name;
        int number;
        Contact c;

        while (!goOut) {
            System.out.println("1. Add contact");
            System.out.println("2. View contacts");
            System.out.println("3. Search contacts");
            System.out.println("4. Exist contact");
            System.out.println("5. Delete contact");
            System.out.println("6. Agenda is full?");
            System.out.println("7 Contact available");
            System.out.println("Exit!");
            try {
                System.out.println("Enter one of the options");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter a name");
                        name = scanner.next();
                        System.out.println("Enter a number");
                        number = scanner.nextInt();
                        c = new Contact(name, number);
                        phonebook.addContact(c);
                        break;
                    case 2:
                        phonebook.contactList();
                        break;
                    case 3:
                        System.out.println("Enter a name");
                        name = scanner.next();
                        phonebook.searchName(name);
                        break;
                    case 4:
                        System.out.println("Enter a name");
                        name = scanner.next();
                        c = new Contact(name, 0);
                        if (phonebook.existContact(c)) {
                            System.out.println("Exist this contact");
                        } else {
                            System.out.println("This contact no Exist");
                        }
                        break;
                    case 5:
                        System.out.println("Enter a name");
                        name = scanner.next();
                        c = new Contact(name, number);
                        phonebook.removeContact(c);
                        break;
                    case 6:
                        System.out.println("There are " + phonebook.fullAgenda() + "contacts");
                        break;
                    case 7:
                        if (phonebook.fullAgenda()) {
                            System.out.println("Agenda is full");
                        } else {
                            System.out.println("You can still add contacts");
                        }
                        break;
                    case 8:
                        goOut = true;
                        break;
                }
            }
        }
    }
}