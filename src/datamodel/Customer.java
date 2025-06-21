package datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Entity class representing a <b>Customer</b> – a person who can create and
 * own orders in the system.
 *
 * <p>Die Klasse kapselt
 * <ul>
 *   <li>eine unveränderliche {@code id} (≥ 0, nach erster Zuweisung fix),</li>
 *   <li>Vor- und Nachname, die entweder getrennt oder als
 *       Single-String gesetzt werden können,</li>
 *   <li>eine veränder­bare Liste von Kontakt­angaben
 *       (E-Mail, Telefon u. Ä.).</li>
 * </ul>
 *
 * @version "C12-1.0.0-SNAPSHOT"
 * @author  Sakina Mohammadi
 */
public class Customer {

    /* ------------------------------------------------------------------ */
    /* Attributes                                                          */
    /* ------------------------------------------------------------------ */

    /** Immutable id (−1 solange noch nicht vergeben). */
    private long id = -1;

    /** Never {@code null}. */
    private String firstName = "";

    /** Never {@code null}. */
    private String lastName  = "";

    /** Mutable list of contacts – keine Duplikate, kein {@code null}. */
    private final List<String> contacts = new ArrayList<>();


    /* ------------------------------------------------------------------ */
    /* Constructors                                                        */
    /* ------------------------------------------------------------------ */

    /** Default-Konstruktor. */
    public Customer() { }

    /**
     * Convenience-Konstruktor mit Single-String-Name, z. B.
     * {@code "Eric Meyer"} oder {@code "Meyer, Eric"}.
     *
     * @param name Customer-Name (nicht {@code null}/leer)
     * @throws IllegalArgumentException wenn {@code name} {@code null}/leer ist
     * @see #splitName(String)
     */
    public Customer(String name) { splitName(name); }


    /* ------------------------------------------------------------------ */
    /* Getters / Setters                                                   */
    /* ------------------------------------------------------------------ */

    /**
     * Id getter.
     *
     * @return aktuelle Id oder {@code -1}, wenn noch nicht gesetzt
     */
    public long getId() { return id; }

    /**
     * Id setter – kann <b>nur einmal</b> mit einem gültigen Wert (&ge; 0)
     * aufgerufen werden.
     *
     * @param id Id &ge; 0
     * @return chainable self reference
     * @throws IllegalArgumentException bei negativem Id-Wert
     */
    public Customer setId(long id) {
        if (id < 0) throw new IllegalArgumentException("id < 0");
        if (this.id == -1) this.id = id;        // nur erste Zuweisung gültig
        return this;
    }

    /** @return Nachname (nie {@code null}) */
    public String getLastName()  { return lastName; }

    /** @return Vorname (nie {@code null}) */
    public String getFirstName() { return firstName; }

    /**
     * Setzt Vor- und Nachnamen separat.
     *
     * @param first Vorname (nicht {@code null}/leer erlaubt)
     * @param last  Nachname (nicht {@code null}/leer)
     * @return chainable self reference
     * @throws IllegalArgumentException falls Vorgaben verletzt werden
     */
    public Customer setName(String first, String last) {
        if (last == null || last.isBlank())
            throw new IllegalArgumentException("last name empty");
        if (first == null)
            throw new IllegalArgumentException("first name null");
        this.firstName = trim(first);
        this.lastName  = trim(last);
        return this;
    }

    /**
     * Zerlegt einen Single-String-Namen in Vor- und Nachnamen.  
     * Logik siehe {@link #splitName(String)}.
     *
     * @param name Single-String-Name
     * @return chainable self reference
     */
    public Customer setName(String name) { splitName(name); return this; }


    /* ------------------------------------------------------------------ */
    /* Contacts                                                            */
    /* ------------------------------------------------------------------ */

    /** @return Anzahl der Kontakte */
    public int contactsCount() { return contacts.size(); }

    /**
     * Liefert eine unveränderliche Sicht auf die Kontakte.
     *
     * @return {@code Iterable<String>} read-only
     */
    public Iterable<String> getContacts() {
        return Collections.unmodifiableList(contacts);
    }

    /**
     * Fügt einen neuen Kontakt hinzu, falls gültig und noch nicht vorhanden.
     *
     * @param contact Kontakt­string (mind. 6 Zeichen)
     * @return chainable self reference
     * @throws IllegalArgumentException bei {@code null}/leerem Kontakt
     */
    public Customer addContact(String contact) {
        if (contact == null || contact.isBlank())
            throw new IllegalArgumentException("contact empty");
        contact = trim(contact);
        if (contact.length() >= 6 && !contacts.contains(contact))
            contacts.add(contact);
        return this;
    }

    /**
     * Löscht den <i>i</i>-ten Kontakt, falls Index gültig ist.
     *
     * @param i Index&nbsp;&ge;&nbsp;0 &&&nbsp;&lt;&nbsp;{@link #contactsCount()}
     */
    public void deleteContact(int i) {
        if (i >= 0 && i < contacts.size()) contacts.remove(i);
    }

    /** Löscht <b>alle</b> Kontakte. */
    public void deleteAllContacts() { contacts.clear(); }


    /* ------------------------------------------------------------------ */
    /* Internals                                                           */
    /* ------------------------------------------------------------------ */

    /**
     * Zerlegt {@code name} in Vor-/Nachnamen nach in der Aufgabe
     * beschriebenen Regeln.
     *
     * @param name Name (nicht {@code null}/leer)
     * @throws IllegalArgumentException falls {@code name} ungültig
     */
    public void splitName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name empty");

        String cleaned = trim(name);

        // Komma- oder Semikolon-Trennung
        if (cleaned.contains(",") || cleaned.contains(";")) {
            String[] parts = cleaned.split("[,;]", 2);
            this.lastName  = trim(parts[0]);
            this.firstName = trim(parts[1]);
            return;
        }

        // Keine Trenn­zeichen → letzter Token = Nachname
        String[] tokens = cleaned.split("\\s+");
        if (tokens.length == 1) {
            firstName = "";
            lastName  = tokens[0];
        } else {
            firstName = String.join(" ", java.util.Arrays.copyOf(tokens, tokens.length - 1));
            lastName  = tokens[tokens.length - 1];
        }
    }

    /**
     * Entfernt führende/­nachfolgende Leer­zeichen, Quotes und Kommas.
     */
    private String trim(String s) {
        if (s == null) return "";
        s = s.replaceAll("^[\\s\"',;]+", "");
        s = s.replaceAll("[\\s\"',;]+$", "");
        return s.trim();
    }
}
