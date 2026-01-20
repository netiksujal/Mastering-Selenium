package ExceptionHandling;

import java.util.HashSet;
import java.util.Set;

public class set_explaination {
public static void main(String[]args) {
	
	Set<Object>favthings = new HashSet<>();
	
	favthings.add("bike");
	favthings.add("mobile");
	favthings.add("bat");
	favthings.add("watch");
	favthings.add("laptop");
//	favthings.add("mobile");
	
	System.out.println(favthings.size());
	
	System.out.println(favthings);
}
}
