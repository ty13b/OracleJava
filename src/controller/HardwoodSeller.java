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
	String name;
	String address;
	String date;
	int woodCount;
	WoodItem[] wood = new WoodItem[6];
	int[] woodAmount = new int[6];


	private HardwoodSeller(String s) throws FileNotFoundException{
		woodCount=0;
		readInputFile(s);
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Date: " + date);
		for(int x=0 ; x<woodCount; x++)
			System.out.println(wood[x].toString() + " " + woodAmount[x]);
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		HardwoodSeller h = new HardwoodSeller(args[0]);
		// TODO Auto-generated method stub

	}
	
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
			if(x > 2){	
				//System.out.println(scanner.next());
				addWood(scanner.next());
			}
			x++;
		}
		
	}

	public void addWood(String s){
		int pos = s.indexOf(':');
		String word = s.substring(0,pos);
		String temp = (s.substring(pos+1));
		//System.out.println(word+" "+num);
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
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
}
