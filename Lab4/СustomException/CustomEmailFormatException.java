package Lab4.СustomException;

import java.io.FileWriter;
import java.io.IOException;

class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException() {
        super("CustomEmailFormatException");
    }

    public static void main(String[] args) {
        try {
            String email = "invalid_email.com"; // Адрес, который нужно проверить

            if (!isValidEmail(email)) {
                throw new CustomEmailFormatException(); // Если адрес не соответствует формату, выбрасываем CustomEmailFormatException
            }

            System.out.println("Email-адрес верен: " + email); // Если формат адреса верен, выводим сообщение
        } catch (CustomEmailFormatException e) {
            System.out.println(e.getMessage()); // Выводим сообщение об ошибке из CustomEmailFormatException
            logException(e); // Вызываем метод logException() для записи ошибки в файл
        }
    }

    private static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        int atIndex = email.indexOf("@");
        int dotIndex = email.lastIndexOf(".");

        if (atIndex < 1 || dotIndex < atIndex + 2 || dotIndex >= email.length() - 2) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        return true;
    }

    private static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            writer.write(e.getMessage() + "\n"); // Записываем сообщение об ошибке в файл
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage()); // Если возникла ошибка при записи в файл, выводим сообщение об ошибке
        }
    }
}
