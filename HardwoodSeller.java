/**
 * 
 */
//package controller;
import java.util.Scanner;
import java.io.*;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
	String name; //Name on the order
	String address; //Address from text file
	String date;//Date from text file
	int woodCount;//Amount of wood orders
	WoodItem[] wood = new WoodItem[6];//holds wood orders
	int[] woodAmount = new int[6];//holds amount of wood in parallel with wood array

	//Constuctor for PRIVATE constructor
	private HardwoodSeller(String s) throws FileNotFoundException{
		woodCount=0;
		readInputFile(s);
		printOrder();
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		HardwoodSeller h = new HardwoodSeller(args[0]);
	}
	
	//Function to read the input from the text file
	public void readInputFile(String inputFilePath) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(inputFilePath));

		scanner.useDelimiter(";|\\n");
		int x = 0;
		while(scanner.hasNext()){
			if(x==0)
				name = scanner.next();
			if(x==1)
				address = scanner.next();
			if(x==2)
				date = scanner.next();
			if(x > 2)
				addWood(scanner.next());
			x++;
		}
		
	}

	//This function takes a string with a wood name and an amount and puts it in their respective arrays
	public void addWood(String s){
		int pos = s.indexOf(':');
		String word = s.substring(0,pos);
		String temp = (s.substring(pos+1));
		int num = Integer.parseInt(temp);
		switch(word.toLowerCase()){
			case "cherry": wood[woodCount] = new WoodItem("Cherry", 2.5, 5.95); break;
			case "curly maple": wood[woodCount] = new WoodItem("Curly Maple", 1.5, 6.00); break;
			case "genuine mahogany": wood[woodCount] = new WoodItem("Genuine Mahogany", 3.0, 9.60); break;
			case "wenge": wood[woodCount] = new WoodItem("Wenge", 5.0, 22.35); break;
			case "white oak": wood[woodCount] = new WoodItem("White Oak", 2.3, 6.70); break;
			case "sawdust": wood[woodCount] = new WoodItem("Sawdust", 1.0, 1.5); break;
		}
		woodAmount[woodCount] = num;
		woodCount++;
	}
	
	//Calculates the max delivery time of all items and returns it as a double
	public double deliveryTime(){
		double deliveryETA = 0.0;
		double woodScale = 0.0;
		for(int i = 0; i < woodCount; i++){
			if(woodAmount[i]>500)
				woodScale = 5.5;
			if(woodAmount[i] >= 1 && woodAmount[i] <= 100)
				woodScale = 1.0;
			if(woodAmount[i] >= 101 && woodAmount[i] <= 200)
				woodScale = 2.0;
			if(woodAmount[i] >= 201 && woodAmount[i] <= 300)
				woodScale = 3.0;
			if(woodAmount[i] >= 301 && woodAmount[i] <= 400)
				woodScale = 4.0;
			if(woodAmount[i] >= 401 && woodAmount[i] <= 500)
				woodScale = 5.0;
			if(woodScale*wood[i].getBaseDeliveryTime() > deliveryETA)
				deliveryETA = woodScale*wood[i].getBaseDeliveryTime();
			woodScale=0.0;
		}
		return deliveryETA;
	}

	//Prints the entire order form with all of the information
	public void printOrder(){
		System.out.println("\nName: " + name);
		System.out.println("Address: " + address);
		System.out.println("Date: " + date);
		System.out.println("-----------------------------------------------");
		double total = 0.0;
		for(int x=0 ; x<woodCount; x++){
			String name = wood[x].toString();
			int amt = woodAmount[x];
			double price = wood[x].getPrice();
			double tempTotal = (double)amt * price;
			total += tempTotal;
			System.out.println(name + ": " + amt + " units @ "+ price + " = $"+ tempTotal);
		}
		System.out.println("-----------------------------------------------");
		System.out.println("Estimated Delivery: " + deliveryTime() + " hours");
		System.out.println("Total Price: $" + total);
	}
}
