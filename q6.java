import java.util.ArrayList;

public class q6 {
    static abstract class Shape {
        protected String name;

        public Shape(String name) { this.name = name; }

        public abstract double area();

        public void displayArea() {
            System.out.printf("%s area = %.2f%n", name, area());
        }
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            super("Circle (r=" + radius + ")");
            this.radius = radius;
        }

        @Override
        public double area() { return Math.PI * radius * radius; }
    }

    static class ShapeManager {
        private final ArrayList<Shape> shapes = new ArrayList<>();

        public void addShape(Shape s) { shapes.add(s); }

        public void displayAllAreas() {
            for (Shape s : shapes) s.displayArea();
        }
    }

    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        manager.addShape(new Circle(2));
        manager.addShape(new Circle(3.5));
        manager.addShape(new Circle(10));
        manager.displayAllAreas();
    }
}
