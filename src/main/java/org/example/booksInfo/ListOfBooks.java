package org.example.booksInfo;

import org.example.booksOperations.BookAdd;
import org.example.booksOperations.BookDelete;
import org.example.booksOperations.BookEdit;
import org.example.booksOperations.BookSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfBooks implements AutoCloseable, Serializable {
    private static List<Book> books;
    private static Map<String, Integer> bookStoreWindow;
    public static int count;

    public ListOfBooks() {
        books = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/books.bin"))) {

            Object book;
            while ((book = inputStream.readObject()) != null) {
                books.add((Book) book);
                count++;
            }

            bookStoreWindow = new HashMap<>();
            for (Book book1 : books) {
                bookStoreWindow.put(book1.getName(), book1.getInStock());
            }

        } catch (IOException e) {
            System.out.println("File not found. Created new.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        String booksData = "src/main/resources/books.bin";
        String bookTxtData = "src/main/resources/books.txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(booksData));
             FileWriter writer = new FileWriter(bookTxtData)) {

            for (Book book : books) {
                out.writeObject(book);
                writer.write(book.toString() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook() {
        BookAdd.addBook(books, bookStoreWindow);
    }

    public void deleteBook() {
        BookDelete.deleteBook(books, bookStoreWindow);
    }

    public void editBook() {
        BookEdit.editBook(books, bookStoreWindow);
    }

    public void searchBook() {
        BookSearch.searchBook(books);
    }

}
