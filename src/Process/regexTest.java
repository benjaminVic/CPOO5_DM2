package process;

import static org.junit.Assert.*;

import org.junit.Test;

public class regexTest {

	@Test
	public void testLs() {
		Ls l = new Ls(456, "ls");		
		try {
			l.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this regular expression is wrong");
		}
		
		Ls l2 = new Ls(667, "     ls    ");
		
		try {
			l2.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this regular expression is wrong");
		}
	}

	
}
