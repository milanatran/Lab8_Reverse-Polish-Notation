package Lab8;

/**
 * The testing class for the Postfix class.
 * 
 * @author Ruth Wenzel
 * @version 2021-06-06
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PostfixTest {
	private Postfix p;
	@Test
	void testEvaluate(){
		Postfix p = new Postfix();
		assertEquals(5 , p.evaluate("12*3+"));
		assertEquals(7 , p.evaluate("123*+"));
		assertEquals(13 , p.evaluate("34*21-+"));
		assertEquals(98,75 , p.evaluate("12+34/+5+678+*+"));
		assertEquals(-1 , p.evaluate("91-2-32*-1-"));
	}
}
