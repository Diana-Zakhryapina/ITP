package Lab5;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        // Пример текста, в котором нужно найти числа
        String text = "The price of the product is $19.99. However, there are also " +
                      "numbers that may be part of words, for instance, in the word " +
                      "\"creative25\" or \"interesting3.5example\".";

        // Вызываем метод findNumbers для поиска и вывода чисел
        try {
            // Проверяем, что введенный текст не является пустой строкой
            if (!text.isEmpty()) {
                findNumbers(text);
            } else {
                System.err.println("Ошибка: Введена пустая строка.");
            }
        } catch (Exception e) {
            // Обрабатываем другие неожиданные ошибки
            System.err.println("Неожиданная ошибка: " + e.getMessage());
        }
    }

    // Метод для поиска и вывода чисел в тексте
    public static void findNumbers(String text) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");

        // Создаем объект Matcher, который будет работать с текстом по заданному шаблону
        Matcher matcher = pattern.matcher(text);

        // Перебираем все совпадения в тексте
        while (matcher.find()) {
            // Выводим найденное число
            System.out.println(matcher.group());
        }
    }
}
