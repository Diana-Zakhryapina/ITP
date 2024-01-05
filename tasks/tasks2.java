package tasks;

import java.security.SecureRandom;
import java.util.Arrays;

public class tasks2 {

            public static void main(String[] args) {
                System.out.println(duplicateChars("Donald"));
                System.out.println(getInitials("Ryan Gosling"));
                int[] arrayForDiff = {44, 32, 86, 19};
                System.out.println(differenceEvenOdd(arrayForDiff));
                int[] arrayForAverage = {1, 2, 3, 4, 5};
                System.out.println(equalToAvg(arrayForAverage));
                int[] arrayForIndexMult = {1, 2, 3};
                System.out.println(Arrays.toString(indexMult(arrayForIndexMult)));
                System.out.println(reverse("Hello World"));
                System.out.println(tribonacci(1));
                System.out.println(pseudoHash(25));
                System.out.println(botHelper("Hello, I’m under the water, he helps me"));
                System.out.println(areAnagrams("eleven plus two", "twelve plus one"));
            }

            // Функция, которая проверяет наличие повторяющихся символов в строке
            public static boolean duplicateChars(String str) {
                str = str.toLowerCase();
                for (int i = 0; i < str.length(); i++) {
                    for (int j = i + 1; j < str.length(); j++) {
                        // Если символы совпадают, значит, есть повторяющиеся символы
                        if (str.charAt(i) == str.charAt(j)) {
                            return true;
                        }
                    }
                }

                // Если мы дошли до этой точки, значит, повторяющихся символов нет
                return false;
            }

            public static String getInitials(String input) {
                String[] names = input.split(" "); // Разбиваем строку на слова по пробелу
                if (names.length >= 2) {
                    String lastNameInitial = names[0].substring(0, 1); // Получаем первую букву фамилии (делаем срез)
                    String firstNameInitial = names[1].substring(0, 1); // Получаем первую букву имени
                    return lastNameInitial + firstNameInitial;
                } else {
                    // Возвращаем пустую строку, если не удалось получить фамилию и имя
                    return "Введите данные корректно";
                }
            }

            public static int differenceEvenOdd(int[] input) {
                int evenNumbersSum = 0; // Переменная для суммы четных чисел
                int oddNumbersSum = 0; // Переменная для суммы нечетных чисел
                for (int i = 0; i < input.length; i++) {
                    int num = input[i];
                    if (num % 2 == 0) {
                        evenNumbersSum += num;
                    } else {
                        oddNumbersSum += num;
                    }
                }
                // Вычисляем разницу между суммой четных и суммой нечетных чисел
                return Math.abs(evenNumbersSum - oddNumbersSum);
            }

            public static boolean equalToAvg(int[] array) {  // Есть ли среди введенных чисел, их ср. арифм.
                double sum = 0;
                for (int i = 0; i < array.length; i++) {
                    double num = array[i];
                    sum += num;
                }
                double average = sum / array.length;
                for (int i = 0; i < array.length; i++) {
                    if (average == array[i]) {
                        return true;
                    }
                }
                return false;
            }

            public static int[] indexMult(int[] input) {
                for (int i = 0; i < input.length; i++) {
                    input[i] *= i;
                }
                return input;
            }

            public static String reverse(String input) { // Разворот строки
                String output = "";
                for (int i = input.length() - 1; i >= 0; i--) {
                    output += (input.charAt(i));
                }
                return output;
            }

            public static int tribonacci(int n) {
                int[] tribonacciArray = new int[n];
                if (n == 1 || n == 2) {
                    System.out.println(0);
                } else if (n == 3) {
                    System.out.println(1);
                } else {
                    tribonacciArray[0] = 0;
                    tribonacciArray[1] = 0;
                    tribonacciArray[2] = 1;

                    for (int i = 3; i < n; i++) {
                        tribonacciArray[i] = tribonacciArray[i - 1] + tribonacciArray[i - 2] + tribonacciArray[i - 3];
                    }
                }
                return tribonacciArray[n-1];
            }

            public static String pseudoHash(int length) {
                String characters = "0123456789abcdef";
                SecureRandom random = new SecureRandom(); // Создаем объект класса SecureRandom - генератор случайных чисел
                char[] randomChars = new char[length]; // Создаем массив символов

                for (int i = 0; i < length; i++) {
                    int randomIndex = random.nextInt(characters.length());
                    char randomChar = characters.charAt(randomIndex);
                    randomChars[i] = randomChar; // Заполняем массив случайными символами
                }

                return new String(randomChars);
            }

            public static String botHelper(String input) {
                // Преобразуем входную строку и ключевое слово "help" в нижний регистр для регистронезависимого поиска
                String lowerInput = input.toLowerCase();
                // Ищем ключевое слово в строке
                if (lowerInput.contains("help")) {
                    return "Calling for a staff member";
                } else {
                    return "Keep waiting";
                }
            }

            public static boolean areAnagrams(String input1, String input2) {
                // Преобразуем строки в массивы символов и отсортируем их
                char[] charArray1 = input1.toCharArray();
                char[] charArray2 = input2.toCharArray();
                Arrays.sort(charArray1); // вызовем метод sort из класса Arrays для сортировки массива
                Arrays.sort(charArray2);

                // Сравним отсортированные массивы символов
                boolean areAnagr = true;
                if (charArray1.length == charArray2.length) {  // Проверяем строки на одинаковую длину
                    for (int i = 0; i < charArray1.length; i++) {
                        if (charArray1[i] != charArray2[i]) {
                            areAnagr = false;
                            break;
                        }
                    }
                } else {
                    areAnagr = false;
                }
                return areAnagr;
            }
}

