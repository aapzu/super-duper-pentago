
package fi.aapzu.pentago.logic.marble;

import fi.aapzu.pentago.logic.Board;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MarbleTest {
    
    Marble m;
    
    public MarbleTest() {}
    
    @Before
    public void setUp() {
        m = new Marble(Symbol.X);    
    }
    
    @After
    public void tearDown() {
        m = null;
    }
    
    @Test
    public void constructorSetsTheSymbol() {
        assertEquals(m.getSymbol(), Symbol.X);
    }

    @Test
    public void toStringReturnsRightString() {
        assertEquals("[X]", m.toString());
        m = new Marble(Symbol.O);
        assertEquals("[O]", m.toString());        
    }
    
    @Test
    public void equalsReturnsTrueWhenTwoMarbleswithSameSymbols() {
        assertTrue(m.equals(new Marble(Symbol.X)));
        m = new Marble(Symbol.O);
        assertTrue(m.equals(new Marble(Symbol.O)));
    }
    
    @Test
    public void equalsReturnsFalseWhenTwoMarblesAreNotEquals() {
        assertFalse(m.equals(new Marble(Symbol.O)));
        assertFalse(m.equals(new Board()));
        assertFalse(m.equals(null));
    }
}
