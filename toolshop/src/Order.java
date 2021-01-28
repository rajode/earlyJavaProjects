
package toolshop;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

/**
 * 
 * @author ragya
 * the class which consists of the whole order, made up of smaller orderlines
 */

public class Order {
	/**
	 * the order has a date for each new order
	 */
private Date today;

/**
 * the random generated order id, which is created below
 */
private int orderId;
	    
/**
 * this class consists of an array of orderlines
 */
private ArrayList<OrderLine> orderList;

	   
/**
 * default constructor for Order
 */
public Order() 
{
	  today = Calendar.getInstance().getTime();
	  orderList = new ArrayList<OrderLine>();
}

/** 
 * adds orderLine to the list of orders
 * @param a, the orderline
 */
public void addOrderLine(OrderLine a) {orderList.add(a);}

/**
 * simple getters and setters for this class
 */
public ArrayList<OrderLine> getOrderLine() {return orderList;}

	    
public void setOrderLines(ArrayList<OrderLine> a) {orderList = a; }

	   
public int getOrderId() {return orderId;}

public void setOrderId(int a) {orderId =a; }

	  
/** 
 * prints out the full order with the help of the printOrder in orderLine class
 */
public void printOrder() {
	
System.out.println("\n" + "******************************************");
for(int i=0; i<orderList.size(); i++) 
{ 
	Random rando= new Random();
	int x = 9999+rando.nextInt(90001);

	System.out.println("\nORDER ID: " + x + "\nDate Ordered: " + today.toString());
		orderList.get(i).printOrder();
	System.out.println("\n" + "******************************************");
}
}
}