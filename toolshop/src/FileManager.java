package toolshop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

/**
 * 
 * @author ragya
 * this class reads the supplierlist and itemlist from the txt files 
 */
public class FileManager 
{
	private File itemtxt;
	private File suppliertxt;
	ArrayList<Supplier> listOfSuppliers;
	
	/**
	 * default constructor of FileManager, connects the items and suppliers txt files
	 */
	public FileManager()
	{
		itemtxt = new File("items.txt");
		suppliertxt =new File ("suppliers.txt");
	}
	
	/**
	 * 
	 * @return SupplierList (not arraylist), containing array of suppliers from suppliers.txt
	 * @throws FileNotFoundException
	 */
	public SupplierList readSuppliers() throws FileNotFoundException
	{
		ArrayList <Supplier> mySuppliers;
		mySuppliers = new ArrayList();
		Scanner scan = new Scanner (suppliertxt);
		
		int Id;
		String name; 
		String address; 
		String contact;
		String [] temp;
	
		
		while(scan.hasNextLine())
		{
			/**
			 * scans and splits at semicolon, making a new index in the temp array after each semicolon
			 */
			temp = scan.nextLine().split(";");
			Id = Integer.parseInt(temp[0]);
			name = temp[1];
			address = temp[2];
			contact = temp[3];
			/**
			 * calls constructor in Supplier class to initialize supplier
			 */
			Supplier temp1 = new Supplier(Id,name,address,contact);
			/**
			 * adds one supplier to the supplier list in each iteration of loop
			 */
			mySuppliers.add(temp1);
		}
		/**
		 * initialize supplierlist with arraylist of suppliers
		 */
		SupplierList theSuppliers = new SupplierList(mySuppliers);
		listOfSuppliers = mySuppliers;
		return theSuppliers;
	}
	/**
	 * 
	 * @param id
	 * @return returns the Supplier found using the id of the supplier
	 */
	public Supplier searchSupplier(int id)
	{
		for(int i= 0; i<listOfSuppliers.size(); i++)
		{
			if(listOfSuppliers.get(i).getSupplierId()==id)
			{
			return listOfSuppliers.get(i);
			}
		}
		return null;
	}
	/**
	 * reads the items into an Inventory
	 * @return Inventory of items found in items.txt
	 * @throws FileNotFoundException if not found file
	 */
	public Inventory readItems() throws FileNotFoundException
	{
		ArrayList <Item> myItems;
		myItems = new ArrayList();
		Scanner scan = new Scanner (itemtxt);
		
		String [] temp;
		int Id;
		String name;
		int quantity;
		double price;
		int supplierId;
		
		while(scan.hasNextLine())
		{
			temp = scan.nextLine().split(";");
			Id = Integer.parseInt(temp[0]);
			name = temp[1];
			quantity = Integer.parseInt(temp[2]);
			price = Double.parseDouble(temp[3]);
			supplierId = Integer.parseInt(temp[4]);
			/**
			 * searching for the supplier from supplierId, 
			 * then passing the supplier onto constructor of Item
			 */
			Supplier temp1;
			temp1 = searchSupplier(supplierId);
			Item newItem=null;
			if(temp1!=null)
			{
				newItem = new Item(Id,name,quantity,price,temp1);
			}
			/**
			 * adds one item to Inventory per iteration of loop
			 */
			myItems.add(newItem);
		}
		/**
		 * Inventory constructor, as arraylist cannot be returned in this fucntion
		 */
		Inventory theInventory = new Inventory(myItems);
		return theInventory;
	}


}
