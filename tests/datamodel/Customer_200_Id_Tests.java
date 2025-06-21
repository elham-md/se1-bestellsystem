package datamodel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Tests für {@link Customer}: Nummern-Bereich [200‥299] – ID-Tests.
 *
 * @author Sakina Mohammadi
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Customer_200_Id_Tests {

    /** Regular 200: ID -1 nach Konstruktor, dann gültige ID setzen. */
    @Test @Order(200)
    void test200_setIdOnce() {
        Customer c = new Customer();
        assertEquals(-1, c.getId());
        c.setId(0);
        assertEquals(0, c.getId());
        c.setId(99); // ignoriert
        assertEquals(0, c.getId());
    }

    /** Regular 201: mehrere gültige IDs probieren. Nur der erste zählt. */
    @Test @Order(201)
    void test201_setIdOnlyOnce() {
        Customer c = new Customer("Test Name");
        assertEquals(-1, c.getId());
        c.setId(7);
        assertEquals(7, c.getId());
        c.setId(1234); // wird ignoriert
        assertEquals(7, c.getId());
    }

    /** Corner 210: größte zulässige ID (Long.MAX_VALUE). */
    @Test @Order(210)
    void test210_setId_MaxLong() {
        Customer c = new Customer();
        c.setId(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, c.getId());
    }

    /** Error 220: negative ID (z. B. -5) → Exception. */
    @Test @Order(220)
    void test220_setIdNegative() {
        Customer c = new Customer();
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class, () -> c.setId(-5)
        );
        assertEquals("id < 0", ex.getMessage());
        assertEquals(-1, c.getId()); // ID bleibt unverändert
    }

    /** Error 221: setId(-1) sollte auch nicht erlaubt sein. */
    @Test @Order(221)
    void test221_setIdNegativeOne() {
        Customer c = new Customer("Test");
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class, () -> c.setId(-1)
        );
        assertEquals("id < 0", ex.getMessage());
        assertEquals(-1, c.getId());
    }
}
