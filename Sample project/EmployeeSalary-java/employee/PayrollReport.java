package employee;
import java.util.List;

public class PayrollReport {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeReader.readEmployees();
        PayrollReportGenerator.generatePayrollReport(employees);
    }
}
