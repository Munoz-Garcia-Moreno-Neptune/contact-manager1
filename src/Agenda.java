public class Agenda {
    private Contact[] contacts;

    public Agenda(Contact[] contacts) {
        this.contacts = new Contact[10];
    }

    public Agenda(int size) {
        this.contacts = new Contact[size];
    }

    public void addContact(Contact c) {


        if (existContact(c)) {
            System.out.println("This contact already exists");
        } else if (fullAgenda()) {
            System.out.println("Agenda is full, you cannot add more contacts");
        } else {

            boolean found = false;
            for (int i = 0; i < contacts.length && !found; i++) {
                if (contacts[i] == null) {
                    contacts[i] = c;
                    found = true;
                }
            }
            if (found) {
                System.out.println("You added a new contact!");
            } else {
                System.out.println("We could not add a new contact :( ");
            }
        }

    }

    public boolean existContact(Contact c) {

        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null && c.equals(contacts[i])) {
                return true;

            }
        }
        return false;
    }

    public void contactList() {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                System.out.println(contacts[i]);
            }
        }
    }

    public void searchName(String name) {
        boolean found = false;
        for (int i = 0; i < contacts.length && !found; i++) {
            if (contacts[i] == null && contacts[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Your number is: " + contacts[i].getNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("contact not found");
        }
    }

    public boolean fullAgenda() {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void removeContact(Contact c) {
        boolean found = false;
        for (int i = 0; i < contacts.length && found; i++) {
            if (contacts[i] == null && contacts[i].equals(c)) {
                contacts = null;
                found = true;
            }
        }
        if (!found) {
            System.out.println("contact has not been deleted");
        }
    }

    public int freeSpots() {
        int freeCount = 0;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                freeCount++;
            }
        }
        return freeCount;
    }
}
