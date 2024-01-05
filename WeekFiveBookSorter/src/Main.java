import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Set of books sorted by title
        Set<Book> bookSetByName = new TreeSet<>();
        bookSetByName.add(new Book("Java Programming", 300));
        bookSetByName.add(new Book("Python Basics", 250));
        bookSetByName.add(new Book("Data Structures", 400));
        bookSetByName.add(new Book("Algorithm Design", 350));
        bookSetByName.add(new Book("Web Development", 200));

        System.out.println("Books sorted by title:");
        for (Book book : bookSetByName) {
            System.out.println(book);
        }

        // Set of books sorted by page count
        Set<Book> bookSetByPageCount = new TreeSet<>(Comparator.comparingInt(Book::getPageCount));
        bookSetByPageCount.addAll(bookSetByName);

        System.out.println("\nBooks sorted by page count:");
        for (Book book : bookSetByPageCount) {
            System.out.println(book);
        }
    }
}


