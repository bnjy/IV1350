package iv1350.saleprocess.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import iv1350.saleprocess.dbhandler.ItemDTO;
import iv1350.saleprocess.dbhandler.ItemInventory;

public class SaleDTOTest {
	private SaleDTO saleDTO;
	private ItemDTO itemDTO;
	private double priceExTax;
	List<ItemDTO> shoppingCart = new ArrayList<ItemDTO>();
	private double runningTotalIncTax;

	@Before
	public void setUp() throws Exception {
		itemDTO = new ItemDTO("banana", 20.0, "001");
		priceExTax = 100;
		runningTotalIncTax = 110; 
		shoppingCart.add(itemDTO);
		saleDTO = new SaleDTO(itemDTO, priceExTax, runningTotalIncTax, shoppingCart);
	}

	@After
	public void tearDown() throws Exception {
		saleDTO = null;
	}
	
	@Test
	public void testEqualsJavaLangObject() {
		Object object = new Object();
		boolean expResult = false;
		boolean result = saleDTO.equals(object);
		assertEquals("SaleDTO instance equal to " +
					"java.lang.Object instance.",
					expResult, result);
	}
}
