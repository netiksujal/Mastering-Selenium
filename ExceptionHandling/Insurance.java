package ExceptionHandling;

import java.util.Scanner;

public class Insurance {
	 public static void main(String[] args) throws InsuranceException  {
		 Scanner sc = new Scanner(System.in);
	        int age = sc.nextInt();

	        if (age < 18) {
	        	throw new InsuranceException ("You are not eligible to vote...");
	        } else {
	            System.out.println("You are eligible to vote...");
	        }
	    }

	 }


