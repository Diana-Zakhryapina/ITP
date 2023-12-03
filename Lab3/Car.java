package Lab3;
public class Car {
    private String licensePlate; // Номерной знак
    private String make; // Марка
    private String model; // Модель
    private int year; // Год выпуска

    public Car(String licensePlate, String make, String model, int year) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Геттеры
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "Автомобиль [Номерной знак: " + licensePlate + ", Марка: " + make + ", Модель: " + model + ", Год выпуска: " + year + "]";
    }
}
