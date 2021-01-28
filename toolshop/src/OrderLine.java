package toolshop;

/**
 * 
 * @author ragya
 * this class is the individual orderline for one whole order
 */
public class OrderLine {
	/**
	 * orderline uses Item to connect to Item class 
	 */
	private Item theItem;
	public int orderAmount; 
	/**
	 * constructor Orderline
	 * @param Item a is connected
	 * @param Number of items connected
	 */
	public OrderLine(Item a, int n)
	{
		theItem= a;
		orderAmount=n; 
	}
	/**
	 * getters for Item and orderamount
	 */
	public Item getItem() {return theItem;}
	public int getOrderAmount() {return orderAmount;}
	/**
	 * prints the individual orderline of one order
	 */
	public void printOrder()
	{
		
		System.out.println("\nItem description: " + theItem.getItemName() +
				"\nAmount Ordered: " + getOrderAmount() + "\nSupplier: " + theItem.getSupplier().getSupplierName() + "\n" );
	}
}
