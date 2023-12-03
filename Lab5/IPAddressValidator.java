package Lab5;

import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ipAddress = "2000.168.0.1";

        try {
            validateIPAddress(ipAddress);
            System.out.println("IP-адрес " + ipAddress + " корректен.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void validateIPAddress(String ipAddress) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)" +
                "{3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");

        // Создаем объект Matcher для проверки соответствия IP-адреса регулярному выражению
        Matcher matcher = pattern.matcher(ipAddress);

        // Проверяем, соответствует ли IP-адрес заданному шаблону
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Некорректный формат IP-адреса: " + ipAddress);
        }

        // Проверяем, что каждое число в диапазоне от 0 до 255
        String[] octets = ipAddress.split("\\.");
        for (String octet : octets) {
            int num = Integer.parseInt(octet);
            if (num < 0 || num > 255) {
                throw new IllegalArgumentException("Число в IP-адресе должно быть в диапазоне от 0 до 255. Вы ввели: " + ipAddress);
            }
        }
    }
}
