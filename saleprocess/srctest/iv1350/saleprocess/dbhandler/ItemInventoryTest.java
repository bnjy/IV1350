package iv1350.saleprocess.dbhandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemInventoryTest {
	private ItemDTO item;
	private ItemInventory inventory;

	@Before
	public void setUp() throws Exception {
		item = new ItemDTO("apple", 10.0, "002");
		inventory = new ItemInventory();
	}

	@After
	public void tearDown() throws Exception {
		item = null;
		inventory = null;
	}
	
	@Test
	public void testEqualsNull() {
		Object object = null;
		boolean expResult = false;
		boolean result = inventory.equals(object);
		assertEquals("InventoryItem instance equal to null.",
				expResult, result);
	}
	
	@Test
	public void testEqualsJavaLangObject() {
		Object object = new Object();
		boolean expResult = false;
		boolean result = inventory.equals(object);
		assertEquals("ItemInventory instance equal to " +
					"java.lang.Object instance.",
					expResult, result);
	}
	
	@Test
	public void testSearchItemIdNotFound() {
		boolean expResult = true;
		boolean result = true;
		if(inventory.searchItem(item.getItemId()) == null) {
			result = false;
		}
		assertEquals("Item ID not found in inventory",
				expResult, result);	
	}
	
	public void testDoubleMaxValues() {
		boolean expResult = true;
		boolean result = true;
		if(inventory.searchItem(item.getItemId()) == null) {
			result = false;
		}
		assertEquals("Item ID not found in inventory",
				expResult, result);	
	}
}
