package Lab4.СustomException;

import java.io.FileWriter;
import java.io.IOException;

public class CustomDivisionException {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 0;

        try {
            if (divisor == 0) {
                throw new Exception("CustomDivisionException");
                // Бросаем исключение типа Exception с сообщением "CustomDivisionException" в случае деления на ноль
            }
            System.out.println("Результат деления: " + dividend / divisor);
            // Если деление прошло успешно, выводим результат
        } catch (Exception e) {
            logException(e);
            // В случае исключения, вызываем метод logException для обработки и записи информации об ошибке
        }
    }

    private static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            // Открываем файл для записи с использованием FileWriter
            writer.write("Произошла ошибка: " + e.getMessage() + "\n");
        } catch (IOException ioException) {
            // Обрабатываем исключение, если произошла ошибка при записи в файл
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}
