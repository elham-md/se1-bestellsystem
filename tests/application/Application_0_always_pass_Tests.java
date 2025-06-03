package application;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to verify the JUnit test setup.
 * All {@code @Test} methods in this class always pass.
 * 
 * <p>Tests should run both in the IDE and from the terminal.
 * Note: Most test runners execute tests in parallel, so the order
 * is undefined unless explicitly controlled. Avoid shared state.
 *
 * @version <code style="color:green">{@value application.package_info#Version}</code>
 * @author <code style="color:blue">{@value application.package_info#Author}</code>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Application_0_always_pass_Tests {

    /**
     * Method executed once before any {@code @Test} method.
     */
    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("setUpBeforeClass() runs once before any @Test method");
    }

    /**
     * Method executed before each {@code @Test} method.
     */
    @BeforeEach
    public void setUpBeforeEach() {
        System.out.println("setUpBeforeEach() runs before each @Test method");
    }

    /**
     * Method executed after each {@code @Test} method.
     */
    @AfterEach
    public void tearDownAfterEach() {
        System.out.println("tearDownAfterEach() runs after each @Test method");
    }

    /**
     * Method executed once after all {@code @Test} methods.
     */
    @AfterAll
    public static void tearDownAfterAll() {
        System.out.println("tearDownAfterAll() runs after all @Test methods have finished");
    }

    /**
     * First test method (always passes).
     */
    @Test
    @Order(1)
    void test_001_always_pass() {
        int expected = 10;
        int actual = 10;
        assertEquals(expected, actual);
    }

    /**
     * Second test method (always passes).
     */
    @Test
    @Order(2)
    void test_002_always_pass() {
        int expected = 10;
        int actual = 10;
        assertEquals(expected, actual);
    }
}
