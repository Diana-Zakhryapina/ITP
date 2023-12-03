package Lab3;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Car> carHashTable = new HashTable<>();

        // Создаем два объекта Car и вставляем их в хэш-таблицу
        Car car1 = new Car("A123BC", "Toyota", "Camry", 2020);
        Car car2 = new Car("X789YZ", "Honda", "Civic", 2021);
        carHashTable.put(car1.getLicensePlate(), car1);
        carHashTable.put(car2.getLicensePlate(), car2);

        // Выводим информацию об автомобилях по номерным знакам
        System.out.println("Автомобиль с номерным знаком A123BC: " + carHashTable.get("A123BC"));
        System.out.println("Автомобиль с номерным знаком X789YZ: " + carHashTable.get("X789YZ"));

        // Удаляем автомобиль со знаком A123BC и выводим информацию снова
        String carLicensePlate = "A123BC";
        carHashTable.remove(carLicensePlate);
        System.out.println("Автомобиль с номерным знаком " + carLicensePlate + " после удаления: " + carHashTable.get(carLicensePlate));

        // Выводим размер хэш-таблицы и проверяем, пуста ли она
        System.out.println("Размер carHashTable: " + carHashTable.size());
        System.out.println("Пуста ли carHashTable? - " + carHashTable.isEmpty());
    }
}
