package Lab5;

import java.util.Scanner;
import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        // Запрашиваем у пользователя ввод текста
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: "); // Я в своем познании настолько преисполнился, что я как будто бы уже сто триллионов миллиардов лет проживаю на триллионах и триллионах таких же планет, как эта Земля, мне этот мир абсолютно понятен, и я здесь ищу только одного - покоя, умиротворения и вот этой гармонии, от слияния с бесконечно вечным, от созерцания великого фрактального подобия и от вот этого замечательного всеединства существа, бесконечно вечного, куда ни посмотри, хоть вглубь - бесконечно малое, хоть ввысь - бесконечное большое, понимаешь?
        String text = scanner.nextLine();

        // Запрашиваем у пользователя ввод буквы
        System.out.print("Введите букву для поиска слов: ");
        String startingLetter = scanner.next().toLowerCase(); // Преобразуем ввод в нижний регистр

        // Вызываем метод findWords для поиска и вывода слов
        try {
            findWords(text, startingLetter);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void findWords(String text, String startingLetter) {
        // Регулярное выражение для поиска слов, начинающихся с заданной буквы
        String regex = "\\b" + startingLetter + "(\\p{L}*)?\\b";

        // Создаем объект Pattern для работы с регулярным выражением
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);

        // Создаем объект Matcher для работы с текстом по заданному шаблону
        Matcher matcher = pattern.matcher(text);

        // Перебираем все совпадения в тексте
        while (matcher.find()) {
            // Выводим найденное слово
            System.out.println(matcher.group());
        }
    }
}
