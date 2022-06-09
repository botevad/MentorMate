public class Employee {
    private final double id;
    private final String firstName;
    private final String lastName;
    private double salaryPerMonth;

    private double raise;

    public Employee(double id, String firstName, String lastName, double salaryPerMonth, double raise) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryPerMonth = salaryPerMonth;
        this.raise = raise;
    }

/*    public final void setId(double id) {
        this.id = id;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }*/

    public void setSalaryPerMonth(double salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public double getAnnualSalary() {
        return salaryPerMonth * 12;
    }

    public double raiseSalary() {
        return salaryPerMonth + (salaryPerMonth * raise / 100);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salaryPerMonth=" + salaryPerMonth +
                ", raise=" + raise +
                '}';
    }

    /*    public String getLastName() {
        return lastName;
    }*/

    public static void main(String[] args) {
        Employee e = new Employee(2, "Dani", "Boteva", 2000, 15);
        //e.setFirstName("Nikol");
        System.out.println(e);
        System.out.println(e.getName() + " " + e.getAnnualSalary() + " " + e.raiseSalary());
    }
}
