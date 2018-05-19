package iv1350.saleprocess.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EndSaleTest {
	private EndSale endSale;

	@Before
	public void setUp() throws Exception {
		endSale = new EndSale();
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testEqualsNull() {
		Object object = null;
		boolean expResult = false;
		boolean result = endSale.equals(object);
		assertEquals("EndSale instance equal to null.",
				expResult, result);
	}
	
	@Test
	public void testEqualsJavaLangObject() {
		Object object = new Object();
		boolean expResult = false;
		boolean result = endSale.equals(object);
		assertEquals("EndSale instance equal to " +
					"java.lang.Object instance.",
					expResult, result);
	}

	@Test
	public void testNegativeChange() {
		double paidAmount = 100.0;
		double cartPrice = 100.0;
		boolean expResult = true;
		
		endSale.change(paidAmount, cartPrice);
		double result = endSale.getChange();
		if(result < 0) {
			expResult = false;
		}
		assertTrue("Wrong subtraction result", expResult);
	}
	
	
}
