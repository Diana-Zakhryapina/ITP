package Lab4.СustomException;

import java.io.FileWriter;
import java.io.IOException;

public class CustomAgeException {
    public static void main(String[] args) {
        int age = 130;

        try {
            if (age < 0 || age > 120) {
                throw new Exception("CustomAgeException");
                // Бросаем исключение типа Exception с сообщением "CustomAgeException" в случае, если возраст не корректен
            }
            System.out.println("Ваш возраст: " + age);
            // Выводим сообщение "CustomAgeException", если возраст находится в допустимом диапазоне
        } catch (Exception e) {
            logException(e);
            // В случае исключения, вызываем метод logException
        }
    }

    private static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            // Открываем файл "exception_log.txt" для записи с использованием FileWriter
            writer.write("CustomAgeException\n");
            // Записываем сообщение об ошибке в файл
        } catch (IOException ioException) {
            // Обрабатываем исключение, если произошла ошибка при записи в файл
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}
