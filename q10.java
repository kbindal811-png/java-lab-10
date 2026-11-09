import java.util.*;

public class q10 {
    static class Department {
        protected int deptId;
        protected String deptName;

        public Department(int deptId, String deptName) {
            this.deptId = deptId;
            this.deptName = deptName;
        }

        public int getDeptId() { return deptId; }
        public String getDeptName() { return deptName; }

        // Departments are equal if they have the same id (needed for use as HashMap keys)
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Department)) return false;
            return deptId == ((Department) o).deptId;
        }

        @Override
        public int hashCode() { return Objects.hash(deptId); }

        @Override
        public String toString() { return deptName; }
    }

    static class Teacher extends Department {
        private final int teacherId;
        private final String teacherName;

        public Teacher(int teacherId, String teacherName, Department dept) {
            super(dept.getDeptId(), dept.getDeptName());
            this.teacherId = teacherId;
            this.teacherName = teacherName;
        }

        @Override
        public String toString() {
            return "Teacher[" + teacherId + ", " + teacherName + "]";
        }
    }

    static class University {
        private final ArrayList<Department> departments = new ArrayList<>();
        private final HashMap<Department, List<Teacher>> teachersByDept = new HashMap<>();

        public void addDepartment(Department d) {
            departments.add(d);
            teachersByDept.put(d, new ArrayList<>());
        }

        public void addTeacher(int deptId, int teacherId, String teacherName) {
            for (Department d : departments) {
                if (d.getDeptId() == deptId) {
                    teachersByDept.get(d).add(new Teacher(teacherId, teacherName, d));
                    return;
                }
            }
            System.out.println("Department " + deptId + " does not exist.");
        }

        public void displayAll() {
            for (Department d : departments) {
                System.out.println("Department: " + d.getDeptName());
                List<Teacher> list = teachersByDept.get(d);
                if (list.isEmpty()) System.out.println("   (no teachers)");
                for (Teacher t : list) System.out.println("   " + t);
            }
        }
    }

    public static void main(String[] args) {
        University uni = new University();
        uni.addDepartment(new Department(1, "Computer Applications"));
        uni.addDepartment(new Department(2, "Mathematics"));
        uni.addDepartment(new Department(3, "Physics"));

        uni.addTeacher(1, 201, "Dr. Mehta");
        uni.addTeacher(1, 202, "Prof. Singh");
        uni.addTeacher(2, 203, "Dr. Verma");
        uni.addTeacher(9, 204, "Ghost Teacher");   // invalid department

        uni.displayAll();
    }
}
