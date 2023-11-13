package org.example.booksOperations;

import org.example.booksInfo.Book;
import org.example.booksInfo.ListOfBooks;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookAdd {

    public static void addBook(List<Book> books, Map<String, Integer> bookStoreWindow) {
        System.out.println("===== Добавление новой книги =====\n");

        int id = ++ListOfBooks.count;

        Scanner scr = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        String name = scr.nextLine();

        System.out.print("Введите ФИО автора (пример ввода: Иванов Иван Иванович): ");
        String author;
        while (true) {
            author = scr.nextLine();
            Pattern namePattern = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+ [а-яА-ЯёЁa-zA-Z]+ ?[а-яА-ЯёЁa-zA-Z]+$");
            Matcher nameMatcher = namePattern.matcher(author);
            if (!nameMatcher.matches()) {
                System.out.print("Неверный формат ФИО! Введите снова (пример ввода: Иванов Иван Иванович): ");
            } else {
                break;
            }
        }

        System.out.print("Введите название издательства: ");
        String publisher = scr.nextLine();

        System.out.print("Введите количество страниц: ");
        int pageCount = Integer.parseInt(scr.nextLine());

        String genre = "";
        while (genre.isEmpty()) {
            System.out.println("Выберите жанр книги: \n" +
                    "[1] - Роман\n[2] - Повесть\n[3] - Рассказ\n" +
                    "[4] - Сказки\n[5] - Лирика\n[6] - Трагедия\n" +
                    "[7] - Комедия\n[8] - Драма\n[9] - Поэма\n");
            int input = Integer.parseInt(scr.nextLine());
            switch (input) {
                case 1 -> genre = "Роман";
                case 2 -> genre = "Повесть";
                case 3 -> genre = "Рассказ";
                case 4 -> genre = "Сказки";
                case 5 -> genre = "Лирика";
                case 6 -> genre = "Трагедия";
                case 7 -> genre = "Комедия";
                case 8 -> genre = "Драма";
                case 9 -> genre = "Поэма";
                default -> System.out.println("Неверная команда!");
            }
        }

        System.out.print("Введите год издания: ");
        int publishingDate = Integer.parseInt(scr.nextLine());

        System.out.print("Введите себестоимость книги: ");
        double costPrice = Double.parseDouble(scr.nextLine());

        System.out.print("Введите цену для продажи: ");
        double salePrice = Double.parseDouble(scr.nextLine());

        System.out.print("Введите количество книг в наличии: ");
        int inStock = Integer.parseInt(scr.nextLine());

        boolean isSequel = false;
        boolean run = true;
        while (run) {
            System.out.println("Является ли книга продолжением?\n[1] - да\n[2] - нет");
            int input = Integer.parseInt(scr.nextLine());
            switch (input) {
                case 1 -> {
                    isSequel = true;
                    run = false;
                }
                case 2 -> {
                    run = false;
                }
                default -> System.out.println("Неверная команда!");
            }
        }

        books.add(new Book(id, name, author, publisher, pageCount, genre, publishingDate, costPrice, salePrice, inStock, isSequel));
        bookStoreWindow.put(name, inStock);
        System.out.println("\nКнига успешно добавлена!\n");
    }
}