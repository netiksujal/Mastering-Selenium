package ExceptionHandling;

import java.util.ArrayList;
import java.util.List;

public class Arrraylist {
	public static void main (String []args) {
		
		List<Object> Students= new ArrayList<>();
		
		Students.add("shivam");
		Students.add("shubham");
		Students.add("Rajendra");
		Students.add("ashu");
		Students.add("ravi");
		
		System.out.println(Students.size());
		System.out.println(Students.get(2));
		System.out.println(Students.remove(3));
		System.out.println(Students.get(3));
	}
}
