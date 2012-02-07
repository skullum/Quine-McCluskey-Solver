package qm_pak;

import java.util.ArrayList;

public class Bstring {
	
	public ArrayList<String> binStrings;
	
	public Bstring(){
		System.out.println("oh noes, wrong variables passed! :O");
	}
	 /**
	   * Converts arraylists of integers to corresponding binary values
	   * Wildly inefficient and not generalized :(
	   * only works for 0000 to 1111 (4 bits)
	   * Doesn't actually use the number of variables
	   * but I figure that'll be important in the general 
	   * solution.
	   * */
	  public Bstring(ArrayList<String> numVar, ArrayList<String> terms){
	    		  
		String bString = "0000";
	    char bArray[] = new char[bString.length()];
	    int temp;
	    char one = '1';
	    binStrings = new ArrayList<String>();
	    
	    bArray[0] = '0';
	    bArray[1] = '0';
	    bArray[2] = '0';
	    bArray[3] = '0';
	    
	    int aSize = terms.size(); //set size here so adding bStrings doesn't change it
	    
	    //cycle through array
	    for(int i = 0; i< aSize; i++){
	      temp = Integer.parseInt(terms.get(i));
	      
	      bArray[0] = '0'; //reset the bArray
	      bArray[1] = '0';
	      bArray[2] = '0';
	      bArray[3] = '0';
	      
	      
	      /** This solution is not very good. I will need 
	        * to write a more general solution. Look up conversion
	        * algorithm
	        * **/
	      for(int j = 0; j<4; j++){
	        
	        if (temp - 8 >= 0){
	          temp -= 8;
	          bArray[0] = one;
	          String s = new String(bArray);
	          bString = s;
	        }
	        if (temp - 4 >= 0 ){
	          temp -= 4;
	          bArray[1] = one;
	          String s = new String(bArray); // 0 is the first indice from L to R :::Remember this!!
	          bString = s;
	          // System.out.println("bString is " + bString);
	        }
	        else if(temp - 2 >= 0){
	          temp -= 2;
	          bArray[2] = one;
	          String s = new String(bArray); // 0 is the first indice from L to R :::Remember this!!
	          bString = s;
	          // System.out.println("bString is " + bString);
	        }
	        else if(temp -1 ==0){
	          temp -= 1;
	          bArray[3] = one;
	          String s = new String(bArray); // 0 is the first indice from L to R :::Remember this!!
	          bString = s;
	          //  System.out.println("bString is " + bString);
	        }
	        else{
	          // catch stuff!
	        }
	        
	      }
	    //  System.out.println("bString is " + bString);
	      binStrings.add(i, bString);
	    }
	  }
	  
	  
	  public ArrayList<String> getBstring(){
		  return binStrings;
	  }
	  
	}

