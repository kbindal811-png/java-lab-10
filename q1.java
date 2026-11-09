import java.util.ArrayList;

public class q1 {
    static class Student {
        private final String name;

        public Student(String name) { this.name = name; }

        public String getName() { return name; }

        public void display() {
            System.out.println("Student Name: " + name);
        }
    }

    static class StudentManager {
        private final ArrayList<Student> students = new ArrayList<>();

        public void addStudent(Student s) {
            students.add(s);
            System.out.println("Added: " + s.getName());
        }

        public void removeStudent(String name) {
            boolean removed = students.removeIf(s -> s.getName().equalsIgnoreCase(name));
            System.out.println(removed ? "Removed: " + name : "Not found: " + name);
        }

        public void displayAll() {
            System.out.println("--- Student List ---");
            for (int i = 0; i < students.size(); i++) {
                students.get(i).display();
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("Aarav"));
        manager.addStudent(new Student("Diya"));
        manager.addStudent(new Student("Rohan"));
        manager.addStudent(new Student("Sana"));
        manager.displayAll();

        manager.removeStudent("Diya");
        manager.displayAll();
    }
}
