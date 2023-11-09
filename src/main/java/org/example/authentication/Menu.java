package org.example.authentication;

import org.example.booksInfo.ListOfBooks;

import java.util.Scanner;

public class Menu {

    public static void start() {
        boolean run = true;
        Scanner scr = new Scanner(System.in);
        ListOfBooks listOfBooks = new ListOfBooks();

        while (run) {
            System.out.println("\t===== Добро пожаловать в магазин книг! =====\n");
            System.out.println("\t\t[1] - Добавить книгу\n\t\t[2] - Удалить книгу\n\t\t[3] - Редактировать книгу\n\t\t" +
                                "[4] - Продать книгу\n\t\t[5] - Списать книгу\n\t\t[6] - Внести книгу в акцию\n\t\t" +
                                "[7] - Отложить книгу для покупателя\n\t\t[8] - Поиск книги\n\t\t[9] - Просмотреть список новинок\n\t\t" +
                                "[10] - Просмотреть список самых продаваемых книг\n\t\t[11] - Просмотреть список популярных авторов\n\t\t" +
                                "[12] - Просмотреть список популярных жанров\n\t\t[0] - Сохранить и выйти\n");

            System.out.print("\tВыберите команду: ");
            String input = scr.nextLine();
            System.out.println();

            switch (input) {
                case "1" -> listOfBooks.addBook();
                case "2" -> listOfBooks.deleteBook();
                case "3" -> listOfBooks.editBook();
                case "0" -> {
                    try {
                        listOfBooks.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    run = false;
                }
            }
        }
    }
}
