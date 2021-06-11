import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Agenda {
    public ArrayList<Contact> contacts = new ArrayList<>();
    public ArrayList<String> contactStrings = new ArrayList<String>();

//    public Agenda(Contact[] contacts) {
//        this.contacts = new Contact[10];
//    }

//    public Agenda(int size) {
//        this.contacts = new Contact[size];
//    }

    public void addContact(Contact c, Path p) {

        contacts.add(c);
        String contactInfo;
        contactInfo = c.getName() + " " + c.getNumber();
        contactStrings.add(contactInfo);

        if (existContact(c)) {
            System.out.println("This contact already exists");
        } else {
            try {
                Files.write(p, contactStrings, StandardOpenOption.APPEND);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }


//            boolean found = false;
//            for (int i = 0; i < contacts.length && !found; i++) {
//                if (contacts[i] == null) {
//                    contacts[i] = c;
//                    found = true;
//                }
//            }
//            if (found) {
//                System.out.println("You added a new contact!");
//            } else {
//                System.out.println("We could not add a new contact :( ");
//            }
        }

    }

    public boolean existContact(Contact c) {

        for (int i = 0; i < contacts.size(); i++) {
            if (c.equals(contacts.indexOf(i))) {
                return true;
            }
        }
        return false;
    }

    public void contactList() {
        Path fileTxt = Paths.get("src/contactList/contacts.txt");

        List<String> listOfContacts = new ArrayList<String>();
        try{
            listOfContacts=  Files.readAllLines(fileTxt);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        for (String contacts: listOfContacts) {
            System.out.println(contacts);
        }

    }


    public void searchName(Path path, String findContact) throws IOException {
        Scanner scan = new Scanner(path);
        while(scan.hasNext()) {
            String line = scan.nextLine().toLowerCase();
            if (line.contains(findContact.toLowerCase(Locale.ROOT))) {
                System.out.println(line);
            }
        }
    }
//        boolean found = false;
//        for (int i = 0; i < contacts.size() && !found; i++) {
//            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
//                System.out.println("Your number is: " + contacts.get(i).getNumber());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("contact not found");
//        }


//    public boolean fullAgenda() {
//        for (int i = 0; i < contacts.so; i++) {
//            if (contacts[i] == null) {
//                return false;
//            }
//        }
//        return true;
//    }

    public void removeContact(Contact c) {
        boolean found = false;
        for (int i = 0; i < contacts.size() && found; i++) {
            if (contacts.get(i).equals(c)) {
                contacts.remove(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("contact has not been deleted");
        }
    }

}
