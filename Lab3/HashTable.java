package Lab3;

import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table; // Массив списков для хранения элементов
    private int capacity; // Размер массива
    private int size; // Количество элементов в хеш-таблице
    private double loadFactor; // Коэффициент наполненности
    private int threshold; // Порог для увеличения размера таблицы

    // Конструктор хеш-таблицы
    public HashTable() {
        this.capacity = 10; // Начальный размер таблицы
        this.loadFactor = 0.9; // Коэффициент наполненности по умолчанию
        this.size = 0;
        this.threshold = (int) (capacity * loadFactor);
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public HashTable(int capacity, double loadFactor) {
        this.capacity = capacity; // Начальный размер таблицы
        this.loadFactor = loadFactor; // Коэффициент наполненности по умолчанию
    }

    public HashTable(int capacity) {
        this.capacity = capacity; // Начальный размер таблицы
    }

    public HashTable(double loadFactor) {
        this.loadFactor = loadFactor; // Начальный размер таблицы
    }

    // Возвращаем размер таблицы
    public int size() {
        return size;
    }

    // Пуста ли таблица
    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        if (size >= threshold) {
            resizeTable();
        }

        // Получаем индекс для данного ключа
        int index = getIndex(key);
        // Получаем массив chain по индексу
        LinkedList<Entry<K, V>> chain = table[index];
        // Если запись уже существует, то перезаписываем
        for (Entry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        // Новая запись
        chain.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        // Получаем индекс корзины для данного ключа
        int index = getIndex(key);
        // Получаем корзину по индексу
        LinkedList<Entry<K, V>> chain = table[index];
        // Если нашли ключ, возвращаем его значение
        for (Entry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        // Если нет, null
        return null;
    }

    // Удаляем пары ключ-значение
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> chain = table[index];
        for (Entry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                chain.remove(entry);
                size--;
                return;
            }
        }
    }

    private int getIndex(K key) {
        int hashCode = hashFunction(key);
        return Math.abs(hashCode % capacity);
    }

    // Метод для вычисления хеш-кода ключа
    private int hashFunction(K key) {
        int hash = 0;
        String keyStr = key.toString();
        for (int i = 0; i < keyStr.length(); i++) {
            hash += keyStr.charAt(i);
        }
        return hash;
    }

    // Метод для изменения размера таблицы при достижении порога
    private void resizeTable() {
        int newCapacity = capacity * 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Entry<K, V>> chain : table) {
            for (Entry<K, V> entry : chain) {
                int index = Math.abs(hashFunction(entry.getKey()) % newCapacity);
                newTable[index].add(entry);
            }
        }

        capacity = newCapacity;
        threshold = (int) (capacity * loadFactor);
        table = newTable;
    }

    // Класс для представления пары ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;

        // Конструктор для создания новой записи
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
