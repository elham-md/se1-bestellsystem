package datamodel;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Customer_200_Id_Tests {

    private Customer customer;

    @BeforeEach
    void setup() {
        customer = new Customer();
    }

    // 200: getId() direkt nach Konstruktion → null
    @Test
    @Order(200)
    void test200_IdNullAfterConstruction() {
        assertEquals(-1, customer.getId());
    }

    // 201: setId(x) → getId() == x
    @Test
    @Order(201)
    void test201_setIdRegularValue() {
        Long x = 1000L;
        customer.setId(x);
        assertEquals(x, customer.getId());
    }

    // 202: setId(x), setId(y) → getId() == x
    @Test
    @Order(202)
    void test202_setIdRegularValueTwice() {
        Long x = 1000L;
        Long y = 2000L;
        customer.setId(x);
        customer.setId(y);
        assertEquals(x, customer.getId());
    }

    // 210: setId(x), setId(x+1) → getId() == x
    @Test
    @Order(210)
    void test210_setIdMinValue() {
        Long x = 1L;
        customer.setId(x);
        customer.setId(x + 1);
        assertEquals(x, customer.getId());
    }

    // 211: setId(x), setId(x-1) → getId() == x
    @Test
    @Order(211)
    void test211_setIdMaxValue() {
        Long x = Long.MAX_VALUE - 1;
        customer.setId(x);
        customer.setId(x - 1);
        assertEquals(x, customer.getId());
    }

    // 212: setId(0) → erlaubt, wenn gültig
    @Test
    @Order(212)
    void test212_setIdZeroValue() {
        customer.setId(0L);
        assertEquals(0L, customer.getId());
    }

    // 220: setId(-1) → Exception mit Message
    @Test
    @Order(220)
    void test220_setIdWithNegativeArguments() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            customer.setId(-1L);
        });
        assertEquals("invalid id (negative)", thrown.getMessage());
    }

    // 221: setId(Long.MIN_VALUE) → Exception mit Message
    @Test
    @Order(221)
    void test221_setIdWithMinLongValue() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            customer.setId(Long.MIN_VALUE);
        });
        assertEquals("invalid id (negative)", thrown.getMessage());
    }
}
