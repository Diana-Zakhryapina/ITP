package Lab6;

// Класс для представления проданного товара
class SaleItem {
    private String name;   // Наименование товара
    private double price;  // Цена товара

    // Конструктор для создания экземпляра SaleItem
    public SaleItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Метод для получения наименования товара
    public String getName() {
        return name;
    }

    // Метод для получения цены товара
    public double getPrice() {
        return price;
    }
}