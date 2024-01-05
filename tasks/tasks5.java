package tasks;

import java.util.*;
import java.text.*;

public class tasks5 {

    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD")); // true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); // true
        System.out.println(sameLetterPattern("FFGG", "CDCD")); // false
        System.out.println(sameLetterPattern("FFFF", "ABCD")); // false

        System.out.println(spiderVsFly("H3", "E2")); // Выводит "H3-H2-H1-A0-E1-E2"
        System.out.println(spiderVsFly("A4", "B2")); // Выводит "A4-A3-A2-B2"
        System.out.println(spiderVsFly("A4", "C2")); // Выводит "A4-A3-A2-B2-C2"

        System.out.println(digitsCount(4666)); // 4
        System.out.println(digitsCount(544));  // 3
        System.out.println(digitsCount(121317)); // 6
        System.out.println(digitsCount(0));    // 1
        System.out.println(digitsCount(12345)); // 5
        System.out.println(digitsCount(1289396387328L)); // 13

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); // 2
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); // 108
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); // 13

        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5})); // [[3, 5]]
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9})); // [[1, 7]]
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8})); // []
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})); // [[2, 6], [3, 5], [1, 7]]

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); // "54%"
        System.out.println(takeDownAverage(new String[]{"10%"})); // "0%"
        System.out.println(takeDownAverage(new String[]{"53%", "79%"})); // "51%"

        System.out.println(caesarCipher("encode", "hello world", 3)); // "KHOOR ZRUOG"
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4)); // "ALMOST LAST TASK!"

        System.out.println(setSetup(5, 3)); // 60
        System.out.println(setSetup(7, 3)); // 210

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); // "2011-4-2 17:23"
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); // "1983-8-1 00:01"
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); // "1971-1-1 02:40"

        System.out.println(isNew(3));   // true
        System.out.println(isNew(30));  // true
        System.out.println(isNew(321));  // false
        System.out.println(isNew(123));  // true
    }

    public static boolean sameLetterPattern(String str1, String str2) {
        // Проверка длин строк
        if (str1.length() != str2.length()) {
            return false;
        }

        // Создаем пустую карту (ключ - символ из первой строки, значение - символ из второй строки)
        Map<Character, Character> charMap = new HashMap<>();

        // Проходим по символам в строках.
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // Если символ char1 уже есть в карте, проверяем, соответствует ли он char2.
            if (charMap.containsKey(char1)) {
                if (charMap.get(char1) != char2) {
                    // Если символ в str1 уже соответствует другому символу в str2, возвращаем false
                    return false;
                }
            } else {
                // Иначе, если символ char1 не был добавлен в карту, добавляем его со значением char2
                charMap.put(char1, char2);
            }
        }

        // Если все проверки пройдены, возвращаем true
        return true;
    }


    public static String spiderVsFly(String spider, String fly) {
        String way = "";
        char spiderRadial = spider.charAt(0);
        int spiderRing = Character.getNumericValue(spider.charAt(1));
        char flyRadial = fly.charAt(0);
        int flyRing = Character.getNumericValue(fly.charAt(1));

        // Если паук и муха находятся на одном радиале
        if (spiderRadial == flyRadial) {
            if (spiderRing < flyRing) {
                while (spiderRing < flyRing) {
                    way += spiderRadial + Integer.toString(spiderRing) + "-";
                    spiderRing += 1;
                }
                way += fly;
                return way;
            } else if (spiderRing > flyRing) {
                while (spiderRing > flyRing) {
                    way += spiderRadial + Integer.toString(spiderRing) + "-";
                    spiderRing -= 1;
                }
                way += fly;
                return way;
            } else {
                way += spider;
            }
        }

        // Если паук и муха находятся на противоположных радиалах
        if (Math.abs(spiderRadial - flyRadial) == 4) {
            return centerWay(spiderRadial, spiderRing, flyRadial, flyRing, fly);
        } else if (spiderRing > flyRing) { // Если муха ниже паука
            int i;
            if (Math.abs(spiderRadial - flyRadial) < 4) {
                i = Math.abs(spiderRadial - flyRadial);
            } else {
                i = 8 - Math.abs(spiderRadial - flyRadial);
            }
            double centerWay = spiderRing + flyRing;
            double ringWay = spiderRing - flyRing + i * Math.sqrt(Math.pow(flyRing, 2) * (2 - Math.sqrt(2)));

            if (centerWay < ringWay) {
                return centerWay(spiderRadial, spiderRing, flyRadial, flyRing, fly);
            } else {
                while (spiderRing > flyRing) {
                    way += spiderRadial + Integer.toString(spiderRing) + "-";
                    spiderRing -= 1;
                }
                way += spiderRadial + Integer.toString(spiderRing) + "-";
                if (Math.abs(spiderRadial - flyRadial) < 4) { // Проверяем, что путь не проходит через границу A-H
                    if ((spiderRadial - flyRadial) < 0) { // Идем по часовой стрелке
                        while (i - 1 > 0) {
                            spiderRadial += 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                            i -= 1;
                        }
                        way += fly;
                        return way;
                    } else { // Идем против часовой стрелки
                        while (i - 1 > 0) {
                            spiderRadial -= 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                            i -= 1;
                        }
                        way += fly;
                        return way;
                    }
                } else if (Math.abs(spiderRadial - flyRadial) > 4) { // Проверяем, что путь проходит через границу A-H
                    if ((spiderRadial - flyRadial) > 0) { // Идем по часовой стрелке
                        while (i - 1 > 0) {
                            if (spiderRadial == 'H') {
                                spiderRadial = 'A' - 1;
                            }
                            spiderRadial += 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                        }
                        way += fly;
                        return way;
                    } else { // Идем против часовой стрелки
                        while (i - 1 > 0) {
                            if (spiderRadial == 'A') {
                                spiderRadial = 'H' + 1;
                            }
                            spiderRadial -= 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                        }
                        way += fly;
                        return way;
                    }
                }
            }
        } else { // Если паук ниже мухи или на том же уровне
            int k;
            if (Math.abs(spiderRadial - flyRadial) < 4) {
                k = Math.abs(spiderRadial - flyRadial);
            } else {
                k = 8 - Math.abs(spiderRadial - flyRadial);
            }
            double centerWay = spiderRing + flyRing;
            double ringWay = k * Math.sqrt(Math.pow(spiderRing, 2) * (2 - Math.sqrt(2))) + flyRing - spiderRing;

            if (centerWay < ringWay) {
                return centerWay(spiderRadial, spiderRing, flyRadial, flyRing, fly);
            } else {
                while (spiderRing < flyRing) {
                    way += spiderRadial + Integer.toString(spiderRing) + "-";
                    spiderRing += 1;
                }
                way += spiderRadial + Integer.toString(spiderRing) + "-";
                if (Math.abs(spiderRadial - flyRadial) < 4) { // Проверяем, что путь не проходит через границу A-H
                    if ((spiderRadial - flyRadial) < 0) { // Идем по часовой стрелке
                        while (k - 1 > 0) {
                            spiderRadial += 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                            k -= 1;
                        }
                        way += fly;
                        return way;
                    } else { // Идем против часовой стрелки
                        while (k - 1 > 0) {
                            spiderRadial -= 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                            k -= 1;
                        }
                        way += fly;
                        return way;
                    }
                } else if (Math.abs(spiderRadial - flyRadial) > 4) { // Проверяем, что путь проходит через границу A-H
                    if ((spiderRadial - flyRadial) > 0) { // Идем по часовой стрелке
                        while (k - 1 > 0) {
                            if (spiderRadial == 'H') {
                                spiderRadial = 'A' - 1;
                            }
                            spiderRadial += 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                        }
                        way += fly;
                        return way;
                    } else { // Идем против часовой стрелки
                        while (k - 1 > 0) {
                            if (spiderRadial == 'A') {
                                spiderRadial = 'H' + 1;
                            }
                            spiderRadial -= 1;
                            way += spiderRadial + Integer.toString(spiderRing) + "-";
                        }
                        way += fly;
                        return way;
                    }
                }
            }
        }
        return way;
    }

    public static String centerWay(char spiderRadial, int spiderRing, char flyRadial, int flyRing, String fly) {
        String way = "";
        while (spiderRing > 0) {
            way += spiderRadial + Integer.toString(spiderRing) + "-";
            spiderRing -= 1;
        }
        way += "A0-";
        while (spiderRing < flyRing - 1) {
            spiderRing += 1;
            way += flyRadial + Integer.toString(spiderRing) + "-";
        }
        way += fly;
        return way;
    }


    public static int digitsCount(long number) {
        // Если число меньше 10, то у него 1 цифра
        if (number < 10 && number > -10) {
            return 1;
        }
        // Делим число на 10 и рекурсивно вызываем функцию
        return 1 + digitsCount(number / 10);
    }


    public static int totalPoints(String[] guesses, String word) {
        // Общее количество очков
        int totalScore = 0;

        // Создаем карту для доступных букв
        Map<Character, Integer> availableLetters = new HashMap<>();

        // Заполняем карту буквами из данного слова
        for (char letter : word.toCharArray()) {
            availableLetters.put(letter, availableLetters.getOrDefault(letter, 0) + 1);
        }

        // Проходим по угаданным словам
        for (String guess : guesses) {
            // Флаг для проверки, можно ли собрать данное слово
            boolean validWord = true;

            // Очки за текущее слово
            int score = 0;

            // Создаем копию карты доступных букв для текущего слова
            Map<Character, Integer> letterCount = new HashMap<>(availableLetters);

            // Проверяем, можно ли собрать слово из доступных букв
            for (char letter : guess.toCharArray()) {
                if (letterCount.containsKey(letter) && letterCount.get(letter) > 0) {
                    // Если буква доступна, уменьшаем ее количество на 1
                    letterCount.put(letter, letterCount.get(letter) - 1);
                } else {
                    // Если буква недоступна, сбрасываем флаг и выходим из цикла
                    validWord = false;
                    break;
                }
            }

            // Если слово может быть собрано из букв, начисляем очки в соответствии с его длиной
            if (validWord) {
                int wordLength = guess.length();
                if (wordLength == 3) {
                    score = 1;
                } else if (wordLength == 4) {
                    score = 2;
                } else if (wordLength == 5) {
                    score = 3;
                } else if (wordLength == 6) {
                    score = 54; // 4 очка + 50 бонус за 6-буквенное слово
                }
            }

            // Добавляем очки за текущее слово к общему счету
            totalScore += score;
        }

        // Возвращаем общее количество очков
        return totalScore;
    }


    public static String sumsUp(int[] arr) {
        ArrayList<String> res = new ArrayList<>(); // Создаем ArrayList для хранения результата
        for (int i = 1; i < arr.length; i++) { // Курсор
            for (int j = 0; j < i - 1; j++) { // Проходим по элементам до курсора (исключая его)
                if (arr[i] + arr[j] == 8) {
                    int[] pair = {arr[i], arr[j]};
                    Arrays.sort(pair); // Сортируем числа по возрастанию
                    res.add(Arrays.toString(pair));
                }
            }
        }
        return res.toString();
    }


    public static String takeDownAverage(String[] classmates) {
        // Общее процентное значение оценок класса
        int totalPercentage = 0;

        // Проходим по каждой оценке
        for (String percentage : classmates) {
            // Убираем символ '%' и преобразуем оценку в целое число
            totalPercentage += Integer.parseInt(percentage.replace("%", ""));
        }

        // Получаем размер класса (количество одноклассников)
        int classSize = classmates.length;

        int myGrade = (int) (Math.round(((double) totalPercentage / classSize) - 5 * (classSize + 1)));

        // Возвращаем результат в формате процентов
        return myGrade + "%";
    }


    public static String caesarCipher(String mode, String text, int shift) {
        mode = mode.toLowerCase(); // Режим работы (encode или decode)
        text = text.toUpperCase(); // Преобразуем входную строку в верхний регистр
        String result = ""; // Создаем пустую строку для результата

        // Проходим по каждому символу во входном сообщении text
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) { // Проверяем, является ли символ буквой
                char shiftedChar;

                if (mode.equals("decode")) {
                    // Для режима дешифрования выполняем обратный сдвиг
                    shiftedChar = (char) ((c - 'A' - shift + 26) % 26 + 'A'); // Работа с ASCII-кодами символов
                } else {
                    // Для режима шифрования выполняем сдвиг
                    shiftedChar = (char) ((c - 'A' + shift) % 26 + 'A');
                }
                result += shiftedChar;
            } else {
                // Если символ не является буквой, оставляем его без изменений
                result += c;
            }
        }

        return result;
    }


    public static int setSetup(int n, int k) {
        // Если k равно 0, есть только один способ - ничего не размещать.
        if (k == 0) {
            return 1;
        }

        // Используем формулу для размещений без повторений
        return n * setSetup(n - 1, k - 1);
    }


    public static String getTimeZone(String city) {
        switch (city) {
            // Для каждого города возвращается соответствующая временная зона
            case "Los Angeles":
                return "GMT-8:00";
            case "New York":
                return "GMT-5:00";
            case "Caracas":
                return "GMT-4:30";
            case "Buenos Aires":
                return "GMT-3:00";
            case "London":
                return "GMT";
            case "Rome":
                return "GMT+1:00";
            case "Moscow":
                return "GMT+3:00";
            case "Tehran":
                return "GMT+3:30";
            case "New Delhi":
                return "GMT+5:30";
            case "Beijing":
                return "GMT+8:00";
            case "Canberra":
                return "GMT+10:00";
            default:
                return "GMT"; // По умолчанию, если город не найден
        }
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        // Форматирование временной метки
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm");

        // Разбиение временной метки на составляющие (месяц, день, год, время)
        String[] parts = timestamp.split(" ");
        String month = parts[0];
        int day = Integer.parseInt(parts[1].replace(",", ""));
        int year = Integer.parseInt(parts[2]);
        String time = parts[3];

        // Разбиение времени на часы и минуты
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);

        // Создание объекта Date на основе разобранных данных
        Date date = new Date(year - 1900, getMonthNumber(month), day, hours, minutes);

        // Получение временных зон для двух городов
        String timeZoneA = getTimeZone(cityA);
        String timeZoneB = getTimeZone(cityB);

        // Вычисление смещений времени для обоих городов
        int offsetA = extractTimeOffset(timeZoneA);
        int offsetB = extractTimeOffset(timeZoneB);

        // Корректировка времени на разницу в смещениях
        date.setTime(date.getTime() + (offsetB - offsetA));

        // Возвращение отформатированной даты и времени
        return outputFormat.format(date);
    }

    // Метод для получения номера месяца по его названию
    public static int getMonthNumber(String month) {
        // Массив с названиями месяцев
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        // Поиск номера месяца в массиве
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(month)) {
                return i;
            }
        }
        return 0; // По умолчанию, если месяц не найден
    }

    // Метод для извлечения временного смещения из строки временной зоны
    public static int extractTimeOffset(String timeZone) {
        int hours = 0;
        int minutes = 0;
        int indexPlus = timeZone.indexOf('+');
        int indexMinus = timeZone.indexOf('-');

        // Обработка случая положительного смещения
        if (indexPlus != -1) {
            String[] parts = timeZone.substring(indexPlus + 1).split(":");
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
        }
        // Обработка случая отрицательного смещения
        else if (indexMinus != -1) {
            String[] parts = timeZone.substring(indexMinus + 1).split(":");
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
            hours = -hours;
            minutes = -minutes;
        }

        // Возвращение временного смещения в миллисекундах
        return (hours * 60 + minutes) * 60000;
    }


    public static boolean isNew(int num) {
        // Преобразуем число в строку
        String numStr = Integer.toString(num);

        // Преобразуем строку в массив символов и сортируем его
        char[] charArray = numStr.toCharArray();
        Arrays.sort(charArray);

        // Создаем строку из отсортированных символов
        String sortedStr = new String(charArray);

        // Проверяем, что в отсортированной строке отсутствуют ведущие нули
        if (sortedStr.charAt(0) == '0') {
            return true;
        }

        // Сравниваем исходную строку и отсортированную строку
        return numStr.equals(sortedStr);
    }
}