package employeeCalculator;

public class EmployeeCalculator {

	static int employeeCount = 0;
	
	static double calculateAverageSalary(double[] salaries) {
		double sum = 0;
		
		for (double salary : salaries) {
			sum += salary;
		}
		
		return sum / salaries.length;
	}
	
	static double calculateBonus(double salary) {
		return salary * 0.10;
	}
	
	static double calculateBonus(double salary, double percentage) {
		return salary * (percentage / 100.0);	
	}
	
	public static void main (String[] args) {
		
		double[] salaries = {
				55000,
				62000,
				71000,
				48000,
				85000,
		};
		
		// Increase employeeCount for each employee
        for (int i = 0; i < salaries.length; i++) {
            employeeCount++;
        }

        // Display salaries
        System.out.println("Employee Salaries:");
        for (double salary : salaries) {
            System.out.println(salary);
        }

        System.out.println();

        // Average salary
        double avg = calculateAverageSalary(salaries);
        System.out.println("Average Salary: " + avg);
        System.out.println();

        // Bonus examples
        double tenPercentBonus = calculateBonus(salaries[0]); // 10% bonus
        System.out.println("10% Bonus: " + tenPercentBonus);
        System.out.println();

        double fifteenPercentBonus = calculateBonus(salaries[1], 15); // 15% bonus
        System.out.println("15% Bonus: " + fifteenPercentBonus);
        System.out.println();

        // Total employees
        System.out.println("Total Employees: " + employeeCount);
	}
}
