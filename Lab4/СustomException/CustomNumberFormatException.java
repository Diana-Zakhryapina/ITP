package Lab4.СustomException;

import java.io.FileWriter;
import java.io.IOException;

public class CustomNumberFormatException {
    public static void main(String[] args) {
        String str = "3h34j5";

        try {
            int number = Integer.parseInt(str);
            // Пытаемся преобразовать строку в целое число

            System.out.println("Число: " + number);
            // Если преобразование прошло успешно, выводим число
        } catch (NumberFormatException e) {
            logException(e);
            // В случае NumberFormatException, вызываем метод logException для обработки и записи информации об ошибке
        }
    }

    private static void logException(NumberFormatException e) {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            // Открываем файл "exception_log.txt" для записи с использованием FileWriter
            writer.write("CustomNumberFormatException\n");
            // Записываем сообщение об ошибке в файл
        } catch (IOException ioException) {
            // Обрабатываем исключение, если произошла ошибка при записи в файл
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}
