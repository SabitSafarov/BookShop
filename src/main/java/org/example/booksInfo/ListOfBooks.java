package org.example.booksInfo;

import org.example.booksOperations.BookAddDeleteEdit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ListOfBooks {
    private static List<Book> books;
    public static int count;

    public ListOfBooks() {
        books = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources"))) {
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
