import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('c', 'b'));
        assertTrue(offByOne.equalChars('s', 't'));
        assertTrue(offByOne.equalChars('6', '7'));
        assertTrue(offByOne.equalChars('1', '0'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('c', 'c'));
        assertFalse(offByOne.equalChars('s', 's'));
        assertFalse(offByOne.equalChars('6', '4'));
        assertFalse(offByOne.equalChars('1', '3'));
        assertFalse(offByOne.equalChars('b', 'm'));
    }
}
