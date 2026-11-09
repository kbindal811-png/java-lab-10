import java.util.HashMap;
import java.util.Map;

public class q5 {
    static class Student {
        private final int rollNo;
        private final String name;

        public Student(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
        }

        public int getRollNo() { return rollNo; }
        public String getName() { return name; }

        public void display() {
            System.out.println("Roll No: " + rollNo + ", Name: " + name);
        }
    }

    static class StudentRegistry {
        // key = roll number, value = name
        private final HashMap<Integer, String> students = new HashMap<>();

        public void addStudent(Student s) {
            students.put(s.getRollNo(), s.getName());
            System.out.println("Added: " + s.getRollNo());
        }

        public void removeStudent(int rollNo) {
            String removed = students.remove(rollNo);
            System.out.println(removed != null ? "Removed roll no " + rollNo + " (" + removed + ")"
                                               : "Roll no " + rollNo + " not found");
        }

        public void displayAll() {
            System.out.println("--- Registered Students ---");
            for (Map.Entry<Integer, String> e : students.entrySet()) {
                new Student(e.getKey(), e.getValue()).display();
            }
        }
    }

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        registry.addStudent(new Student(101, "Aditi"));
        registry.addStudent(new Student(102, "Bharat"));
        registry.addStudent(new Student(103, "Charu"));
        registry.displayAll();

        registry.removeStudent(102);
        registry.removeStudent(999);
        registry.displayAll();
    }
}
