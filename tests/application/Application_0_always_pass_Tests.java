package application;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse zur Verifikation des JUnit-Setups.
 * <p>
 * Alle {@code @Test}-Methoden in dieser Klasse bestehen immer – damit
 * lässt sich prüfen, ob JUnit sowohl in der IDE als auch im Terminal korrekt
 * konfiguriert ist.
 * </p>
 *
 * <p>
 * Viele Test-Runner führen Tests parallel aus; die Reihenfolge ist daher
 * grundsätzlich undefiniert, sofern sie nicht explizit durch {@link Order}
 * festgelegt wird. Gemeinsamen (statischen) Zustand solltest du vermeiden.
 * </p>
 *
 * @version {@value application.package_info#Version}
 * @author  {@value application.package_info#Author}
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Application_0_always_pass_Tests {

    /** Wird einmalig vor allen {@code @Test}-Methoden ausgeführt. */
    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("setUpBeforeClass() runs once before any @Test method");
    }

    /** Wird vor jeder {@code @Test}-Methode ausgeführt. */
    @BeforeEach
    void setUpBeforeEach() {
        System.out.println("setUpBeforeEach() runs before each @Test method");
    }

    /** Erster Test (besteht immer). */
    @Test
    @Order(1)
    void test_001_always_pass() {
        assertEquals(10, 10);
    }

    /** Zweiter Test (besteht immer). */
    @Test
    @Order(2)
    void test_002_always_pass() {
        assertEquals(10, 10);
    }

    /** Wird nach jeder {@code @Test}-Methode ausgeführt. */
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("tearDownAfterEach() runs after each @Test method");
    }

    /** Wird einmalig nach allen {@code @Test}-Methoden ausgeführt. */
    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("tearDownAfterAll() runs after all @Test methods have finished");
    }
}
