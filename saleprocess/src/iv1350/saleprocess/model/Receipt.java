package iv1350.saleprocess.model;

/**
 * Represents the receipt of a sale.
 */
public class Receipt {
	
	public Receipt() {
	}
/**
 * Simple output that tells that the receipt was successfully created.
 */
	public void receiptOutput() {
		System.out.println("Receipt was created successfully.");
	}
	/**
	 * Method that creates a String representation of all the sale prices. Prints the sale price
	 * with and without tax, and the change that the customer gets back from cashier.
	 * @param activeSaleDTO brings the information about the sale price amounts.
	 * @param endSale brings the information about the change amount.
	 * @return string returns empty String. Method prints all the text before return.
	 */
	public String receiptToString(SaleDTO activeSaleDTO, EndSale endSale) {
		String string = "";
		StringBuilder sb = new StringBuilder();
		sb.append("********** RECEIPT **********" + "\n" + "\n" +
				"Total: " + activeSaleDTO.getPriceExTax() + " SEK ex tax." + "\n" +
				"Total: " + activeSaleDTO.getPriceIncTax() + " SEK inc tax." + "\n" +
				"Change: " + endSale.getChange()+ " SEK inc tax.");
		System.out.println(sb);
		return string;
	}
}
