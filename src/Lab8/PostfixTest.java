package Lab8;

/*
 * The testing class for the Postfix class.
 * 
 * @author Ruth Wenzel
 * @version 2021-06-06
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PostfixTest {
	private Postfix p;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//StackAsList<String> stack = new StackAsList<>();
		//Postfix p = new Postfix();
	}

	@Test
	void testEvaluate() {
		Postfix p = new Postfix();
		//p.evaluate("21+3*");
		assertEquals(5, p.evaluate("213*+"));
	}

}
