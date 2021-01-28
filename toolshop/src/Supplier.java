package toolshop;
import java.util.ArrayList;
/** 
 * @author ragya
 * supplier class which contains a particular suppliers information
 */
public class Supplier {
	/**
	 * the member variables of the class Supplier, members where all information is stored from suppliers.txt
	 */
	private int	supplierId;
	private String supplierName;
	private String supplierAddress;
	private String supplierContact;
	private ArrayList<Item> itemList;
/**
 * 
 * @return array list of items
 */
public ArrayList<Item> getItemList() {
	return itemList;
}
/**
 * constructor for Supplier
 * @param a suppliers id
 * @param b company name
 * @param c address 
 * @param d contact name
 */
public Supplier(int a, String b, String c, String d)
{
	supplierId=a;
	supplierName=b;
	supplierAddress=c;
	supplierContact=d;
}

/**
 * @return supplier's id
 */
public int getSupplierId() {return supplierId;}

public String getSupplierName() {return supplierName;}

public void setSupplierName(String a) {supplierName= a;}

public void setSupplierId(int a) {supplierId=a;}

public String getSupplierContact() {return supplierContact;}
public void setSupplierContact(String a) {supplierContact= a;}
/**
 * each individual supplier is printed in this function
 */
public void printSupplier()
{
	System.out.println("Supplier ID: " + supplierId + ", Name: " + supplierName + ", Address: " + supplierAddress + ", Contact: " 
+ supplierContact);
}
}

