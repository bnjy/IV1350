package iv1350.saleprocess.view;

import iv1350.saleprocess.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    /**
     * Displays the total revenue.
     * @param currentTotalIncTax the current total revenue.
     */
    public void showTotalRevenue(double currentTotalIncTax) {
        System.out.println("\nThe total revenue: " + currentTotalIncTax + " SEK\n");
    }

	@Override
	public void saleRevenueChanged(double currentTotalIncTax) {
		showTotalRevenue(currentTotalIncTax);
	}
}
