package Lab5;

import java.util.Scanner;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        // Запрашиваем у пользователя ввод пароля
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Проверяем корректность пароля
        try {
            validatePassword(password);
            System.out.println("Пароль корректен.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            // Обрабатываем другие неожиданные ошибки
            System.err.println("Неожиданная ошибка: " + e.getMessage());
        }
    }

    public static void validatePassword(String password) {
        // Проверяем длину пароля (от 8 до 16 символов)
//        if (password.length() < 8 || password.length() > 16) {
//            throw new IllegalArgumentException("Пароль должен быть от 8 до 16 символов.");
//        }

        // ^ - начало строки
        // (?=.*[A-Z]) - хотя бы одна заглавная буква
        // (?=.*\\d) - хотя бы одна цифра
        // [A-Za-z\\d]+ - только латинские буквы и цифры (без спецсимволов)
        // $ - конец строки
        Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}");
        Matcher matcher = pattern.matcher(password);

        // Если пароль не соответствует требованиям, выбрасываем исключение
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Пароль должен содержать латинские буквы, " +
                    "а также хотя бы одну цифру и заглавную букву.");
        }
    }
}
