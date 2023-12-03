package Lab6;

public class Stack<T> {
    private T[] data; // массив для хранения элементов стека
    private int size; // размер стека

    // Конструктор класса Stack, принимает начальную емкость стека
    public Stack(int capacity) {
        // Создаем массив объектов типа T и приводим его к типу массива T
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // Метод для добавления элемента в стек
    public void push(T element) {
        // Проверяем, достигли ли максимальной емкости
        if (size == data.length) {
            // Если достигли, увеличиваем размер массива вдвое
            resize();
        }
        // Добавляем элемент в стек и увеличиваем размер стека
        data[size++] = element;
    }

    // Метод для удаления элемента из стека
    public T pop() {
        // Проверяем, не пуст ли стек
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Уменьшаем размер стека и возвращаем удаленный элемент
        return data[--size];
    }

    // Метод для получения верхнего элемента стека без его удаления
    public T peek() {
        // Проверяем, не пуст ли стек
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Возвращаем верхний элемент стека
        return data[size - 1];
    }

    // Метод для проверки, пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Вспомогательный метод для увеличения размера массива
    private void resize() {
        // Создаем новый массив вдвое большего размера
        T[] newData = (T[]) new Object[data.length * 2];
        // Копируем элементы из старого массива в новый
        System.arraycopy(data, 0, newData, 0, size);
        // Присваиваем новый массив полю data
        data = newData;
    }

    public static void main(String[] args) {
        // Пример использования
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Выводит 3
        System.out.println(stack.peek()); // Выводит 2
        stack.push(4);
        System.out.println(stack.pop()); // Выводит 4
    }
}

