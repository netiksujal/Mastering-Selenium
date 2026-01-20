package ExceptionHandling;

public class null_pointer {
	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.hashCode());

		
//		declare
		Object obj2 = null;
		
//		initialize
//		obj2 = new Object();
		
//		utilize
		try {
			System.out.println(obj2.hashCode());
		}catch(NullPointerException e) {
			System.out.println("null pointer handled....");
		}

	}

}
