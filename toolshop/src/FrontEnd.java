package toolshop;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 
 * @author ragya
 * this class is where the main function is and the calls to all functions take place,
 * however, there is no logic that happens inside this class
 */
public class FrontEnd {
	private Shop theShop;
	private Scanner scan;

	/**
	 * default constructor of FrontEnd()
	 * @throws FileNotFoundException if not found files
	 */
	FrontEnd() throws FileNotFoundException {
		FileManager fileM = new FileManager();
		SupplierList suppliers = fileM.readSuppliers();
		Inventory items= fileM.readItems();
		theShop = new Shop (items, suppliers);
		scan = new Scanner(System.in);
	}
	
	/**
	 * prints the menu of choices 1-7
	 */
	private void printChoices() {
		System.out.println("Please choose from one of the following options:");
		System.out.println("1: List all tools in the inventory");
		System.out.println("2: List all the Suppliers");
		System.out.println("3. Search for tool by tool name");
		System.out.println("4. Search tool by tool id.");
		System.out.println("5. Check item's quantity");
		System.out.println("6. Decrease quantity of item");
		System.out.println("7. Print today's order");
		System.out.println("8. Quit");
		System.out.println();
		System.out.println("Enter your selection: ");
	}
	/**
	 * the menu of the front end, where user inputs their choice
	 */
	public void menu() 
	{
		while (true) {
			printChoices();
			
			int choice = scan.nextInt();
			scan.nextLine();
			switch(choice) 
				{
				case 1:
					theShop.listAllItems();
					break;
				case 2: 
					theShop.listAllSuppliers();
					break;
				case 3:
					searchForItemByName();
					break;
				case 4:
					searchForItemById();
					break;
				case 5:
					checkItemQuantity();
					break;
				case 6:
					decreaseItem();
					break;
				case 7:
					printOrder();
					break;
				case 8:
					System.out.println("\nTerminated!");
					return;
				case 9:
					System.out.println("\nInvalid input, try again.");
					break;
				
			}
			}
		}
/**
 * call to function printOrder in theShop
 */
private void printOrder() {
theShop.printOrder();
}
/**
 * call to function decreaseitem in the shop
 */
private void decreaseItem() 
{
	System.out.println("Enter the name of the item: ");
	String name= scan.nextLine();
	
	System.out.println(theShop.decreaseItem(name));
}
/**
 * call to function getItemQuantity  in the shop
 */
private void checkItemQuantity() {
	System.out.println("Enter the name of the item: ");
	String name= scan.nextLine();
	theShop.getItemQuantity(name);
}

/**
 * call to function searchbyitemid in the shop
 */
private void searchForItemById() {
	System.out.println("Enter the ID of the item: ");
	int id= scan.nextInt();
	theShop.getItem(id);
	
}
/**
 * call to function searchforitembyname  in the shop
 */
private void searchForItemByName() {
	System.out.println("Enter the name of the item: ");
	String name= scan.nextLine();
	theShop.getItem(name);
}
/**
 * main function, where a new frontend is initalized and menu is called for display
 */
public static void main(String[]args)throws FileNotFoundException  {
	FrontEnd start= new FrontEnd();
	start.menu();
}



}
