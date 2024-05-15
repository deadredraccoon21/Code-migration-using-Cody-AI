package employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PayrollReportGenerator {
    private static final String OUTPUT_FILE = "Sample project/EmployeeSalary-java/employee/Output.txt";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("#,##0.00");

    public static void generatePayrollReport(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            LocalDate currentDate = LocalDate.now();
            String header = String.format("%25s%25s", "PAYROLL REPORT", currentDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            writer.write(header);
            writer.newLine();
            writer.newLine();

            writer.write(String.format("%-8s %-20s %-10s %-10s %-10s %-10s %-10s %-10s", "EMP NO.", "NAME", "OLD SAL", "NEW SAL", "OLD DUES", "NEW DUES", "OLD INS", "NEW INS"));
            writer.newLine();
            writer.write(String.format("%-8s %-20s %-10s %-10s %-10s %-10s %-10s %-10s", "-------", "--------------------", "--------", "--------", "--------", "--------", "--------", "--------"));
            writer.newLine();

            for (Employee employee : employees) {
                writer.write(String.format("%-8d %-20s %10s %10s %10s %10s %10s %10s", employee.getEmpNumber(), employee.getName(),
                        MONEY_FORMAT.format(employee.getAnnualSalary()), MONEY_FORMAT.format(employee.getNewSalary()),
                        MONEY_FORMAT.format(employee.getDues()), MONEY_FORMAT.format(employee.getNewDues()),
                        MONEY_FORMAT.format(employee.getInsurance()), MONEY_FORMAT.format(employee.getNewInsurance())));
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


