package datamodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * Tests für {@link Customer}: Nummern-Bereich [100‥199] – Konstruktor-Tests.
 *
 * <pre>
 *  - Customer()              // Default-Konstruktor
 *  - Customer(String name)   // Konstruktor mit Name-Argument
 * </pre>
 *
 * @author Sakina Mohammadi
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Customer_100_Constructor_Tests {

    /* ——————————————————————————————————— */
    /* Default-Konstruktor (100-er Reihe)  */
    /* ——————————————————————————————————— */

    /** Regular test case 100: Objekt nach Default-Konstruktor hat Grundzustand. */
    @Test @Order(100)
    void test100_DefaultConstructor() {
        Customer c = new Customer();
        assertEquals(-1, c.getId());           // noch keine ID vergeben
        assertEquals("",  c.getLastName());
        assertEquals("",  c.getFirstName());
        assertEquals(0,   c.contactsCount());
    }

    /** Regular test case 101: Setter geben self-reference zurück (Fluent-API). */
    @Test @Order(101)
    void test101_DefaultConstructorChainability() {
        Customer c = new Customer();
        assertSame(c, c.setId(0));
        assertSame(c, c.setName("Eric", "Meyer"));
        assertSame(c, c.setName("Tim Schulz"));
        assertSame(c, c.addContact("eric@gmail.com"));
    }

    /** Regular test case 102: setId(id) wirkt nur beim ersten Aufruf. */
    @Test @Order(102)
    void test102_DefaultConstructorSetIdOnlyOnce() {
        Customer c = new Customer();
        assertEquals(-1, c.getId());
        c.setId(648);
        assertEquals(648, c.getId());
        c.setId(912);               // soll ignoriert werden
        assertEquals(648, c.getId());
    }

    /* ——————————————————————————————————— */
    /* Konstruktor mit String-Name (110‥)   */
    /* ——————————————————————————————————— */

    /** Regular 110: "Eric Meyer" → firstName "Eric", lastName "Meyer". */
    @Test @Order(110)
    void test110_Constructor_FirstLast() {
        Customer c = new Customer("Eric Meyer");
        assertEquals("Meyer", c.getLastName());
        assertEquals("Eric",  c.getFirstName());
    }

    /** Regular 111: "Meyer, Eric" → firstName "Eric", lastName "Meyer". */
    @Test @Order(111)
    void test111_Constructor_LastCommaFirst() {
        Customer c = new Customer("Meyer, Eric");
        assertEquals("Meyer", c.getLastName());
        assertEquals("Eric",  c.getFirstName());
    }

    /** Regular 112: "Meyer" → firstName "", lastName "Meyer". */
    @Test @Order(112)
    void test112_Constructor_LastOnly() {
        Customer c = new Customer("Meyer");
        assertEquals("Meyer", c.getLastName());
        assertEquals("",      c.getFirstName());
    }

    /* Corner 120 – 123 (kürzest / längste zul. Varianten) */

    @Test @Order(120)
    void test120_Constructor_ShortestNames() {
        // "E M"
        Customer c1 = new Customer("E M");
        assertEquals("M", c1.getLastName());
        assertEquals("E", c1.getFirstName());

        // "M, E"
        Customer c2 = new Customer("M , E ");
        assertEquals("M", c2.getLastName());
        assertEquals("E", c2.getFirstName());

        // "M"
        Customer c3 = new Customer(" M ");
        assertEquals("M", c3.getLastName());
        assertEquals("",  c3.getFirstName());
    }

    @Test @Order(121)
    void test121_Constructor_LongFirstLongLast() {
        Customer c = new Customer("Nadine Ulla Maxine Adriane Blumenfeld");
        assertEquals("Blumenfeld",                      c.getLastName());
        assertEquals("Nadine Ulla Maxine Adriane",      c.getFirstName());
    }

    @Test @Order(122)
    void test122_Constructor_LongFirstMultipartLast() {
        Customer c = new Customer("Nadine Ulla Maxine Adriane von-Blumenfeld-Bozo");
        assertEquals("von-Blumenfeld-Bozo",             c.getLastName());
        assertEquals("Nadine Ulla Maxine Adriane",      c.getFirstName());
    }

    @Test @Order(123)
    void test123_Constructor_MultipartLastCommaFirst() {
        Customer c = new Customer("von-Blumenfeld-Bozo, Nadine Ulla Maxine Adriane");
        assertEquals("von-Blumenfeld-Bozo",             c.getLastName());
        assertEquals("Nadine Ulla Maxine Adriane",      c.getFirstName());
    }

    /* Exception-Fälle 130 / 131 */

    @Test @Order(130)
    void test130_Constructor_EmptyName() {
        IllegalArgumentException ex =
            assertThrows(IllegalArgumentException.class, () -> new Customer(""));
        assertEquals("name empty", ex.getMessage());
    }

    @Test @Order(131)
    void test131_Constructor_NullName() {
        IllegalArgumentException ex =
            assertThrows(IllegalArgumentException.class, () -> new Customer(null));
        assertEquals("name empty", ex.getMessage()); // splitName() meldet „name empty“
    }
}
