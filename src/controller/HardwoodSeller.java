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
	public static void main(String[] args) throws FileNotFoundException{
		readInputFile(args[0]);
		// TODO Auto-generated method stub

	}
	
	public static void readInputFile(String inputFilePath) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(inputFilePath));

		scanner.useDelimiter(";");
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}
		
	}
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
}
