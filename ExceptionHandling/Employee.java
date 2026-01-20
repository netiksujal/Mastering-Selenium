package ExceptionHandling;

class SalaryException extends Exception {
    SalaryException(String msg) {
        super(msg);
    }
}

public class Employee {
    public static void main(String[] args) {
        int salary = 8000;

        try {
            if (salary < 10000) {
                throw new SalaryException("Salary is below minimum limit");
            } else {
                System.out.println("Salary accepted");
            }
        } catch (SalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}

