package datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repräsentiert einen Kunden mit ID, Namen und Kontaktdaten.
 * Unterstützt die Zerlegung eines Namens in Vor- und Nachnamen.
 *
 * @author Sakina Mohammadi
 * @version 1.0
 */
public class Customer {

    private long id;
    private String firstName = "";
    private String lastName = "";
    private final List<String> contacts = new ArrayList<>();

    public Customer() {}

    public Customer(String name) {
        splitName(name);
    }

    public long getId() {
        return id;
    }

    public Customer setId(long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setName(String first, String last) {
        this.firstName = trim(first);
        this.lastName = trim(last);
        return this;
    }

    public Customer setName(String name) {
        splitName(name);
        return this;
    }

    public int contactsCount() {
        return contacts.size();
    }

    public Iterable<String> getContacts() {
        return Collections.unmodifiableList(contacts);
    }

    public Customer addContact(String contact) {
        contacts.add(trim(contact));
        return this;
    }

    public void deleteContact(int i) {
        if (i < 0 || i >= contacts.size()) {
            throw new IndexOutOfBoundsException("Ungültiger Index: " + i);
        }
        contacts.remove(i);
    }

    public void deleteAllContacts() {
        contacts.clear();
    }

    /**
     * Split single-String name into last- and first name parts according to rules...
     */
    public void splitName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        }

        String cleaned = trim(name);

        // Trenne an erstem Komma oder Semikolon
        if (cleaned.contains(",") || cleaned.contains(";")) {
            String[] parts = cleaned.split("[,;]", 2);
            this.lastName = trim(parts[0]);
            this.firstName = trim(parts[1]);
        } else {
            String[] words = cleaned.trim().split("\\s+");
            if (words.length == 1) {
                this.firstName = "";
                this.lastName = words[0];
            } else {
                this.firstName = String.join(" ", java.util.Arrays.copyOf(words, words.length - 1));
                this.lastName = words[words.length - 1];
            }
        }
    }

    /**
     * Trim leading and trailing white spaces {@code [\s]}, commata {@code [,;]}
     * and quotes {@code ["']} from a String (used for names and contacts).
     * @param s String to trim
     * @return trimmed String
     */
    private String trim(String s) {
        s = s.replaceAll("^[\\s\"',;]*", "");   // trim leading white spaces[\s], commata[,;] and quotes['"]
        s = s.replaceAll( "[\\s\"',;]*$", "");  // trim trailing accordingly
        return s;
    }
}
