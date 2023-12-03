package Lab4.СustomException.Task5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;


class CustomEmptyStackException {

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5); // Создаем объект стека с максимальной вместимостью 5

        try {
            stack.pop(); // Пытаемся извлечь элемент из пустого стека
        } catch (EmptyStackException e) {
            System.out.println("CustomEmptyStackException");
            logException();
            // Если EmptyStackException возникает при попытке извлечения из пустого стека, выводим сообщение
        }

        stack.push(1); // Добавляем элементы в стек
        stack.push(2);
        stack.push(3);

        try {
            System.out.println("Popped: " + stack.pop()); // Извлекаем элементы из стека и выводим их
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop()); // Попытка извлечь из пустого стека
        } catch (EmptyStackException e) {
            System.out.println("CustomEmptyStackException");
            logException();
            // Если EmptyStackException возникает при попытке извлечения из пустого стека, выводим сообщение
        }
    }

    public static void logException() {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            writer.write("CustomEmptyStackException\n");
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}
