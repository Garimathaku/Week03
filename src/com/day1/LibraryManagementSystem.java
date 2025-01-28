package com.day1;

class Book {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;

    // Add a new book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a new book at the end
    public void addAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a new book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookID, boolean isAvailable) {
        if (position == 1) {
            addAtBeginning(title, author, genre, bookID, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookID, isAvailable);
        Book temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newBook.next = temp.next;
        newBook.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newBook;
        } else {
            tail = newBook;
        }

        temp.next = newBook;
    }

    // Remove a book by Book ID
    public void removeByBookID(int bookID) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookID != bookID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book with ID " + bookID + " not found.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        System.out.println("Book removed.");
    }

    // Search for a book by Title or Author
    public void searchBook(String title, String author) {
        Book temp = head;
        while (temp != null) {
            if ((title != null && temp.title.equalsIgnoreCase(title)) ||
                    (author != null && temp.author.equalsIgnoreCase(author))) {
                System.out.println("Book Found: Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Update a book's Availability Status
    public void updateAvailability(int bookID, boolean isAvailable) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID: " + bookID);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", ID: " + temp.bookID + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Add books to the library
        library.addAtEnd("Book1", "Alice", "Genre1", 11, true);
        library.addAtEnd("Book2", "Bob", "Genre2", 12, false);
        library.addAtBeginning("Book3", "John", "Genre3", 13, true);
        library.addAtPosition(2, "Book4", "Alice4", "Genre4", 14, true);

        // Display books
        System.out.println("\nBooks in forward order:");
        library.displayForward();

        System.out.println("\nBooks in reverse order:");
        library.displayReverse();

        // Search for a book
        System.out.println("\nSearching for Book by Title 'Book4':");
        library.searchBook("Book4", null);

        System.out.println("\nSearching for Book by Author 'Author1':");
        library.searchBook(null, "Author1");

        // Update availability
        System.out.println("\nUpdating availability for Book ID 102:");
        library.updateAvailability(12, true);
        library.displayForward();

        // Count total books
        System.out.println("\nCounting total books:");
        library.countBooks();

        // Remove a book
        System.out.println("\nRemoving Book ID 104:");
        library.removeByBookID(104);
        library.displayForward();
    }
}
