package tasks;

import java.util.*;

public class tasks3 {
    public static void main(String[] args) {
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(numCheck(52));
        int[] coefficients = {1, -6, 9};
        System.out.println(countRoots(coefficients));
        String[][] sales1 = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };

        String[][] sales2 = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };

        List<String> result1 = salesData(sales1);
        List<String> result2 = salesData(sales2);

        System.out.println(result1);
        System.out.println(result2);

        System.out.println(validSplit("apple eagle egg goat")); // true
        System.out.println(validSplit("cat dog goose fish")); // false

        int[] arr1 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(arr1)); // true

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(arr2)); // false

        int[] arr3 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(arr3)); // true

        String sentence = "Hello world";
        System.out.println(commonVowel(sentence));

        sentence = "Actions speak louder than words.";
        System.out.println(commonVowel(sentence));

        int[][] arrays = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };

        int[][] result = dataScience(arrays);

        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static String replaceVowels(String input) {
        // Создаем массив с гласными буквами
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        // Преобразуем входную строку в массив символов
        char[] chars = input.toCharArray();

        // Выполняем замену гласных букв на символ "*"
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (chars[i] == vowels[j]) {
                    chars[i] = '*';
                }
            }
        }
        // Преобразуем массив символов обратно в строку
        return new String(chars);
    }

    public static String stringTransform(String input) {
        String result = "";

        for (int i = 0; i < input.length() - 1; i++) {
            if (Character.toLowerCase(input.charAt(i)) == Character.toLowerCase(input.charAt(i + 1))) {
                result += "Double" + Character.toUpperCase(input.charAt(i + 1));
                i++; // Пропустим следующий символ, так как он уже был добавлен в результат
            } else {
                result += input.charAt(i);
            }
        }

        // Добавить последний символ, если есть
        if (input.length() > 0) {
            result += input.charAt(input.length() - 1);
        }

        return result;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        // Проверяем, поместится ли блок в отверстие
        if (a <= w && b <= h) {
            return true;
        }
        if (a <= h && b <= w) {
            return true;
        }
        if (a <= w && c <= h) {
            return true;
        }
        if (a <= h && c <= w) {
            return true;
        }
        if (b <= w && c <= h) {
            return true;
        }
        if (b <= h && c <= w) {
            return true;
        }
        return false;
    }

    public static boolean numCheck(int number) {
        int sumOfSquares = 0;
        int n = number;

        // Вычисляем сумму квадратов цифр числа
        while (n > 0) {
            int digit = n % 10; // Получаем последнюю цифру числа
            sumOfSquares += digit * digit; // Добавляем квадрат цифры к сумме
            n /= 10; // Уменьшаем число на порядок
        }

        // Проверяем, имеют ли число и сумма квадратов одну и ту же четность
        return (number % 2 == sumOfSquares % 2);
    }

    public static int countRoots(int[] coefficients) {
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];

        int d = b * b - 4 * a * c;

        if (d > 0) {
            // Два корня
            return 2;
        } else if (d == 0) {
            // Один корень
            return 1;
        } else {
            // Нет корней
            return 0;
        }
    }
    public static ArrayList<String> salesData(String[][] sales) {
        // Создаем список для хранения уникальных магазинов для каждого товара
        ArrayList<ArrayList<String>> arrayUniqueShops = new ArrayList<>();

        for (int i = 0; i < sales.length; i++) {
            ArrayList<String> sale1Shops = new ArrayList<>();

            // Проходим по магазинам для текущего товара
            for (int j = 1; j < sales[i].length; j++) {
                String currentShop = sales[i][j];
                // Флаг, который указывает, является ли магазин уникальным для данного товара
                boolean isUnique = true;

                for (int k = j + 1; k < sales[i].length; k++) {
                    if (sales[i][k].equals(currentShop)) {
                        isUnique = false;
                        break;
                    }
                }
                // Если магазин уникальный, добавляем его в список уникальных магазинов для товара
                if (isUnique) {
                    sale1Shops.add(currentShop);
                }
            }
            // Добавляем список уникальных магазинов для текущего товара в общий список уникальных магазинов
            arrayUniqueShops.add(sale1Shops);
        }

        // Находим максимальное количество уникальных магазинов среди всех товаров
        int max = arrayUniqueShops.get(0).size();
        for (int i = 1; i < arrayUniqueShops.size(); i++) {
            if (max < arrayUniqueShops.get(i).size()) {
                max = arrayUniqueShops.get(i).size();
            }
        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < arrayUniqueShops.size(); i++) {
            if (arrayUniqueShops.get(i).size() == max) {
                result.add(sales[i][0]);
            }
        }

        return result;
    }

    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");

        if (words.length < 2) {
            return false;
        }

        for (int i = 1; i < words.length; i++) {
            String previousWord = words[i-1].toLowerCase();
            String currentWord = words[i].toLowerCase();

            if (previousWord.charAt(previousWord.length()-1) != currentWord.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    public static boolean waveForm(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && !(arr[i] < arr[i + 1])) {
                continue;
            } else if (!(arr[i - 1] < arr[i]) && !(arr[i] > arr[i + 1])) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static char commonVowel(String sentence) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] counts = new int[vowels.length];

        for (int i = 0; i < sentence.length(); i++) {
            char c = Character.toLowerCase(sentence.charAt(i));

            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    counts[j]++;
                    break;
                }
            }
        }

        int maxCount = 0;
        char mostCommonVowel = ' ';

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                mostCommonVowel = vowels[i];
            }
        }

        return mostCommonVowel;
    }

    public static int[][] dataScience(int[][] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            int sum = 0;
            for (int j = 0; j < arrays.length; j++) {
                if (j != i) {
                    sum += arrays[j][i];
                }
            }
            int average = Math.round(sum / (arrays.length - 1f)); // Среднее арифметическое без учета текущего элемента
            arrays[i][i] = average;
        }

        return arrays;
    }
}