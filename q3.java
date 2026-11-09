import java.util.HashSet;
import java.util.Objects;

public class q3 {
    static class Book {
        private final int id;
        private final String title;
        private final String author;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public int getId() { return id; }

        public void display() {
            System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
        }

        // Two books with the same ID are treated as duplicates
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book)) return false;
            return id == ((Book) o).id;
        }

        @Override
        public int hashCode() { return Objects.hash(id); }
    }

    static class Library {
        private final HashSet<Book> books = new HashSet<>();

        public void addBook(Book b) {
            if (books.add(b)) {
                System.out.println("Added book with ID " + b.getId());
            } else {
                System.out.println("Duplicate! Book with ID " + b.getId() + " not added.");
            }
        }

        public void displayAll() {
            System.out.println("--- Books in Library (" + books.size() + ") ---");
            for (Book b : books) b.display();
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "Java: The Complete Reference", "Herbert Schildt"));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(1, "Head First Java", "Kathy Sierra"));   // same ID -> duplicate
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));
        library.displayAll();
    }
}
