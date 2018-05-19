package iv1350.saleprocess.dbhandler;

/**
 * This is the ItemDTO object for the saleprocess. All the items information are stored in this object.
 */
public class ItemDTO {
	
	private String name;
	private double price;
	private String itemId;
	private int quantity;
	
/**
 * The ItemDTO creates a DTO of the item.
 * @param name Representing the item name.
 * @param price Representing the item price.
 * @param itemId Representing the item identification number.
 */
	public ItemDTO(String name, double price, String itemId) {
		this.name = name;
		this.price = price;
		this.itemId = itemId;
	}
	
	public String getName() {
		return this.name;		
	}
	
	public double getPrice() {
		return this.price;
	}

	public String getItemId() {
		return this.itemId;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return  this.quantity;
	}
	
}
