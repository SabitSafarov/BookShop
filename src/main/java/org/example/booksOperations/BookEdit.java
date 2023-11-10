package org.example.booksOperations;

import org.apache.commons.text.WordUtils;
import org.example.booksInfo.Book;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookEdit {

    public static void editBook(List<Book> books) {
        System.out.println("===== Редактирование книги =====\n");

        Scanner scr = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Выберите параметр поиска для редактирования книги: \n[1] - По названию книги\n[2] - По ФИО автора\n[3] - Выход");

            int input = Integer.parseInt(scr.nextLine());
            boolean run1 = true;
            switch (input) {
                case 1 -> {
                    while (run1) {
                        System.out.print("Введите название книги: ");
                        String name = scr.nextLine();
                        boolean exists = false;

                        for (Book book : books) {
                            if (book.getName().equalsIgnoreCase(name)) {
                                System.out.println(book.getId() + ". " + book.getName() + " - " + book.getAuthor());
                                exists = true;
                            }
                        }
                        if (!exists) {
                            boolean run2 = true;
                            while (run2) {
                                System.out.println("\nКнига с данным названием не найдена!\n[1] - Продолжить поиск\n[2] - Выйти из параметра редактирования");
                                int inp = Integer.parseInt(scr.nextLine());
                                switch (inp) {
                                    case 1 -> {
                                        System.out.println();
                                        run2 = false;
                                    }
                                    case 2 -> {
                                        run1 = false;
                                        run2 = false;
                                    }
                                    default -> System.out.println("Неверная команда!");
                                }
                            }
                        } else {
                            boolean run2 = true;
                            int id;
                            while (run2) {
                                System.out.print("\nВведите id книги, которую хотите редактировать: ");
                                id = Integer.parseInt(scr.nextLine());

                                if (id > books.size() || id < 0) {
                                    System.out.println("Книги с таким id не существует!\n[1] - Продолжить ввод id\n[2] - Выйти из параметра редактирования");
                                    int inp = Integer.parseInt(scr.nextLine());
                                    switch (inp) {
                                        case 1 -> {
                                            System.out.println();
                                        }
                                        case 2 -> {
                                            run1 = false;
                                            run2 = false;
                                        }
                                        default -> System.out.println("Неверная команда!");
                                    }
                                } else {
                                    editInfoBooks(id, books);
                                    run1 = false;
                                    run2 = false;
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                    while (run1) {
                        System.out.print("Введите ФИО автора: ");
                        String author = scr.nextLine();
                        boolean exists = false;

                        for (Book book : books) {
                            if (book.getAuthor().contains(WordUtils.capitalizeFully(author))) {
                                System.out.println(book.getId() + ". " + book.getName() + " - " + book.getAuthor());
                                exists = true;
                            }
                        }
                        if (!exists) {
                            boolean run2 = true;
                            while (run2) {
                                System.out.println("\nКниги с данным автором не найдены!\n[1] - Продолжить поиск\n[2] - Выйти из параметра редактирования");
                                int inp = Integer.parseInt(scr.nextLine());
                                switch (inp) {
                                    case 1 -> {
                                        System.out.println();
                                        run2 = false;
                                    }
                                    case 2 -> {
                                        run1 = false;
                                        run2 = false;
                                    }
                                    default -> System.out.println("Неверная команда!");
                                }
                            }
                        } else {
                            boolean run2 = true;
                            int id;
                            while (run2) {
                                System.out.print("\nВведите id книги, которую хотите редактировать: ");
                                id = Integer.parseInt(scr.nextLine());

                                if (id > books.size() || id < 0) {
                                    System.out.println("Книги с таким id не существует!\n[1] - Продолжить ввод id\n[2] - Выйти из параметра редактирования");
                                    int inp = Integer.parseInt(scr.nextLine());
                                    switch (inp) {
                                        case 1 -> {
                                            System.out.println();
                                        }
                                        case 2 -> {
                                            run1 = false;
                                            run2 = false;
                                        }
                                        default -> System.out.println("Неверная команда!");
                                    }
                                } else {
                                    editInfoBooks(id, books);
                                    run1 = false;
                                    run2 = false;
                                }
                            }
                        }
                    }
                }
                case 3 -> run = false;
                default -> System.out.println("Неверная команда!");
            }
        }
    }

    private static void editInfoBooks(int id, List<Book> books) {
        Scanner scr = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Выберите параметр который хотите отредактировать: \n[1] - Название книги\n[2] - ФИО автора\n" +
                    "[3] - Название издательства\n[4] - Количество страниц\n[5] - Жанр книги\n[6] - Год издания\n[7] - Себестоимость книги\n" +
                    "[8] - Цена для продажи\n[9] - Является ли книга продолжением\n[0] - Выйти из параметра редактирования");

            int inp = Integer.parseInt(scr.nextLine());
            switch (inp) {
                case 1 -> {
                    System.out.print("Введите новое название книги: ");
                    String newName = scr.nextLine();

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setName(newName);
                            System.out.println("Данные о названии книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 2 -> {
                    System.out.print("Введите новое ФИО автора: ");
                    String newAuthor;

                    while (true) {
                        newAuthor = scr.nextLine();
                        Pattern namePattern = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+ [а-яА-ЯёЁa-zA-Z]+ ?[а-яА-ЯёЁa-zA-Z]+$");
                        Matcher nameMatcher = namePattern.matcher(newAuthor);
                        if (!nameMatcher.matches()) {
                            System.out.print("Неверный формат ФИО! Введите снова (пример ввода: Иванов Иван Иванович): ");
                        } else {
                            break;
                        }
                    }

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setAuthor(newAuthor);
                            System.out.println("Данные о ФИО автора книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 3 -> {
                    System.out.print("Введите новое название издательства: ");
                    String newPublisher = scr.nextLine();

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setPublisher(newPublisher);
                            System.out.println("Данные о издателе книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 4 -> {
                    System.out.print("Введите новое количество страниц: ");
                    int newPageCount = Integer.parseInt(scr.nextLine());

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setPageCounts(newPageCount);
                            System.out.println("Данные о количестве страниц книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 5 -> {
                    String newGenre = "";
                    while (newGenre.isEmpty()) {
                        System.out.println("Выберите новый жанр книги: \n" +
                                "[1] - Роман\n[2] - Повесть\n[3] - Рассказ\n" +
                                "[4] - Сказки\n[5] - Лирика\n[6] - Трагедия\n" +
                                "[7] - Комедия\n[8] - Драма\n[9] - Поэма\n");

                        int input = Integer.parseInt(scr.nextLine());
                        switch (input) {
                            case 1 -> newGenre = "Роман";
                            case 2 -> newGenre = "Повесть";
                            case 3 -> newGenre = "Рассказ";
                            case 4 -> newGenre = "Сказки";
                            case 5 -> newGenre = "Лирика";
                            case 6 -> newGenre = "Трагедия";
                            case 7 -> newGenre = "Комедия";
                            case 8 -> newGenre = "Драма";
                            case 0 -> newGenre = "Поэма";
                            default -> System.out.println("Неверная команда!");
                        }
                    }

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setGenre(newGenre);
                            System.out.println("Данные о жанре книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 6 -> {
                    System.out.print("Введите новый год издания книги: ");
                    int newPublishingDate = Integer.parseInt(scr.nextLine());

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setPublishingDate(newPublishingDate);
                            System.out.println("Данные о годе издания книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 7 -> {
                    System.out.print("Введите новую себестоимость книги: ");
                    double newCostPrice = Double.parseDouble(scr.nextLine());

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setCostPrice(newCostPrice);
                            System.out.println("Данные о себестоимости книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 8 -> {
                    System.out.print("Введите новую цену для продажи книги: ");
                    double newSalePrice = Double.parseDouble(scr.nextLine());

                    for (Book book : books) {
                        if (book.getId().equals(id)) {
                            book.setSalePrice(newSalePrice);
                            System.out.println("Данные о цене для продажи книги успешно отредактированы!");
                            break;
                        }
                    }
                    run = false;
                }
                case 9 -> {
                    boolean run1 = true;
                    while (run1) {
                        System.out.println("Является ли книга продолжением?\n[1] - да\n[2] - нет");
                        int input = Integer.parseInt(scr.nextLine());

                        switch (input) {
                            case 1 -> {
                                for (Book book : books) {
                                    if (book.getId().equals(id)) {
                                        book.setSequel(true);
                                        System.out.println("Данные о книге успешно отредактированы!");
                                        break;
                                    }
                                }
                                run1 = false;
                            }
                            case 2 -> {
                                for (Book book : books) {
                                    if (book.getId().equals(id)) {
                                        book.setSequel(false);
                                        System.out.println("Данные о книге успешно отредактированы!");
                                        break;
                                    }
                                }
                                run1 = false;
                            }
                            default -> System.out.println("Неверная команда!");
                        }
                    }
                    run = false;
                }
                case 0 -> run = false;
                default -> System.out.println("Неверная команда!");
            }
        }
    }
}
