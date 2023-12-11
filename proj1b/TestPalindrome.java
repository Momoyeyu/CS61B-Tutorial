import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        // para: word
        assertTrue(palindrome.isPalindrome("abcba"));
        assertTrue(palindrome.isPalindrome("MomoomoM"));
        assertTrue(palindrome.isPalindrome("cs61b16sc"));
        assertFalse(palindrome.isPalindrome("Abcba"));
        assertFalse(palindrome.isPalindrome("Momoyeyu"));
        assertFalse(palindrome.isPalindrome("CS61B"));

        // para: word, cc
        CharacterComparator obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("123v210", obo));
        assertTrue(palindrome.isPalindrome("168950", obo));
        assertTrue(palindrome.isPalindrome("FLaKE", obo));
        assertTrue(palindrome.isPalindrome("flake", obo));
        assertFalse(palindrome.isPalindrome("cs61b16sc", obo));
        assertFalse(palindrome.isPalindrome("BB61b16BB", obo));
        CharacterComparator ob5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("faa", ob5));
        assertTrue(palindrome.isPalindrome("FaA", ob5));
        assertFalse(palindrome.isPalindrome("FucK", ob5));
        assertFalse(palindrome.isPalindrome("duck", ob5));
        CharacterComparator ob3 = new OffByN(3);
        assertTrue(palindrome.isPalindrome("DadA", ob3));
        assertFalse(palindrome.isPalindrome("Fuck", ob3));
    }
}
