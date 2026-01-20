package ExceptionHandling;

import java.util.Scanner;

public class TryToVote {

    public static void main(String[] args) throws VoteException  {

        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age < 18) {
        	throw new VoteException ("You are not eligible to vote...");
        } else {
            System.out.println("You are eligible to vote...");
        }
    }
}