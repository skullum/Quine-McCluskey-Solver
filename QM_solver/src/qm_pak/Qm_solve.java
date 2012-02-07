package qm_pak;

/**
 * Quine-McCluskey Solver
 * 11/14/11 
 * **/

import java.io.*;
import java.util.ArrayList;
// import java.lang.Integer;

public class Qm_solve {
  
  public static InputStreamReader in = new InputStreamReader(System.in);
  public static BufferedReader bRead = new BufferedReader(in);
  
  
  public static void main(String[] args) throws IOException{
    
    ArrayList<String> minValues = new ArrayList<String>();
    ArrayList<String> dontValues = new ArrayList<String>();
    ArrayList<String> numOfVars = new ArrayList<String>();
    
    System.out.println("Please input the number of variables (hit q when done): ");
    
    getInput(numOfVars);
    
    System.out.println("You have " + numOfVars.get(0) + " variables");
    System.out.println("Now please enter the minValues (hit q when done): ");    
    
    getInput(minValues);
    
    System.out.println("You have " + minValues.size() + " min values");
    
  /**
   * Add functionality for don't care terms later
   * 
    System.out.println("Now please enter the don't care values (hit q when done): ");
    
    getInput(dontValues);
    
    System.out.println("You have " + dontValues.size() + " don't care terms\n");
    **/
    
    in.close();
    bRead.close();
    
    findQ(numOfVars, minValues, dontValues);
    
    
  }
  
  /**
   * Reads in input from keyboard.
   * **/
  public static void getInput(ArrayList<String> al) throws IOException{
    while(true){
      al.add(bRead.readLine());
      if(al.contains("q")){
        al.remove("q");
        return;
      }
    }  
    
  }
  /** 
    * This method takes the input and does Q-M reduction 
    * */
  public static void findQ(ArrayList<String> numOfVar, ArrayList<String> minV, ArrayList<String> dTerm){
    
	  ArrayList<String> answer = new ArrayList<String>();
	  ArrayList<String> oldPass = new ArrayList<String>();
	  
	  answer.add("Hello Worlds"); //so answer has at least one thing
	  
    //Convert into binary Strings
    Bstring minTerms = new Bstring(numOfVar, minV);
    Bstring dCareTerms = new Bstring(numOfVar, dTerm);
    

    //Get Binary Strings
    minV = minTerms.getBstring();
    dTerm = dCareTerms.getBstring();
    
    //take bStrings and compute first pass
    // take first string and compare it bit by bit to second string
    // repeat for all strings.
    // if two string differ by only one bit then, change that bit to a _
    // and place it in the Arraylist firstP
    
 //   boolean isSame;
   
    /*
    do{
    isSame = true;
    oldPass = answer;
    answer = q_pass(minV);
    	for(int i=0; i< answer.size(); i++){
    	   	if(answer.get(i) != oldPass.get(i)){
    	   		isSame = false;
    	   		break;
    	   	}
    	   }
    System.out.println("was here +1");
    }while(!(isSame));
    
    */
    
    answer = q_pass(minV);
    
    for(int i=0; i< answer.size(); i++){
	   	System.out.println(answer.get(i));
	   }
   
  }
  
  public static ArrayList<String> q_pass(ArrayList<String> minV){
	  
	  ArrayList<String> afterPass = new ArrayList<String>();
	    int numberOfDiffer;
	    int placeOfDiffer;
	    String temp; // hold temp string that will be placed in firstP
	    char cTemp[]; // left side wasn't a variable somewhere hope this fixes it
	    
	    for(int i = 0; i < minV.size(); i++){      
	        for(int j = i+1; j < minV.size(); j++){
	          
	          numberOfDiffer = 0; // how many bits are different
	          placeOfDiffer = 0; // what index they differ at (make _ )
	          
	          //cycle through each bit in strings
	          for(int k = 0; k < minV.get(i).length(); k++){
	            if(minV.get(i).charAt(k) != minV.get(j).charAt(k)){
	              numberOfDiffer++;
	              placeOfDiffer = k;
	              
	              if(numberOfDiffer > 1){
	              	break;
	              }
	              
	              //    System.out.println("number of Differ is: " + numberOfDiffer);
	              //    System.out.println("place of Differ is: " + placeOfDiffer);
	            }
	          }
	          
	          temp = minV.get(i); //do i need?
	          cTemp = new char[temp.length()];
	          
	          cTemp = minV.get(i).toCharArray(); //convert string to char array
	          
	          //replace single place of differ with a '_'
	          if(numberOfDiffer == 1){
	            cTemp[placeOfDiffer] = '_';
	            temp = new String(cTemp);
	            if(!(afterPass.contains(temp))){
	              afterPass.add(temp);
	            }
	          }
	        }
	      }
	    return afterPass;
  }
}