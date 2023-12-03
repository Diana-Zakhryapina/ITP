package Lab5;

import java.util.regex.*;

public class LinkReplacer {
    public static void main(String[] args) {
        // Пример текста со ссылками
        String text = "Visit our website at www.example.com. For more info, check out example.org or ftp://file-server.";

        // Вызываем метод replaceLinks для замены ссылок на гиперссылки
        try {
            String replacedText = replaceLinks(text);
            System.out.println(replacedText);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static String replaceLinks(String text) {
        // Регулярное выражение для поиска ссылок с протоколами, www. и без
        Pattern pattern = Pattern.compile("\\b(?:https?|ftp)://\\S+\\b|\\bwww\\.\\S+\\b|\\b\\S+\\.\\S+\\b");

        // Создаем объект Matcher для работы с текстом
        Matcher matcher = pattern.matcher(text);

        // Заменяем найденные ссылки на гиперссылки
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            // Проверяем, есть ли уже протокол в найденной ссылке
            String linkWithoutProtocol = matcher.group();
            if (!linkWithoutProtocol.startsWith("http://") && !linkWithoutProtocol.startsWith("https://")
                    && !linkWithoutProtocol.startsWith("ftp://")) {
                linkWithoutProtocol = "http://" + linkWithoutProtocol;
            }
            matcher.appendReplacement(result, linkWithoutProtocol);
        }
        matcher.appendTail(result);

        // Возвращаем измененный текст
        return result.toString();
    }
}
