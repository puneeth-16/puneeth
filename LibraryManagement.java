import java.util.ArrayList;
import java.util.Scanner;
class Book {
    int id;
    String title;
    boolean isIssued;
    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Issued: " + isIssued;
    }
}
class User {
    int userId;
    String name;
    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}
class Library {
    ArrayList<Book> books = new ArrayList<>();
    void addBook(Book book) {
        books.add(book);
    }
    void issueBook(int bookId) {
        for (Book book : books) {
            if (book.id == bookId) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued: " + book.title);
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    void returnBook(int bookId) {
        for (Book book : books) {
            if (book.id == bookId) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned: " + book.title);
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        library.addBook(new Book(1, "Java Basics"));
        library.addBook(new Book(2, "Python Essentials"));
        library.addBook(new Book(3, "Data Structures"));
        while (true) {
            System.out.println("\n1. Display Books\n2. Issue Book\n3. Return Book\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
