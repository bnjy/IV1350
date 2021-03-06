package iv1350.saleprocess.dbhandler;

import java.util.*;

import iv1350.saleprocess.controller.OperationFailedException;
import iv1350.saleprocess.model.ItemIdentifierException;
/**
 * This is the item inventory for the saleprocess. All items are created here.
 */
public class ItemInventory {
	List<ItemDTO> itemInventoryList = new ArrayList<ItemDTO>();
	
    /**
     * The ItemInventory creates three items of {@link ItemDTO}.
     */
	public ItemInventory() {
		itemInventoryList.add(new ItemDTO("banana", 20.0, "001"));
		itemInventoryList.add(new ItemDTO("apple", 10.0, "002"));
		itemInventoryList.add(new ItemDTO("strawberry", 10.0, "003"));
	}

	/**
	 * The method searchItem searches the list itemInventoryList to see if the searched item is
	 * available there. If the itemId equals "004" the method databaseExceptionHandler are called and 
	 * throws an exception, that are caught in this method.
	 * If the ItemDTO object equals null (in other words the item does not belong to the inventory), an exception
	 * of {@link ItemIdentifierException} are throwed. This exception are later catched in the View.
	 *
	 * @param itemId The searched articles identification number.
	 * @return item The returned item if it is available.
	 * @throws ItemIdentifierException
	 * @throws OperationFailedException 
	 */
	public ItemDTO searchItem(String itemId) throws ItemIdentifierException, OperationFailedException  {
		ItemDTO item = null;
		
		if(itemId == "004") {
			throw new DatabaseFailException("Failed to establish connection with database.");
		}
			
		for(ItemDTO itemInList : itemInventoryList) {
				if(itemInList.getItemId().equals(itemId)) {
					item = itemInList;
				}
		}
		
		if(item == null) {
			throw new ItemIdentifierException(itemId);
		}
		
		return item;
	}
	
    /** The void method updateItemInventorySystem returns a "fake" call that the inventory system
    * has been updated.
    */
	public void updateItemInventorySystem() {
		System.out.println("Inventory system was updated.");
	}
}
