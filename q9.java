import java.util.LinkedList;
import java.util.Queue;

public class q9 {
    static class Patient {
        private final int id;
        private final String name;

        public Patient(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }

        @Override
        public String toString() { return "Patient[" + id + ", " + name + "]"; }
    }

    static class Clinic {
        private final Queue<Patient> queue = new LinkedList<>();

        public void addPatient(Patient p) {
            queue.offer(p);
            System.out.println("Registered: " + p);
        }

        public void servePatient() {
            Patient p = queue.poll();   // FIFO: first registered is served first
            System.out.println(p != null ? "Serving: " + p : "No patients waiting.");
        }

        public void displayWaiting() {
            System.out.println("Waiting: " + queue);
        }
    }

    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        clinic.addPatient(new Patient(1, "Ishaan"));
        clinic.addPatient(new Patient(2, "Kavya"));
        clinic.addPatient(new Patient(3, "Lakshay"));
        clinic.displayWaiting();

        clinic.servePatient();
        clinic.servePatient();
        clinic.displayWaiting();
    }
}
