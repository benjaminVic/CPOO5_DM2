package Process;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegexTest {

	@Test
	public void testLs() {
		Ls l = new Ls("ls");		
		try {
			l.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this regular expression is wrong");
		}
		
		Ls l2 = new Ls("     ls    ");
		
		try {
			l2.regexp();
		} catch (Exception e) {
			e.printStackTrace();
			fail("this regular expression is wrong");
		}
	}

	@Test
	public void lsTest(){
		Ls l = new Ls("ls");
		new Thread(l).start();;
	}
	
}
