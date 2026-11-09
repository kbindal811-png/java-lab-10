import java.util.LinkedList;

public class q2 {
    static class Person {
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }

        public void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    static class Employee extends Person {
        private final int empId;
        private final double salary;

        public Employee(String name, int age, int empId, double salary) {
            super(name, age);
            this.empId = empId;
            this.salary = salary;
        }

        @Override
        public void display() {
            System.out.println("EmpID: " + empId + ", Name: " + name + ", Age: " + age + ", Salary: " + salary);
        }
    }

    static class EmployeeManager {
        private final LinkedList<Employee> employees = new LinkedList<>();

        public void addEmployee(Employee e) { employees.add(e); }

        public void displayAll() {
            System.out.println("--- Employee Records ---");
            for (Employee e : employees) e.display();
        }

        public void searchByName(String name) {
            boolean found = false;
            for (Employee e : employees) {
                if (e.getName().equalsIgnoreCase(name)) {
                    System.out.print("Found -> ");
                    e.display();
                    found = true;
                }
            }
            if (!found) System.out.println("No employee named " + name);
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee("Anil", 30, 101, 45000));
        manager.addEmployee(new Employee("Bhavna", 27, 102, 52000));
        manager.addEmployee(new Employee("Chirag", 35, 103, 61000));
        manager.displayAll();

        manager.searchByName("Bhavna");
        manager.searchByName("Zoya");
    }
}
