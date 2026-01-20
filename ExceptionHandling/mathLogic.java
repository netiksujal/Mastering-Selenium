package ExceptionHandling;

public class mathLogic {
	public static void main(String[] args) {
		int a = 1;
		int b = 0;

		int [] arr = {0,1,2,3};
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);

		try { // critical code
			System.out.println(arr[3]);
			int c = a/b;
			System.out.println(c);
			System.out.println("hey there....");
		}catch(ArithmeticException e) {
			System.out.println("it is handling arithmetic");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("it is handling array index out of bound");
		}

		System.out.println("hiiiii.....");
	}
}
