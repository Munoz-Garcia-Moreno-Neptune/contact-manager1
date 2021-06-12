import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Agenda {
    private static final String FILE_PATH_STRING = "src/contactList/contacts.txt";
    private static final Path FILE_PATH = Paths.get(FILE_PATH_STRING);

    private HashMap<String, Contact> contacts = new HashMap<>();

    // constructor: called with new Agenda() outside of this file
    public Agenda() {
        List<String> listOfContacts = new ArrayList<>();
        try {
            // read all lines of text file into ArrayList of Strings
            listOfContacts = Files.readAllLines(FILE_PATH);
        } catch (IOException ioe) {
            // print out error and where it occurs in terminal
            ioe.printStackTrace();
        }
        // for every string in the listOfContacts
        for (String contactString : listOfContacts) {
            // Create new Contact object from string
            Contact contact = new Contact(contactString);
            // Put contact Object into the contacts HashMap using the Phone number as the key
            contacts.putIfAbsent(contact.getNumber(), contact);
        }
    }

    public void saveContacts() {
        ArrayList<String> list = new ArrayList<>();
        for (Contact contact : contacts.values()) {
            list.add(contact.toFileString());
        }
        try {
            Files.write(FILE_PATH, list);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void addContact(Contact c) {
        contacts.put(c.getNumber(), c);
    }

    public void contactList() {
        System.out.println("Name | Phone number\n---------------");
        for (Contact c : contacts.values()) {
            System.out.println(c.toFileString());
        }
    }

    public Contact findContact(String name) {
        for(Contact contact : contacts.values()) {
            // If contact name contains input name (not case-sensitive)
            if(contact.getName().toLowerCase().contains(name.toLowerCase())) {
                return contact;
            }
        }
        // no contact found
        return null;
    }

    public void removeContact(String name) {
        Contact c = findContact(name);
        // If contact is found for input name, remove it
        if(c != null) {
            contacts.remove(c.getNumber());
        }
    }
}

