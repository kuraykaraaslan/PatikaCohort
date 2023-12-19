import java.util.Calendar;

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    // Constructor
    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Method to calculate tax
    public double tax() {
        if (salary <= 1000) {
            return 0;
        } else {
            return salary * 0.03;
        }
    }

    // Method to calculate bonus
    public double bonus() {
        if (workHours > 40) {
            int extraHours = workHours - 40;
            return extraHours * 30;
        } else {
            return 0;
        }
    }

    // Method to calculate salary increase
    public double raiseSalary() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearsWorked = currentYear - hireYear;

        if (yearsWorked < 10) {
            return salary * 0.05;
        } else if (yearsWorked < 20) {
            return salary * 0.1;
        } else {
            return salary * 0.15;
        }
    }


    // Method to print employee information
    public String toString() {
        double totalSalary = salary - tax() + bonus() + raiseSalary();
        String result =  "Name: " + name + "\n" +
                "Salary: " + salary + "\n" +
                "Work Hours: " + workHours + "\n" +
                "Hire Year: " + hireYear + "\n" +
                "Tax: " + tax() + "\n" +
                "Bonus: " + bonus() + "\n" +
                "Salary Increase: " + raiseSalary() + "\n" +
                "Salary with Tax and Bonus: " + (totalSalary - salary + tax() - bonus()) + "\n" +
                "Total Salary: " + totalSalary;

        return result;
    }



}
