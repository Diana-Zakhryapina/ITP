package tasks;

import java.util.*;

public class tasks4 {

    public static void main(String[] args) {

        System.out.println(nonRepeatable("abracadabra")); // "abrcd"
        System.out.println(nonRepeatable("paparazzi")); // "parzi"

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(5));

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println(alphabeticRow("abcdjuwx")); // Вывод: "abcd"
        System.out.println(alphabeticRow("klmabzyxw")); // Вывод: "zyxw"

        System.out.println(duplicateCount("aaabbcdd")); // Вывод: "c1b2d2a3"
        System.out.println(duplicateCount("vvvvaajaaaaa")); // Вывод: "j1a2v4a5"

        System.out.println(convertToNum("eight hundred and ninety five")); // 8
        System.out.println(convertToNum("five hundred sixty seven")); // 567
        System.out.println(convertToNum("thirty one")); // 31

        System.out.println(uniqueSubstring("123412324")); // "1234"
        System.out.println(uniqueSubstring("111111"));    // "1"
        System.out.println(uniqueSubstring("77897898"));  // "789"

        int[][] matrix1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] matrix2 = {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}};
        System.out.println(shortestWay(matrix1)); // Вывод: 7
        System.out.println(shortestWay(matrix2)); // Вывод: 21

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); // "One ring to rule them all"
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); // "With great power comes great responsibility"

        System.out.println(switchNums(519, 723)); // 953
        System.out.println(switchNums(491, 3912)); // 9942
        System.out.println(switchNums(6274, 71259)); // 77659

    }


    public static String nonRepeatable(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        char firstChar = str.charAt(0);
        String restOfString = str.substring(1);

        // Удаляем все вхождения символа firstChar
        restOfString = restOfString.replaceAll(String.valueOf(firstChar), "");

        // Рекурсивно вызываем функцию для остатка строки и объединяем с первым символом
        return firstChar + nonRepeatable(restOfString);
    }


    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
    private static void generate(List<String> result, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }

        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }


    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryCombinations(result, "", n, 0);
        return result;
    }
    private static void generateBinaryCombinations(List<String> result, String current, int n, int symbolCount) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // Добавляем "0" только если не было двух нулей подряд
        if (symbolCount < 1) {
            generateBinaryCombinations(result, current + "0", n, symbolCount + 1);
        }

        // Всегда можно добавить "1"
        generateBinaryCombinations(result, current + "1", n, 0);
    }


    public static String alphabeticRow(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        String currentIncreasingSeries = Character.toString(input.charAt(0));
        String currentDecreasingSeries = Character.toString(input.charAt(0));
        String longestIncreasingSeries = currentIncreasingSeries;
        String longestDecreasingSeries = currentDecreasingSeries;

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);

            if (currentChar == prevChar + 1) {
                currentIncreasingSeries += currentChar; // Увеличивающийся ряд
            } else {
                if (currentIncreasingSeries.length() > longestIncreasingSeries.length()) {
                    longestIncreasingSeries = currentIncreasingSeries; // Обновляем самый длинный ряд
                }
                currentIncreasingSeries = Character.toString(currentChar); // Начинаем новый ряд
            }
            if (currentChar == prevChar - 1) {
                currentDecreasingSeries += currentChar; // Увеличивающийся ряд
            } else {
                if (currentDecreasingSeries.length() > longestDecreasingSeries.length()) {
                    longestDecreasingSeries = currentDecreasingSeries; // Обновляем самый длинный ряд
                }
                currentDecreasingSeries = Character.toString(currentChar); // Начинаем новый ряд
            }
        }

        // Проверяем последние ряды
        if (currentIncreasingSeries.length() > longestIncreasingSeries.length()) {
            longestIncreasingSeries = currentIncreasingSeries;
        } else if (currentDecreasingSeries.length() > longestDecreasingSeries.length()) {
            longestDecreasingSeries = currentDecreasingSeries;
        }

        if (longestIncreasingSeries.length() >= longestDecreasingSeries.length()) {
            return longestIncreasingSeries;
        } else {
            return longestDecreasingSeries;
        }
    }


    public static String duplicateCount(String input) {

        input += " ";
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        String result = "";

        int charsCount = 1;
        chars.add(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);

            if (prevChar == currentChar) {
                charsCount++;
            } else {
                count.add(charsCount);
                chars.add(currentChar);
                charsCount = 1;
            }
        }

        // Создаем список индексов, отсортированный по длине буквенного паттерна (count)
        List<Integer> sortedIndices = new ArrayList<>();
        for (int i = 0; i < count.size(); i++) {
            sortedIndices.add(i);
        }
        sortedIndices.sort(Comparator.comparing(count::get));

        // Формируем результат, учитывая сортировку
        for (int index : sortedIndices) {
            result += chars.get(index);
            result += count.get(index);
        }

        return result;
    }

    public static int convertToNum(String input) {
        // Создаем словарь (карту) для соответствия словам и числовому значению
        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("zero", 0);
        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);
        wordToNumber.put("ten", 10);
        wordToNumber.put("eleven", 11);
        wordToNumber.put("twelve", 12);
        wordToNumber.put("thirteen", 13);
        wordToNumber.put("fourteen", 14);
        wordToNumber.put("fifteen", 15);
        wordToNumber.put("sixteen", 16);
        wordToNumber.put("seventeen", 17);
        wordToNumber.put("eighteen", 18);
        wordToNumber.put("nineteen", 19);
        wordToNumber.put("twenty", 20);
        wordToNumber.put("thirty", 30);
        wordToNumber.put("forty", 40);
        wordToNumber.put("fifty", 50);
        wordToNumber.put("sixty", 60);
        wordToNumber.put("seventy", 70);
        wordToNumber.put("eighty", 80);
        wordToNumber.put("ninety", 90);

        // Разбиваем входную строку на слова
        String[] words = input.split(" ");

        int result = 0;

        for (String word : words) {
            Integer value = wordToNumber.get(word);

            if (value != null) {
                // Если слово найдено в словаре, добавляем его значение к текущему числу
                result += value;
            } else if (word.equals("hundred")) {
                result *= 100;
            } else if (word.equals("and")) {
                // Пропускаем слово "and"
                continue;
            }
        }

        return result;
    }


    public static String uniqueSubstring(String input) {

        int maxLength = 0;
        int currentLength = 0;
        int start = 0;
        int maxStart = 0;
        Set<Character> uniqueChars = new HashSet<>();  // Хэш-множество для отслеживания уникальных символов

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);


            if (!uniqueChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                currentLength++;


                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = start;
                }
            } else {
                // Найден повторяющийся символ, сдвигаем левый указатель
                while (input.charAt(start) != currentChar) {
                    uniqueChars.remove(input.charAt(start));  // Удаляем символы из хэш-множества
                    start++;                                  // Сдвигаем левый указатель
                }
                start++;  // Сдвигаем левый указатель ещё раз, чтобы убрать текущий повторяющийся символ
                currentLength = i - start + 1;  // Обновляем длину текущей уникальной подстроки
            }
        }

        // Возвращаем самую длинную уникальную подстроку
        return input.substring(maxStart, maxStart + maxLength);
    }


    public static int shortestWay(int[][] matrix) {
        int n = matrix.length;

        int[][] lengthWay = new int[n][n];
        lengthWay[0][0] = matrix[0][0];

        // Заполняем первый столбец
        for (int i = 1; i < n; i++) {
            lengthWay[i][0] = lengthWay[i - 1][0] + matrix[i][0];
        }

        // Заполняем первую строку
        for (int j = 1; j < n; j++) {
            lengthWay[0][j] = lengthWay[0][j - 1] + matrix[0][j];
        }

        // Заполняем остальную часть матрицы
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                lengthWay[i][j] = Math.min(lengthWay[i - 1][j], lengthWay[i][j - 1]) + matrix[i][j];
            }
        }

        // Возвращаем минимальную сумму в правом нижнем углу
        return lengthWay[n - 1][n - 1];
    }


    public static String numericOrder(String input) {
        String[] words = input.split(" "); // Разделяем входную строку на массив слов
        String[] sortedWords = new String[words.length]; // Создаем новый массив с таким же размером для отсортированных слов

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) { // Извлекаем числовой индекс из каждого слова
                    int index = Character.getNumericValue(word.charAt(i));
                    sortedWords[index - 1] = word.substring(0, i) + word.substring(i + 1); // Устанавливаем отсортированное слово в правильное место в массиве sortedWords, используя индекс
                }
            }
        }

        // Объединяем слова в массиве sortedWords с помощью пробелов
        return String.join(" ", Arrays.asList(sortedWords));
    }


    public static int switchNums(int num1, int num2) {
        // Преобразуем числа в массивы цифр
        String numStr1 = Integer.toString(num1);
        int[] digits1 = new int[numStr1.length()];
        for (int i = 0; i < numStr1.length(); i++) {
            digits1[i] = Character.getNumericValue(numStr1.charAt(i));
        }

        String numStr2 = Integer.toString(num2);
        int[] digits2 = new int[numStr2.length()];
        for (int i = 0; i < numStr2.length(); i++) {
            digits2[i] = Character.getNumericValue(numStr2.charAt(i));
        }

        // Сортируем массив цифр из 1 числа
        Arrays.sort(digits1);

        // Проходим по массиву цифр из 2 числа
        int index = digits1.length - 1;
        for (int i = 0; i < digits2.length && index >= 0; i++) {
            if (digits2[i] < digits1[index]) {
                digits2[i] = digits1[index];
                index--;
            }
        }

        // Преобразуем массив цифр обратно в число
        int result = 0;
        for (int digit : digits2) {
            result = result * 10 + digit;
        }

        return result;
    }
}
