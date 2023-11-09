package org.example.booksInfo;

import org.example.booksOperations.BookAddDeleteEdit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfBooks implements AutoCloseable, Serializable {
    private static List<Book> books;
    public static int count;

    public ListOfBooks() {
        books = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/books.bin"))) {
            Object book;
            while ((book = inputStream.readObject()) != null) {
                books.add((Book) book);
                count++;
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
        BookAddDeleteEdit.addBook(books);
    }

    public void deleteBook() {
        BookAddDeleteEdit.deleteBook(books);
    }

    public void editBook() {
        BookAddDeleteEdit.editBook(books);
    }

}
