package ExceptionHandling;

public class Marriagemain{
	public static void main(String[] args) {
		String boy = "amit";
		String girl = "jaya";

		String boyGotra = "Bharadwaj";
		String girlGotra = "sandyle";

		int boyAge = 40;
		int girlAge = 35;

		if (boyAge < girlAge) {
			System.out.println("Chotu you cant marry didi...");
		} else if (boyGotra.equals(girlGotra)) {
			System.out.println("Didi se hi shadi krega ????");
		} else {
			System.out.println(boy + " and " + girl + " congrats....");
		}
	}
}
