package Lab7;

public class MatrixMax {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 110, 12},
                {13, 14, 15, 16}
        };

        // Количество потоков, равное количеству строк матрицы
        int numThreads = matrix.length;

        // Создаем массив для хранения потоков
        MaxFinderThread[] threads = new MaxFinderThread[numThreads];

        // Запускаем потоки для обработки каждой строки матрицы
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new MaxFinderThread(matrix[i]);
            threads[i].start();
        }

        // Ждем завершения работы всех потоков
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) { // В случае, если поток, который ожидает завершения другого потока
                                               // был прерван в процессе ожидания, возникает исключение
                e.printStackTrace();
            }
        }

        // Находим наибольший элемент среди результатов потоков
        int maxElement = Integer.MIN_VALUE; // -2^31
        for (int i = 0; i < numThreads; i++) {
            int threadMax = threads[i].getMax();
            if (threadMax > maxElement) {
                maxElement = threadMax;
            }
        }

        System.out.println("Наибольший элемент в матрице: " + maxElement);
    }
}

class MaxFinderThread extends Thread {
    private int[] row;
    private int max;

    public MaxFinderThread(int[] row) {
        this.row = row;
        this.max = Integer.MIN_VALUE; // -2^31
    }

    @Override
    public void run() {
        for (int value : row) {
            if (value > max) {
                max = value;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
