package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Указываем путь к файлу
        String filePath = "/Users/diana/Desktop/Учеба/ИТП/Лабы/Java_labs.pdf";

        // Создаем объект File
        File file = new File(filePath);

        // Создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            // Считываем слово
            String word = scanner.next().toLowerCase();

            // Убираем знаки препинания, чтобы "word" и "word." не считались разными словами
            word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");

            // Помещаем слово в Map, увеличивая счетчик, если оно уже там есть
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Закрываем Scanner
        scanner.close();

        // Создаем список из элементов Map
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCountMap.entrySet());

        // Сортируем список по убыванию количества повторений
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // Выводим топ-10 слов
        System.out.println("Топ-10 самых часто встречающихся слов:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : entryList) {
            if (count < 10) {
                // Выводим слово и количество его повторений
                System.out.println(entry.getKey() + ": " + entry.getValue() + " раз");
                count++;
            } else {
                // Прекращаем вывод после топ-10
                break;
            }
        }
    }
}
