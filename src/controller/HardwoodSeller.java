/**
 * 
 */
package controller;

import model.WoodItem;
import java.util.Arrays; 
import java.util.ArrayList;
import java.io.FileInputStream;
import java.lang.Exception;
/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
	public class WoodValuePair {
		int amount;
		WoodItem woodType;
		
		WoodValuePair(int a, WoodItem w) {
			amount = a;
			woodType = w;
		}
		public int getAmount() { return amount; }
		public WoodItem getWood() {return woodType; }
		public void print() {
			//TODO: implement printing. 
		}
	}
	
	public static void main(String[] args) {
		//Assumption is that args[0] will contain filename for input text. 
		if(args.length < 1)
			System.exit(-1);	//Exit if we do not provide a filename. 
		HardwoodSeller theDealer = new HardwoodSeller(); 
		//Maintaining parallel arraylists with buyer and seller information.
		ArrayList<String> buyerStrings = new ArrayList<String>();
		ArrayList<String> orderStrings = new ArrayList<String>();
		ArrayList<ArrayList<String> > buyerInformation = new ArrayList<ArrayList<String>>(); //First dimension contains a single buyer, second dimension holds full name, address, date.
		ArrayList<ArrayList<WoodValuePair>> orderInformation = new ArrayList<ArrayList<WoodValuePair>>(); 
		theDealer.readInputFile(args[0], buyerStrings, orderStrings);
		for(String buyer: buyerStrings){
			ArrayList<String> temp = theDealer.initBuyerInfo(buyer);
			buyerInformation.add(temp);
		}
		for(String order: orderStrings){
			ArrayList<WoodValuePair> temp = theDealer.initOrderInfo(order);
			orderInformation.add(temp);
		}
	}
	//Modified read array to take lists that will be initialized here. 
	public void readInputFile(String inputFilePath, ArrayList<String> s1, ArrayList<String> s2){
		 FileInputStream inFile = null;
		try{
         inFile = new FileInputStream(inputFilePath);
         //TODO: finish up reading the file. 
		}catch(Exception e){
			//Keep on chugging
		}
		finally {
		 if (inFile != null) {
			try { 
				inFile.close();
			}catch(Exception e) {
				//Keep on chugging deux
			}
		 }
		}
   }
   
   //Assumption based on the strings being correctly formatted based on assignment writeup. 
   public ArrayList<String> initBuyerInfo(String buyerString) {
	   ArrayList<String> ret = new ArrayList<String>(Arrays.asList(buyerString.split(";")));
	   return ret;
   }
   public ArrayList<WoodValuePair> initOrderInfo(String orderString) {
	   ArrayList<WoodValuePair> orderInfo = new ArrayList<WoodValuePair>();
	   String [] woodItems = orderString.split(";");
	   double price = 0.0;
	   double time = 0.0;
	   for(String s: woodItems){
		   String [] woodItem = s.split(":"); 
		   if(woodItem[0].equals("Cherry")) {	//I know,such a butchery, just strapped for time. 
			   price = 5.95;
			   time = 2.5;
		   } else if(woodItem[0].equals("Curly Maple")) {
			   price = 6.0;
			   time = 1.5;
		   } else if(woodItem[0].equals("Genuine Mahogany")) {
			   price = 9.60;
			   time = 3;
		   } else if(woodItem[0].equals("Wenge")) {
			   price = 22.35;
			   time = 5;
		   } else if(woodItem[0].equals("White Oak")) {
			   price = 6.70;
			   time = 2.3;
		   } else if(woodItem[0].equals("Sawdust")) {
			   price = 1.5;
			   time = 1;
		   }else {
			   price = 0;
			   time = 0;
		   }
		   WoodItem tempItem = new WoodItem(woodItem[0],time,price);
		   int tempValue = Integer.parseInt(woodItem[1]);
		   WoodValuePair tempPair = new WoodValuePair(tempValue, tempItem);
		   orderInfo.add(tempPair); 
	   }
	   return orderInfo;
   }
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
