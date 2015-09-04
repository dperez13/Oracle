/**
 * 
 */
package controller;

import model.WoodItem;
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
	public static void main(String[] args) {

		//Assumption is that args[0] will contain filename for input text. 
		if(args.length < 1)
			System.exit(-1);	//Exit if we do not provide a filename. 
		HardwoodSeller theDealer = new HardwoodSeller(); 
		//Maintaining parallel arraylists with buyer and seller information.
		ArrayList<String> buyerStrings = new ArrayList<String>();
		ArrayList<String> orderStrings = new ArrayList<String>();
		ArrayList<ArrayList<String> > buyerInformation = new ArrayList<ArrayList<String>>(); //First dimension contains a single buyer, second dimension holds full name, address, date.
		ArrayList<ArrayList<WoodItem> > orderInformation = new ArrayList<ArrayList<WoodItem>>(); 
		theDealer.readInputFile(args[0], buyerStrings, orderStrings);
		for(String buyer: buyerStrings){
			ArrayList<String> temp = theDealer.initBuyerInfo(buyer);
			buyerInformation.add(temp);
		}
		for(String order: orderStrings){
			ArrayList<WoodItem> temp = theDealer.initOrderInfo(order);
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
   
   public ArrayList<String> initBuyerInfo(String buyerString) {
	   ArrayList<String> ret = new ArrayList<String>();
	   //TODO: Parse string into buyer info.
	   return ret;
   }
   public ArrayList<WoodItem> initOrderInfo(String orderString) {
	   ArrayList<WoodItem> ret = new ArrayList<WoodItem>();
	   //TODO: Parse string into new wood item. 
	   return ret;
   }
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
