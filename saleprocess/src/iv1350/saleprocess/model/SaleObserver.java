package iv1350.saleprocess.model;
/**
 * Notified when sale has ended (been payed).
 */
public interface SaleObserver {
    /**
     * Called when the sale is ended and has been paid.
     *
     * @param currentRevenue is the current sales total inc tax.
     */
    void saleRevenueChanged(double currentRevenue);
}
