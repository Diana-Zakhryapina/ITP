package Lab4.СustomException.Task8;

import java.io.FileWriter;
import java.io.IOException;

class CustomUnsupportedOperationException {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            String operation = "divide"; // Операция (add, subtract, multiply, divide)

            System.out.println("Результат: " + performOperation(a, b, operation));
        } catch (UnsupportedOperationException e) {
            System.out.println("CustomUnsupportedOperationException");
            logException("CustomUnsupportedOperationException");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
            logException("ArithmeticException");
        }
    }

    // Метод для выполнения математических операций в зависимости от оператора
    private static int performOperation(int a, int b, String operation) {
        switch (operation) {
            case "add":
                return MathOperations.add(a, b);
            case "subtract":
                return MathOperations.subtract(a, b);
            case "multiply":
                return MathOperations.multiply(a, b);
            case "divide":
                return MathOperations.divide(a, b);
            default:
                throw new UnsupportedOperationException(); // Выбрасываем UnsupportedOperationException,
                                                           // если операция не поддерживается
        }
    }

    // Метод для записи сообщения об ошибке в файл
    private static void logException(String exception) {
        try (FileWriter writer = new FileWriter("exception_log.txt", true)) {
            writer.write(exception + "\n");
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в файл: " + ioException.getMessage());
        }
    }
}
