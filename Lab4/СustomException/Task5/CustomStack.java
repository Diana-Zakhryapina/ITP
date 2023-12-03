package Lab4.СustomException.Task5;

import java.util.EmptyStackException;

class CustomStack {
    private int[] stackArray; // Массив
    private int top; // Индекс верхнего элемента стека

    public CustomStack(int capacity) {
        stackArray = new int[capacity]; // Инициализируем массив с заданной вместимостью
        top = -1; // Изначально стек пуст, поэтому индекс верхнего элемента устанавливаем в -1
    }

    public void push(int value) {
        if (top == stackArray.length - 1) {
            // Если верхний элемент стека достиг максимальной вместимости, стек полон
            System.out.println("Стек полон");
            return;
        }

        stackArray[++top] = value; // Увеличиваем индекс верхнего элемента и добавляем значение в стек
    }

    public int pop() {
        if (top == -1) {
            // Если стек пуст, выбрасываем CustomEmptyStackException
            throw new EmptyStackException();
        }

        return stackArray[top--]; // Извлекаем верхний элемент стека и уменьшаем индекс верхнего элемента
    }
}
