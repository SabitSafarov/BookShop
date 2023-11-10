package org.example.booksOperations;

import org.apache.commons.text.WordUtils;
import org.example.booksInfo.Book;
import org.example.booksInfo.ListOfBooks;

import java.util.List;
import java.util.Scanner;

public class BookDelete {

    public static void deleteBook(List<Book> books) {
        System.out.println("===== Удаление книги =====\n");

        Scanner scr = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Выберите параметр поиска для удаления книги: \n[1] - По названию книги\n[2] - По ФИО автора\n[3] - По жанру\n[4] - Выход");
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
                                System.out.println("\nКнига с данным названием не найдена!\n[1] - Продолжить поиск\n[2] - Выйти из параметра удаления");
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
                                System.out.print("\nВведите id книги, которую хотите удалить: ");
                                id = Integer.parseInt(scr.nextLine());

                                if (id > books.size() || id < 0) {
                                    System.out.println("Книги с таким id не существует!\n[1] - Продолжить ввод id\n[2] - Выйти из параметра удаления");
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
                                    for (Book book : books) {
                                        if (book.getId().equals(id)) {
                                            books.remove(book);
                                            ListOfBooks.count--;
                                            System.out.println("Книга успешно удалена!\n");
                                            break;
                                        }
                                    }

                                    for (Book book : books) {
                                        if (book.getId() > id) {
                                            book.setId(book.getId() - 1);
                                        }
                                    }
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
                                System.out.println("\nКниги с данным автором не найдены!\n[1] - Продолжить поиск\n[2] - Выйти из параметра удаления");
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
                                System.out.print("\nВведите id книги, которую хотите удалить: ");
                                id = Integer.parseInt(scr.nextLine());

                                if (id > books.size() || id < 0) {
                                    System.out.println("Книги с таким id не существует!\n[1] - Продолжить ввод id\n[2] - Выйти из параметра удаления");
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
                                    for (Book book : books) {
                                        if (book.getId().equals(id)) {
                                            books.remove(book);
                                            ListOfBooks.count--;
                                            System.out.println("Книга успешно удалена!\n");
                                            break;
                                        }
                                    }

                                    for (Book book : books) {
                                        if (book.getId() > id) {
                                            book.setId(book.getId() - 1);
                                        }
                                    }
                                    run1 = false;
                                    run2 = false;
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    while (run1) {
                        String genre = "";
                        while (genre.isEmpty()) {
                            System.out.println("Выберите жанр книги: \n" +
                                    "[1] - Роман\n[2] - Повесть\n[3] - Рассказ\n" +
                                    "[4] - Сказки\n[5] - Лирика\n[6] - Трагедия\n" +
                                    "[7] - Комедия\n[8] - Драма\n[9] - Поэма\n");
                            int inp = Integer.parseInt(scr.nextLine());
                            switch (inp) {
                                case 1 -> genre = "Роман";
                                case 2 -> genre = "Повесть";
                                case 3 -> genre = "Рассказ";
                                case 4 -> genre = "Сказки";
                                case 5 -> genre = "Лирика";
                                case 6 -> genre = "Трагедия";
                                case 7 -> genre = "Комедия";
                                case 8 -> genre = "Драма";
                                case 9 -> genre = "Поэма";
                                default -> System.out.println("Неверная команда!\n");
                            }
                        }

                        boolean exists = false;

                        for (Book book : books) {
                            if (book.getGenre().equals(genre)) {
                                System.out.println(book.getId() + ". " + book.getName() + " - " + book.getAuthor());
                                exists = true;
                            }
                        }

                        if (!exists) {
                            boolean run2 = true;
                            while (run2) {
                                System.out.println("\nК сожалению книги с данным жанром сейчас отсутствуют!\n[1] - Продолжить поиск\n[2] - Выйти из параметра удаления");
                                int inp1 = Integer.parseInt(scr.nextLine());
                                switch (inp1) {
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
                                System.out.print("\nВведите id книги, которую хотите удалить: ");
                                id = Integer.parseInt(scr.nextLine());

                                if (id > books.size() || id < 0) {
                                    System.out.println("Книги с таким id не существует!\n[1] - Продолжить ввод id\n[2] - Выйти из параметра удаления");
                                    int inp1 = Integer.parseInt(scr.nextLine());
                                    switch (inp1) {
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
                                    for (Book book : books) {
                                        if (book.getId().equals(id)) {
                                            books.remove(book);
                                            ListOfBooks.count--;
                                            System.out.println("Книга успешно удалена!\n");
                                            break;
                                        }
                                    }

                                    for (Book book : books) {
                                        if (book.getId() > id) {
                                            book.setId(book.getId() - 1);
                                        }
                                    }
                                    run1 = false;
                                    run2 = false;
                                }
                            }
                        }
                    }
                }
                case 4 -> run = false;
                default -> System.out.println("Неверная команда!");
            }
        }
    }
}
