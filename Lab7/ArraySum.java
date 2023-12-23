package Lab7;

public class ArraySum {

    public static void main(String[] args) {
        // Создаем массив для вычислений
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Создаем два потока для вычисления суммы по половинкам
        SumThread thread1 = new SumThread(array, 0, array.length / 2);
        SumThread thread2 = new SumThread(array, array.length / 2, array.length);

        // Запускаем потоки
        thread1.start();
        thread2.start();

        try {
            // Ждем завершения обоих потоков
            thread1.join();
            thread2.join();

            // Получаем результаты из потоков и складываем их
            int result = thread1.getResult() + thread2.getResult();

            // Выводим результат
            System.out.println("Сумма элементов массива: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SumThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int result;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.result = 0;
    }

    @Override
    public void run() {
        // Вычисляем сумму элементов массива в заданном диапазоне
        for (int i = start; i < end; i++) {
            result += array[i];
        }
    }

    public int getResult() {
        return result;
    }
}
