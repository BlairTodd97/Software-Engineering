package souschef.app.base;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import souschef.app.base.dtos.TipsDTO;

@SpringBootTest
public class TipsDTOTests {

    TipsDTO tip = new TipsDTO();

    @BeforeEach
    public void setUp() {
        tip.setTitle("Java Tests");
        tip.setTipDescription("Java Tests Descriptions; omg eggs");
        tip.setDifficulty(0);
    }

    @Test
    public void testGetters() {
        // testing Title first
        assertTrue(tip.getTitle().equals("Java Tests"));
        assertFalse(tip.getTitle().equals("NOT CORRECT"));

        tip.setTitle("New Title");
        assertTrue(tip.getTitle().equals("New Title"));

        // testing Descriptions
        assertTrue(tip.getTipDescription().equals("Java Tests Descriptions; omg eggs"));
        assertFalse(tip.getTipDescription().equals("INCORRECT OH NO!"));

        tip.setTipDescription("Describing the new tip");
        assertTrue(tip.getTipDescription().equals("Describing the new tip"));

        // testing difficulty
        assertTrue(tip.getDifficulty() == 0);
        assertFalse(tip.getDifficulty() == 2);
    }

}
