package Lab4.СustomException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileNotFoundException {
    public static void main(String[] args) {
        String fileName = "non_existent_file.txt";

        try {
            FileReader reader = new FileReader(fileName);
            // Пытаемся открыть файл "non_existent_file.txt" для чтения с использованием FileReader
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
                // Читаем символы из файла и выводим их на экран
            }
            reader.close();
            // Закрываем FileReader после завершения чтения
        } catch (IOException e) {
            // Обрабатываем исключение, если произошла ошибка при работе с файлом
            logException(e);
            // В случае исключения, вызываем метод logException для обработки и записи информации об ошибке
        }
    }

    private static void logException(IOException e) {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            // Открываем файл "exception_log.txt" для записи с использовани
            writer.write("CustomFileNotFoundException\n");
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}
