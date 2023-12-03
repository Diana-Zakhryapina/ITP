package Lab4;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFileName = "source.txt"; // Имя исходного файла
        String targetFileName = "target.txt"; // Имя файла, в который будет скопировано содержимое

        try (FileInputStream fis = new FileInputStream(sourceFileName);
             FileOutputStream fos = new FileOutputStream(targetFileName)) {

            byte[] buffer = new byte[1024]; // Создаем буфер для копирования данных размером 1024 байта
            int bytesRead; // Отслеживаем количество байт, прочитанных из исходного файла

            while ((bytesRead = fis.read(buffer)) != -1) {
                // Читаем данные из исходного файла в буфер
                // Метод read возвращает количество прочитанных байтов. Когда достигнут конец файла, возвращается -1

                fos.write(buffer, 0, bytesRead); // Записываем данные из буфера в целевой файл
            }

            System.out.println("Файл успешно скопирован.");

        } catch (IOException e) {
            System.err.println("Произошла ошибка при копировании файла: " + e.getMessage());
        }
    }
}
