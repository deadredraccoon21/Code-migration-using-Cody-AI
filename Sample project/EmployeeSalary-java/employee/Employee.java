package employee;
public class Employee {
    private int empNumber;
    private String name;
    private double annualSalary;
    private double dues;
    private double insurance;

    public Employee(int empNumber, String name, double annualSalary, double dues, double insurance) {
        this.empNumber = empNumber;
        this.name = name;
        this.annualSalary = annualSalary;
        this.dues = dues;
        this.insurance = insurance;
    }

    // Getters and metho 
    public int getEmpNumber() {
        return empNumber;
      }
  
      public void setEmpNumber(int empNumber) {
          this.empNumber = empNumber;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public double getAnnualSalary() {
          return annualSalary;
      }
  
      public void setAnnualSalary(double annualSalary) {
          this.annualSalary = annualSalary;
      }
  
      public double getDues() {
          return dues;
      }
  
      public void setDues(double dues) {
          this.dues = dues;
      }
  
      public double getInsurance() {
          return insurance;
      }
  
      public void setInsurance(double insurance) {
          this.insurance = insurance;
      }
  
      public double getNewSalary() {
          return annualSalary * 1.07;
      }
  
      public double getNewDues() {
          return dues * 1.04;
      }

    public double getNewInsurance() {
      return insurance * 1.03;
  }
}
