package org.example.authentication;

public class LoginAndPassword {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";

    public static boolean checkLogin(String login) {
        if (login.equals(LOGIN)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPassword(String password) {
        if (password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}
