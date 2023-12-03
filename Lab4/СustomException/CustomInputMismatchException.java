package Lab4.СustomException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomInputMismatchException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для считывания ввода с клавиатуры

        System.out.print("Введите целое число: ");

        try {
            int number = scanner.nextInt(); // Пытаемся считать целое число с клавиатуры
            System.out.println("Вы ввели целое число: " + number); // Если успешно, выводим введенное число
        } catch (InputMismatchException e) {
            System.out.println("CustomInputMismatchException"); // Если возникает InputMismatchException
                                                                // выводим сообщение об ошибке
            logException(); // Вызываем метод logException() для записи ошибки в файл
        } finally {
            scanner.close(); // Закрываем объект Scanner
        }
    }

    private static void logException() {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            writer.write("CustomInputMismatchException\n"); // Записываем сообщение об ошибке в файл
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
            // Если возникла ошибка при записи в файл, выводим сообщение об ошибке
        }
    }
}
