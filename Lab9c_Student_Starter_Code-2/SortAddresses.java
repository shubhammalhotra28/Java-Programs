import java.util.*;
import java.io.*;
import java.text.*;

/**
  * class to sort the list of city,state,zip
  * @author Shubham Malhotra
  */
public class SortAddresses
{
   public static void main(String [] args)
   {
   	// Load the entire array list
      ArrayList<Customer> custList = new CustomerList();
   
      for( Customer info : custList )
         System.out.println( info );
   	
      Comparator<Customer> zipComp = new ZipComparator();
      Collections.sort( custList, zipComp );
    
      System.out.println("\n- - Sorted by ID:");
      for( Customer info : custList )
         System.out.println( info );
   
   
      Comparator<Customer> stateComp = new StateComparator();
      Collections.sort( custList, stateComp );
      System.out.println("\n- - Sorted by State and City:");
      for( Customer info : custList )
         System.out.println( info );   
   } // end main
} // end SortAddresses

class ZipComparator implements Comparator<Customer>
{
   public int compare( Customer first, Customer second )
   {
      int fir = first.getZip();
      int sec = second.getZip();
      
      //  return fir-sec;
      
      if ( fir < sec  ) 
         return -1;
      if ( fir == sec ) 
         return 0;
      return 1;
      
   } // end compare()
} // end ZipComparator
class StateComparator implements Comparator<Customer>
{
   public int compare(Customer first,Customer second)
   {
      String fir=first.getState();
      String sec=second.getState();
      int compare=fir.compareTo(sec);                    // compare the name of the state 
      if(compare==0)                                     // if the name if state is found to be same then the cities are compared 
      {
         String f=first.getCity();
         String s=second.getCity();                            
         compare=f.compareTo(s);                         // the cities are ccompared here
      }
      return compare;
   }
}

class Customer
{
   private String address;
   private int    zip;
   private String city;
   private String state;   
   public Customer( String _address, String _city, String _state, int _zip )
   {
      address 	= _address;
      city		= _city;
      state		= _state;
      zip		= _zip;
   } // end Customer constructor

   public String getAddress()	{ 
      return address;	}
   public String getCity()		{ 
      return city;		}
   public String getState()	{ 
      return state;	}
   public int getZip()      	{ 
      return zip;     }
    
   public String toString()
   {
      return String.format("%-30s %-20s %4s %09d",
         getAddress(), getCity(), getState(), getZip() );
   } // end toString()
   
   
} // end class Customer

/** 
	Have the CustomerList class generate the customer list.
	Students: Note how this class is defined, what happens in the constructor
	and how the "new CustomerList()" is used in the main part of this program.
*/
class CustomerList extends ArrayList<Customer> {

	/** this class is just a array list and is written this way so that this class can be used to create more instances of the class "CustomerList" 
       as created in the first line of the Program "custList" */
   public CustomerList() {		
      add(new Customer("132 Commerical Way","Cleveland","OH",442340000) );
      add(new Customer("2421 West Industrial Way","Berkeley","CA",947100000) );
      add(new Customer("2421 West Industrial Way","Berkeley","CA",947100000) );
      add(new Customer("4223 Halster Way","Berkeley","CA",947101234) );
      add(new Customer("4223 Halster Way","Berkeley","CA",947104321) );
      add(new Customer("1 Washington Complex","Boston","MA",21010000) );
      add(new Customer("1 Braddock Circle","Kenmore","NY",142230000) );
      add(new Customer("1 Braddock Circle","Kenmore","NY",142230000) );
      add(new Customer("1 Braddock Circle","Kenmore","NY",142230000) );
      add(new Customer("45511 Delaware Ave.","Buffalo","NY",142210000) );
      add(new Customer("3112 West Helm Street","Kingwood","TX",773390000) );
      add(new Customer("3112 West Helm Street","Kingwood","TX",773390000) );
      add(new Customer("41 Golem Terrace","New York","NY",100120000) );
      add(new Customer("1602 Jackson Ave.","Arlington","VA",222020000) );
      add(new Customer("8871 West Grange Drive","Cairo","NY",124130000) );
      add(new Customer("44 WhiteStallion Pike","Lindenwold","NJ",80210000) );
      add(new Customer("45A Sturgeon Dr., Bldg. 5","Ft. Pierce","FL",349510000) );
      add(new Customer("45A Sturgeon Dr., Bldg. 5","Ft. Pierce","FL",349510000) );
      add(new Customer("776 West Ninth St.","Myrtle Beach","SC",295790000) );
      add(new Customer("6665 Peachtree Lane","Atlanta","GA",303280000) );
      add(new Customer("3 Mapleview Drive","Huntsville","AL",358030000) );
      add(new Customer("67 Merrifield Ave.","Oceanside","NY",115720000) );
      add(new Customer("35 West 9th St.","New York","NY",100120000) );
      add(new Customer("35 West 9th St.","New York","NY",100120000) );
      add(new Customer("5531 E. Lansing Ave.","Ypsilanti","MI",481970000) );
      add(new Customer("7554 West 9th St.","New York","NY",100030000) );
      add(new Customer("4 Rocky Way","Colorado Springs","CO",809410000) );
      add(new Customer("4 Rocky Way","Colorado Springs","CO",809410000) );
      add(new Customer("45521 Pilgrim Circle","Nantucket","MA",25540000) );
      add(new Customer("3 Carnegie Circle","Pittsburgh","PA",151080000) );
      add(new Customer("15 Carnegie Circle","Pittsburgh","PA",151080000) );
      add(new Customer("16 Broad Street","Rochester","NY",146210000) );
      add(new Customer("16 Broad Street","Rochester","NY",146210000) );
      add(new Customer("5665 MassPike Circle","Sandy Hook","CT",64820000) );
      add(new Customer("3 Desert Trail","Las Vegas","NV",891170000) );
      add(new Customer("3 Confederate Ave.","Roanoke","VA",240100000) );
      add(new Customer("44 Rockman Blvd.","Rochester","NY",146230000) );	
   }

}