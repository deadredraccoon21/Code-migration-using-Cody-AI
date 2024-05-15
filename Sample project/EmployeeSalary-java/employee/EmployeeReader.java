package employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReader {
    private static final String INPUT_FILE = "Sample project/EmployeeSalary-java/employee/InputEmployees.txt";

    public static List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int empNumber = Integer.parseInt(parts[0]);
                String name = parts[1];
                double annualSalary = Double.parseDouble(parts[2]);
                double dues = Double.parseDouble(parts[3]);
                double insurance = Double.parseDouble(parts[4]);
                employees.add(new Employee(empNumber, name, annualSalary, dues, insurance));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
