package Lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


// Класс для учета продаж в магазине
public class SalesManager {
    private List<SaleItem> salesList;  // Список проданных товаров

    // Конструктор класса SalesManager
    public SalesManager() {
        salesList = new ArrayList<>();
    }

    // Метод для добавления проданного товара в список
    public void addSaleItem(String name, double price) {
        SaleItem saleItem = new SaleItem(name, price);
        salesList.add(saleItem);
    }

    // Метод для вывода списка проданных товаров
    public void displaySales() {
        System.out.println("Список проданных товаров:");
        for (SaleItem saleItem : salesList) {
            System.out.println(saleItem.getName() + ": " + saleItem.getPrice());
        }
    }

    // Метод для вычисления общей суммы продаж
    public double calculateTotalSales() {
        double totalSales = 0;
        for (SaleItem saleItem : salesList) {
            totalSales += saleItem.getPrice();
        }
        return totalSales;
    }

    // Метод для поиска наиболее популярного товара
    public String findMostPopularItem() {
        Map<String, Integer> itemFrequency = new HashMap<>();

        // Подсчитываем частоту каждого товара
        for (SaleItem saleItem : salesList) {
            String itemName = saleItem.getName();
            itemFrequency.put(itemName, itemFrequency.getOrDefault(itemName, 0) + 1);
        }

        // Находим товар с наибольшей частотой
        String mostPopularItem = null;
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : itemFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostPopularItem = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        return mostPopularItem;
    }

    // Метод для демонстрации использования класса
    public static void main(String[] args) {
        SalesManager salesManager = new SalesManager();
        Scanner scanner = new Scanner(System.in);

        // Пример использования
        salesManager.addSaleItem("Товар1", 50.0);
        salesManager.addSaleItem("Товар2", 30.0);
        salesManager.addSaleItem("Товар1", 50.0); // Добавляем еще один Товар1
        salesManager.addSaleItem("Товар3", 20.0);

        // Выводим список проданных товаров
        salesManager.displaySales();

        // Выводим общую сумму продаж
        System.out.println("Общая сумма продаж: " + salesManager.calculateTotalSales());

        // Выводим наиболее популярный товар
        String mostPopularItem = salesManager.findMostPopularItem();
        System.out.println("Наиболее популярный товар: " + mostPopularItem);
    }
}
