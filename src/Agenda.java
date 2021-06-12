import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Agenda {
    private static final String FILE_PATH_STRING = "src/contactList/contacts.txt";
    private static final Path FILE_PATH = Paths.get(FILE_PATH_STRING);

    public HashMap<String, Contact> contacts = new HashMap<String, Contact>();

    public Agenda() {
        List<String> listOfContacts = new ArrayList<String>();
        try {
            listOfContacts = Files.readAllLines(FILE_PATH);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        for (String contactString : listOfContacts) {
            Contact c = new Contact(contactString);
            contacts.putIfAbsent(c.getNumber(), c);
        }
    }

    public void saveContacts() {
        ArrayList<String> list = new ArrayList<String>();
        for (Contact c : contacts.values()) {
            list.add(c.toFileString());
        }
        try {
            Files.write(FILE_PATH, list);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void addContact(Contact c, Path p) {
        contacts.putIfAbsent(c.getNumber(), c);
    }

    public void contactList() {
        System.out.println("Name | Phone number\n---------------");
        for (Contact c : contacts.values()) {
            System.out.println(c.toFileString());
        }
    }

    public Contact findContact(String name) {
        for(Contact c : contacts.values()) {
            if(c.getName().toLowerCase().contains(name.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public void removeContact(String name) {

    }
}

