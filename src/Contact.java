import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(String fileEntry) {
        String[] data = fileEntry.split(" | ");
        this.name = data[0];
        this.number = data[data.length - 1];
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

    @Override
    public String toString() {
        return "Name: " + name + ", Number: " + number;
    }
    public String toFileString() {
        return name + " | " + number;
    }
}