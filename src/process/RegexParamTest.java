package process;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import shell.Minishell;

@RunWith(Parameterized.class)
public class RegexParamTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Parameters(name = "{0} => {1}")
	public static List<Object[]> suite() {
		return Arrays.asList(
				new Object[] {" cd .//", false},
				new Object[] {" cd .", true});
	}

	@Parameter(value = 0)
	public String _regex;
	
	@Parameter(value = 1)
	public boolean _result;

	@Test
	public void test() {

		Cd cd = new Cd(_regex);
		try {
			cd.regexp();
			if (!_result) {
				fail("this string " + _regex + " should have been wrong");
			}
		} catch (Exception e) {
			if (_result) {
				fail("this string " + _regex + " is wrong");
			}
		}
	}

	

}
