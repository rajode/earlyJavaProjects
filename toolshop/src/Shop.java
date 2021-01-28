package toolshop;

public class Shop {
private Inventory theInventory;
private SupplierList theSuppliers;
/**
 * constructor Shop
 * @param inventory a connects to member variable theInventory
 * @param supplierlist b connects to the supplierlist
 */
public Shop(Inventory a, SupplierList b) 
{
	theInventory =a;
	theSuppliers =b;
}
/**
 * simple setter and getter for Inventory
 */
public Inventory getTheInventory() {
	return theInventory;
}
public void setTheInventory(Inventory a) {
	theInventory = a;
}
/** 
 * calls manageitem in inventory
 * @param name
 * @return String which confirms decrease of quantity
 */
public String decreaseItem(String name) {
	if(theInventory.manageItem(name)== null) 
	{
		return "Could not decrease item quantity!\n**************************************************************************************************************************";
		
	}
	else 
	{
		return "Item quantity was decreased!\n**************************************************************************************************************************";
	}
}
/**
 * caller function to Inventory class which lists all items 
 */
public void listAllItems() {
	theInventory.listAllItems();
}
/**
 * caller function to Inventory class which lists all suppliers (unused) 
 */
public void listAllSuppliers() {
	theSuppliers.listAllSuppliers();
}
public void getItem(String name) { theInventory.getItem(name);}

public void getItem(int id) {theInventory.getItem(id);}


public void getItemQuantity(String name) 
{
	theInventory.getItemQuantity(name);
}
/**
 * calls printOrder in inventory 
 */
public void printOrder() 
{
	theInventory.printOrder();
}
}
