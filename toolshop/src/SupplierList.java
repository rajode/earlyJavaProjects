package toolshop;
import java.util.ArrayList;
/**
 * @author ragya
 * arraylist of type supplier created in this class
 */

public class SupplierList {
	ArrayList <Supplier> suppliers;
/**
 * prints all suppliers by calling print supplier for 
 * each iteration of the arraylist of suppliers
 */
public void listAllSuppliers()
{
	for(int i=0; i<suppliers.size(); i++)
		suppliers.get(i).printSupplier();
	
	System.out.println("\n**************************************************************************************************************************");
}
/**
 * constructor
 * @param a
 */
public SupplierList(ArrayList<Supplier>a) {suppliers=a;}
	

}
