package ExceptionHandling;

class MarksException extends Exception {
    MarksException(String msg) {
        super(msg);
    }
}

public class Result {
    public static void main(String[] args) {
        int marks = 10;

        try {
            if (marks < 0 || marks > 100) {
                throw new MarksException("Marks must be between 0 and 100");
            } else {
                System.out.println("Valid marks");
            }
        } catch (MarksException e) {
            System.out.println(e.getMessage());
        }
    }
}
