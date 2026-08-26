package module3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    
    @Test
    void constructor_setsNameCorrectly(){
        Contact c = new Contact("Ada Lovelace", "+1 617 555 0101");
        assertEquals("Ada Lovelace", c.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly(){
        Contact c = new Contact("Ada Lovelance", "+1 617 555 0101");
        assertEquals("+1 617 555 0101", c.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed(){
        Contact c = new Contact("Grace Hopper", "555-0000");
        assertEquals("Grace Hopper", c.getName());
    }

    @Test
    void toString_containsName(){
        Contact c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("Alan Turing"));
    }

    @Test
    void toString_ContainsPhone(){
        Contact c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("555-0001"));
    }

    @Test
    void twoDifferentContactObjectsWithSameName_AreIndependent(){
        Contact c1 = new Contact("Grace Hopper", "555-0000");
        Contact c2 = new Contact("Grace Hopper", "555-0000");

        c1.setPhone("555-9999");

        assertEquals("555-9999", c1.getPhone());
        assertEquals("555-0000", c2.getPhone());
    }
}
