import org.example.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressTest {

    @Test
    void testValidPostalCode() {
        assertTrue(Address.isPostalCodeValid("A1B2C3"));
        assertTrue(Address.isPostalCodeValid("Z9Y8X7"));
    }

    @Test
    void testInvalidPostalCode() {
        assertFalse(Address.isPostalCodeValid("123456"));
        assertFalse(Address.isPostalCodeValid("ABCDEF"));
        assertFalse(Address.isPostalCodeValid("A1B2C"));
        assertFalse(Address.isPostalCodeValid("A1B2C34"));
        assertFalse(Address.isPostalCodeValid("A1!2C3"));
    }
}
