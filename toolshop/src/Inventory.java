package toolshop;
import java.util.ArrayList;

public class Inventory {

/**
 * Inventory is an array of type Item
 */
private ArrayList <Item> itemList;
/**
 * Inventory contains Order which consists of Orderlines and Date
 */
private Order theOrder;
/**
 *  default constructor of inventory
 */
public Inventory() {theOrder = new Order();}
/**
 * This function is called from Shop and continues to call decreaseitemquantity from Item, 
 * and also places an order for the item
 * @param name of item to be decreased and ordered
 * @return
 */
public Item manageItem(String name)
{
	Item theItem= new Item();
	
	int i;
	for(i=0; i< itemList.size(); i++) 
	{
		if(itemList.get(i).getItemName().equals(name)) 
		{
			theItem= itemList.get(i);
			break;
		}
	}
	if(theItem!= null && theItem.getItemQuantity()< 40 && !(theItem.isOrdered()) && theItem.getItemQuantity()>0) {
	 placeOrder(theItem);
	}
	if((theItem.decreaseItemQuantity())== true)
		return theItem;
	else
		return null;
	
}
/**
 * places order of passed Item, adding the orderline to the array in theOrder
 * @param theItem
 */
public void placeOrder(Item theItem)
{
	OrderLine z= theItem.createOrderLine();
	if(theOrder!= null) {
		theOrder.addOrderLine(z);
	}
}
/**
 * lists all items by calling printitem in each iteration of the arraylist
 */
public void listAllItems() 
{
	for(int i=0; i<itemList.size(); i++) 
	itemList.get(i).printItem();
	
	
System.out.println("\n**************************************************************************************************************************");
	
}
/**
 * 
 * @param arraylist of Item
 * function initializes Order member and sets parameter a to itemList
 */
public Inventory(ArrayList <Item> a)
{
	itemList=a;
	theOrder = new Order();
}


/**
 * this function finds the item by id and then calls the print function to print out the individual items information
 * @param id
 */
public void getItem(int id) {
	int i;
	for(i=0; i< itemList.size(); i++) 
	{
		if(itemList.get(i).getItemId()== id) {
			itemList.get(i).printItem();
			System.out.println("\n**************************************************************************************************************************");
			break;}
	}
	if(itemList.get(i) == null)
		System.out.println("couldnt find the item by id, try again!");	
}
/**
 * this function finds the item by NAME and then calls the print function to print out the individual items information
 * @param name
 */
public void getItem(String name) {
	int i;
	for(i=0; i< itemList.size(); i++) 
	{
		if(itemList.get(i).getItemName().equals(name)) {
			itemList.get(i).printItem();
			System.out.println("\n**************************************************************************************************************************");
			break;}
	}
	if(itemList.get(i) == null)
		System.out.println("couldnt find the item by name, try again!");
}
/**
 * Function first finds the item by name and then calls member function "getItemQuantity()" of Item 
 * @param name
 */
public void getItemQuantity(String name)
{
	int i;
	for(i=0; i< itemList.size(); i++) 
	{
		if(itemList.get(i).getItemName().equals(name)) {
			System.out.println("The item quantity for " + itemList.get(i).getItemName() + " is " + itemList.get(i).getItemQuantity());
			System.out.println("\n**************************************************************************************************************************");
			break;
		}
		if(itemList.get(i) == null)
			System.out.println("item quantity cannot be determined as item not found");
}
}
/**
 * calls printorder in class Order
 */
public void printOrder() { theOrder.printOrder();	}
}
