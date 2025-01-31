import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringMethTest {

	@Test
	void testNChar() {
		StringMeth m = new StringMeth();
		assertEquals(2, m.nChar("aa", 'a'));
	}

	@Test
	void testIsPalindroma() {
		StringMeth m = new StringMeth();
		assertEquals(true, m.isPalindroma("aaa"));
	}

}
