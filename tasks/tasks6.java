package tasks;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tasks6 {
    public static void main(String[] args) {
        System.out.println(processStrings("My world evolves in a beautiful space called Tesh.", "sworn love lived")); // worldevolvesin
        System.out.println(processStrings("An old west action hero actor", "Clint Eastwood")); // noldwestactio
        System.out.println(processStrings("Mr. Mojo Rising could be a song title", "Jim Morrison")); // mrmojorisin
        System.out.println(processStrings("Banana? margaritas", "ANAGRAM")); // anamarg
        System.out.println(processStrings("D  e b90it->?$ (c)a r...d,,#~", "bad credit")); // debitcard
        System.out.println(processStrings("Bright is the moon", "Bongo mirth")); // notfound


        System.out.println(collect("intercontinentalisationalism", 6)); // ["ationa", "interc", "ntalis", "ontine"]
        System.out.println(collect("strengths", 3)); // ["eng", "str", "ths"]
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)); // ["croscopicsilico", "pneumonoultrami", "volcanoconiosis"]


        System.out.println(nicoCipher("myworldevolvesinhers", "tesh")); // "yowmledrovlvsnieesrh"
        System.out.println(nicoCipher("andiloveherso", "tesha")); // "lnidaevheo s or"
        System.out.println(nicoCipher("mubashirhassan", "crazy")); // "bmusarhiahass n"
        System.out.println(nicoCipher("edabitisamazing", "matt")); // "deabtiismaaznig "
        System.out.println(nicoCipher("iloveher", "612345")); // "lovehir    e"


        int[] arr1 = {1, 2, 3, 9, 4, 5, 15};
        System.out.println(Arrays.toString(twoProduct(arr1, 45))); // [9, 5]

        int[] arr2 = {1, 2, 3, 9, 4, 15, 3, 5};
        System.out.println(Arrays.toString(twoProduct(arr2, 45))); // [3, 15]

        int[] arr3 = {1, 2, -1, 4, 5, 6, 10, 7};
        System.out.println(Arrays.toString(twoProduct(arr3, 20))); // [4, 5]

        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(twoProduct(arr4, 10))); // [2, 5]

        int[] arr5 = {100, 12, 4, 1, 2};
        System.out.println(Arrays.toString(twoProduct(arr5, 15))); // []


        System.out.println(Arrays.toString(isExact(6)));     // [6, 3]
        System.out.println(Arrays.toString(isExact(24)));    // [24, 4]
        System.out.println(Arrays.toString(isExact(125)));   // []
        System.out.println(Arrays.toString(isExact(720)));   // [720, 6]
        System.out.println(Arrays.toString(isExact(1024)));  // []
        System.out.println(Arrays.toString(isExact(40320))); // [40320, 8]


        System.out.println(fractions("0.(6)"));         // "2/3"
        System.out.println(fractions("1.(1)"));         // "10/9"
        System.out.println(fractions("3.(142857)"));    // "22/7"
        System.out.println(fractions("0.19(2367)"));    // "5343/27775"
        System.out.println(fractions("0.1097(3)"));     // "823/7500"


        System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        // HOW I NEED A DRINK ALCOHOLIC IN NATURE AFTER THE HEAVY LECTURES INVOLVING QUANTUM MECHANICS
        System.out.println(pilish_string("FORALOOP")); // FOR A LOOP
        System.out.println(pilish_string("CANIMAKEAGUESSNOW")); // CAN I MAKE A GUESS NOWWWWWWW
        System.out.println(pilish_string("33314444"));  // "333 1 4444"
        System.out.println(pilish_string("TOP"));        // "TOP"
        System.out.println(pilish_string("X"));          // "XXX"
        System.out.println(pilish_string(""));           // ""


        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)")); // -17.0
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)")); // 0.0


        System.out.println(isValid("aabbcd")); // "NO"
        System.out.println(isValid("aabbccddeefghi")); // "NO"
        System.out.println(isValid("abcdefghhgfedecba")); // "YES"


        System.out.println(findLCS("abcd", "bd"));      // "bd"
        System.out.println(findLCS("aggtab", "gxtxamb")); // "gtab"
        System.out.println(findLCS("sdnvlsnvs", "sdnvfdkjvvlsnvdkn")); // "sdnvlsnv"
    }

    public static String processStrings(String sentence, String anagram) {
        // Удаление пробелов и преобразование к нижнему регистру
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanedAnagram = anagram.replaceAll("[^a-zA-Z]", "").toLowerCase();

        // Преобразование строки анаграммы в массив символов
        char[] anagramArray = cleanedAnagram.toCharArray();

        // Поиск скрытой анаграммы в предложении
        for (int i = 0; i <= cleanedSentence.length() - cleanedAnagram.length(); i++) {
            // Выделение подстроки из предложения для сравнения
            String substring = cleanedSentence.substring(i, i + cleanedAnagram.length());

            // Преобразование подстроки в массив символов
            char[] substringArray = substring.toCharArray();

            // Сортировка массивов символов
            Arrays.sort(anagramArray);
            Arrays.sort(substringArray);

            // Сравнение отсортированных массивов
            if (Arrays.equals(anagramArray, substringArray)) {
                return substring;
            }
        }

        // Если анаграмма не найдена
        return "notfound";
    }

    public static ArrayList<String> collect(String word, int n) {
        ArrayList<String> result = new ArrayList<>();

        // Если длина слова меньше n, возвращаем пустой массив
        if (word.length() < n) {
            return result;
        }

        // Добавляем срез длины n в результат
        result.add(word.substring(0, n));

        // Рекурсивный вызов для оставшейся части слова
        result.addAll(collect(word.substring(n), n));

        // Сортируем результат
        Collections.sort(result);

        return result;
    }


    public static String nicoCipher(String message, String key) {
        // Шаг 1: Назначаем числа отсортированным буквам из ключа
        // Создаем копию ключа и сортируем его
        char[] sortedKey = key.toCharArray();
        Arrays.sort(sortedKey);

        // Создаем массив чисел, соответствующих порядку букв в неотсортированном ключе
        int[] keyLetterNumber = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            char currentChar = key.charAt(i);

            // Используем indexOf для поиска индекса символа в отсортированном массиве
            int indexInSortedKey = new String(sortedKey).indexOf(currentChar);

            // Заменяем найденную букву в sortedKey на '.'
            sortedKey[indexInSortedKey] = '.';
            keyLetterNumber[i] = indexInSortedKey;
        }

        // Шаг 2: Назначаем номера буквам сообщения
        // Получаем длину ключа
        int keyLength = key.length();

        // Разбиваем сообщение на части равные длине ключа
        String[] parts = new String[(int) Math.ceil((double) message.length() / keyLength)];
        for (int i = 0; i < parts.length; i++) {
            int startIndex = i * keyLength;
            int endIndex = Math.min((i + 1) * keyLength, message.length());
            String part = message.substring(startIndex, endIndex);
            parts[i] = part;
        }

        // Добавляем пробелы, если последняя часть короче длины ключа
        while (parts[parts.length - 1].length() < key.length()) {
            parts[parts.length - 1] += " ";
        }

        // Создаем матрицу из частей
        char[][] matrix = new char[parts.length][keyLength];
        for (int row = 0; row < parts.length; row++) {
            for (int col = 0; col < keyLength; col++) {
                matrix[row][col] = parts[row].charAt(col);
            }
        }

        // Шаг 3: Сортируем столбцы по назначенным номерам
        // Переставляем элементы в каждой строке
        for (int row = 0; row < matrix.length; row++) {
            char[] transformedRow = new char[matrix[row].length];
            for (int col = 0; col < matrix[row].length; col++) {
                transformedRow[keyLetterNumber[col]] = matrix[row][col];
            }
            System.arraycopy(transformedRow, 0, matrix[row], 0, transformedRow.length);
        }

        // Шаг 4: Возвращаем закодированное сообщение по строкам
        // Инициализация строки result
        String result = "";

        // Проходим по строкам матрицы
        for (char[] row : matrix) {
            // Проходим по символам строки и добавляем их к строке result
            for (char symbol : row) {
                result += symbol;
            }
        }

        // Возвращаем результат
        return result;
    }


    public static int[] twoProduct(int[] arr, int n) {
        int[] result = new int[2];
        int minIndexDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] == n && j - i < minIndexDifference && result[0] != arr[i] &&
                        result[0] != arr[j] && result[1] != arr[i] && result[1] != arr[i]) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    minIndexDifference = j - i;
                }
            }
        }

        return result[0] == 0 && result[1] == 0 ? new int[0] : result;
    }


    public static int[] isExact(int n) {
        int[] result = findExactFactorialBoundary(n, 1, 1);
        return result != null ? result : new int[0];
    }

    private static int[] findExactFactorialBoundary(int n, int current, int factorial) {
        if (n == factorial) {
            return new int[]{n, current};
        } else if (factorial > n) {
            return null;
        } else {
            return findExactFactorialBoundary(n, current + 1, factorial * (current + 1));
        }
    }


    public static String fractions(String decimal) {
        // Паттерн для разбора десятичной дроби
        Pattern pattern = Pattern.compile("(\\d+)?\\.?(\\d+)?\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(decimal);

        if (matcher.matches()) {
            // Группы из регулярного выражения
            String integerPart = matcher.group(1);
            String nonRepeatingPart = matcher.group(2);
            String repeatingPart = matcher.group(3);

            // Инициализация числителя и знаменателя
            int numerator = 0;
            int denominator = 1;

            // Рассмотрим неповторяющуюся часть
            if (nonRepeatingPart != null) {
                numerator += Integer.parseInt(nonRepeatingPart);
                denominator *= Math.pow(10, nonRepeatingPart.length());
            }

            // Рассмотрим повторяющуюся часть
            if (repeatingPart != null) {
                // Умножаем на повторяющуюся часть на числитель
                numerator = numerator * (int) Math.pow(10, repeatingPart.length()) + Integer.parseInt(repeatingPart);
                // Умножаем знаменатель на (10^длина_повторяющейся_части - 1)
                denominator *= (Math.pow(10, repeatingPart.length()) - 1);

                // Если есть неповторяющаяся часть, вычитаем её из числителя
                if (nonRepeatingPart != null) {
                    numerator -= Integer.parseInt(nonRepeatingPart);
                }
            }

            // Рассмотрим целую часть
            if (integerPart != null) {
                // Прибавляем целую часть, умноженную на знаменатель, к числителю
                numerator += Integer.parseInt(integerPart) * denominator;
            }

            // Находим НОД числителя и знаменателя и делим на него
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            // Возвращаем результат в виде строки
            return numerator + "/" + denominator;
        } else {
            return "Invalid input";  // Если входные данные не соответствуют ожидаемому формату
        }
    }

    // Метод для нахождения НОД (наибольшего общего делителя) двух чисел
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public static String pilish_string(String txt) {
        if (txt.isEmpty()) {
            return "";
        }

        // Заданные цифры числа Пи
        String piDigits = "314159265358979";
        String result = "";

        // Итерация по входной строке
        for (int i = 0; i < piDigits.length(); i++) {
            // Получение текущей цифры числа Пи
            int piDigit = Character.getNumericValue(piDigits.charAt(i));

            // Определение длины текущего слова
            int wordLength = Math.min(piDigit, txt.length());

            // Добавление слова нужной длины в результат
            result += txt.substring(0, wordLength);
            txt = txt.substring(wordLength);

            // Повторение последней буквы, если необходимо
            if (piDigit > wordLength) {
                char lastChar = result.charAt(result.length() - 1);
                result += String.valueOf(lastChar).repeat(piDigit - wordLength);
            }

            // Добавление пробела, если остались еще цифры числа Пи
            if (i < piDigits.length() - 1) {
                result += ' ';
            }
        }

        return result;
    }


    public static String generateNonconsecutive(String expression) {
        String result;
        try {
            // Пытаемся преобразовать результат вычислений в целое число
            result = Integer.toString(Integer.parseInt(calculation(expression)));
        } catch (Exception e) {
            // Если произошла ошибка при парсинге или вычислении, возвращаем сообщение об ошибке
            result = "Error: " + e;
        }
        return result;
    }

    // Метод для рекурсивного вычисления математического выражения
    private static String calculation(String input) {
        // Определяем шаблоны для различных математических операций и элементов выражения
        Pattern pattern1 = Pattern.compile("-?\\d+\\s\\*\\s-?\\d+");
        Pattern pattern2 = Pattern.compile("-?\\d+\\s/\\s-?\\d+");
        Pattern pattern3 = Pattern.compile("-?\\d+\\s-\\s-?\\d+");
        Pattern pattern4 = Pattern.compile("-?\\d+\\s\\+\\s-?\\d+");
        Pattern patternD = Pattern.compile("-?\\d+");
        Pattern patternBracket = Pattern.compile("\\([0-9*/+\\-\\s]+\\)");

        // Создаем соответствующие матчеры для шаблонов
        Matcher matcher1 = pattern1.matcher(input);
        Matcher matcher2 = pattern2.matcher(input);
        Matcher matcher3 = pattern3.matcher(input);
        Matcher matcher4 = pattern4.matcher(input);
        Matcher matcherBracket = patternBracket.matcher(input);

        if (matcherBracket.find()) {
            // Если найдены скобки, вычисляем выражение внутри скобок и заменяем в исходной строке
            String bracket = matcherBracket.group().replaceAll("[()]", "");
            input = input.replaceFirst(String.valueOf(patternBracket), calculation(bracket));
            // Рекурсивный вызов для обработки оставшегося выражения
            return calculation(input);
        } else if (matcher1.find()) {
            // Если найдено выражение умножения, вычисляем его и заменяем в исходной строке
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher1.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()) {
                x *= Integer.parseInt(matcherD.group());
            }
            input = input.replaceFirst(String.valueOf(pattern1), Integer.toString(x));
            // Рекурсивный вызов для обработки оставшегося выражения
            return calculation(input);
        } else if (matcher2.find()) {
            // Аналогично для выражения деления
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher2.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()) {
                try {
                    x /= Integer.parseInt(matcherD.group());
                } catch (Exception e) {
                    input = "Error: " + e;
                }
            }
            input = input.replaceFirst(String.valueOf(pattern2), Integer.toString(x));
            return calculation(input);
        } else if (matcher3.find()) {
            // Аналогично для выражения вычитания
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher3.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()) {
                x -= Integer.parseInt(matcherD.group());
            }
            input = input.replaceFirst(String.valueOf(pattern3), Integer.toString(x));
            return calculation(input);
        } else if (matcher4.find()) {
            // Аналогично для выражения сложения
            int x = 1;
            Matcher matcherD = patternD.matcher(matcher4.group());
            if (matcherD.find()) {
                x = Integer.parseInt(matcherD.group());
            }
            if (matcherD.find()) {
                x += Integer.parseInt(matcherD.group());
            }
            input = input.replaceFirst(String.valueOf(pattern4), Integer.toString(x));
            return calculation(input);
        } else {
            // Если не найдено ни одного оператора, возвращаем исходную строку
            return input;
        }
    }


    public static String isValid(String str) {
        // Создаем карту символов и их частоты
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        // Создаем карту частот и их количества
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : charFrequency.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        if (freqCount.size() > 2) {
            return "NO";
        }

        if (freqCount.size() == 1) {
            // Все символы встречаются одинаковое количество раз
            return "YES";
        }

        // Теперь у нас есть две разные частоты
        int freq1 = 0;
        int freq2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            if (freq1 == 0) {
                freq1 = entry.getKey();
                count1 = entry.getValue();
            } else {
                freq2 = entry.getKey();
                count2 = entry.getValue();
            }
        }

        // Мы можем удалить один символ с частотой, равной 1
        if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
            return "YES";
        }

        // Мы можем удалить один символ, встречающийся чаще остальных на 1 раз
        if ((freq1 - freq2 == 1 && count1 == 1) || (freq2 - freq1 == 1 && count2 == 1)) {
            return "YES";
        }

        return "NO";
    }


    // Функция для нахождения наибольшей общей подпоследовательности (LCS)
    public static String findLCS(String str1, String str2) {
        // Длины входных строк
        int m = str1.length();
        int n = str2.length();

        // Массив для хранения результатов подзадач
        int[][] dp = new int[m + 1][n + 1];

        // Заполнение массива dp пошагово
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Если одна из строк пуста, LCS равно 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // Если символы совпадают, увеличиваем длину LCS на 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Если символы не совпадают, берем максимум из предыдущих значений
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Построение LCS из массива dp
        int index = dp[m][n];
        char[] lcs = new char[index];

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // Если символы совпадают, добавляем символ в LCS и двигаемся по диагонали вверх и влево
                lcs[--index] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Если символы не совпадают, идем в направлении, где значение dp больше
                i--;
            } else {
                j--;
            }
        }

        // Преобразование массива символов в строку и возврат LCS
        return new String(lcs);
    }
}
