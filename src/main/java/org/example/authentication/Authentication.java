package org.example.authentication;

import java.util.Scanner;

public class Authentication {
    public static void main(String[] args) {
        System.out.println("\t===== Вход в систему =====");

        Scanner scr = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Выберите команду:\n [1] - Вход\n [2] - Выход из программы");
            String input = scr.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.print("Введите логин: ");
                    String login = scr.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scr.nextLine();

                    if (LoginAndPassword.checkLogin(login) && LoginAndPassword.checkPassword(password)) {
                        System.out.println("\nВход выполнен успешно!\n");
                        Menu.start();
                    } else {
                        System.out.println("\nНеверные данные!\n");
                    }
                }
                case "2" -> run = false;
                default -> System.out.println("\nНесуществующая команда!\n");
            }
        }
    }
}