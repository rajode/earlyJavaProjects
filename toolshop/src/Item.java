package toolshop;
/**
 * 
 * @author ragya
 *
 */
public class Item {
/**
 * member variables of item class consisting of items information 
 * including item's id, name, price and quantity
 */
private int itemId;
private String itemName;
private double itemPrice;
private int itemQuantity;
/**
 * Item class has a Supplier, this connects the Item to the supplier
 */
private Supplier theSupplier;

/**
 * this variable can be switched to true to determine if an order is necessary
 */
private boolean alreadyOrdered;
/**
 * default constructor for Item
 */
public Item() 
{
	itemId =0;
	itemName= null; 
	itemQuantity=0; 
	itemPrice=0; 
	theSupplier=null;
	alreadyOrdered= false;
}
/**
 * 
 * @param a
 * @param b
 * @param c
 * @param d
 * @param e
 */
public Item(int a, String b, int c, double d, Supplier e) {
	itemId= a;
	itemName= b;
	itemQuantity= c;
	itemPrice= d;
	theSupplier = e;
	alreadyOrdered= false;
}

/**
 * 
 * @return true if quantity of item is greater than 0 and decrease quantity by 1
 */
public boolean decreaseItemQuantity() {
	if(itemQuantity > 0) {
		itemQuantity--;
		return true;}
	return false;
}

/*public OrderLine createOrder()
{
	OrderLine thisOrder;
	if(getItemQuantity() < 40) {
		int n= 40- itemQuantity; 
		thisOrder = new OrderLine(this, n);
		
	}
	return null;
}*/
/**
 * basic getters and setters to obtain member variables of Item class
 * 
 */
public int getItemId() {return itemId;}

public String getItemName() {return itemName;}
public void setItemName(String a) {itemName=a;}

public void setItemId(int a) {itemId=a;}

public int getItemQuantity() {return itemQuantity;}

public void setItemQuantity(int a) {itemQuantity=a;}

public void setitemPrice(double a) {itemPrice=a;}

public double getitemPrice() {return itemPrice;}

public Supplier getSupplier() {return theSupplier;}

public void setSupplier(Supplier a) {theSupplier=a;}
public boolean isOrdered() {return alreadyOrdered;}
/**
 * prints one individual item's information 
 */
public void printItem()
{
	System.out.println("ID: " + itemId + ", " + "Name: " + itemName + ", " + "Quantity: " +itemQuantity + ", " 
+ "Price: " + itemPrice  + ", " +  "Supplier's ID:  " + theSupplier.getSupplierId());
}
/**
 * 
 * @returns an Orderline made of this item and of quantity 50- current quantity (if quantity is less than 40 AND not ordered)
 */
public OrderLine createOrderLine() 
{
	
	if(getItemQuantity()<40 && alreadyOrdered == false)
	{
		OrderLine theOrderLine = new OrderLine(this, 50- (getItemQuantity()));
		alreadyOrdered=true; 
		return theOrderLine;
	}
	if(alreadyOrdered == true)
	System.out.println("Already Ordered!");
	return null;
		
}
}

