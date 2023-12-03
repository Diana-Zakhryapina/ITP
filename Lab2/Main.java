package Lab2;

public class Main {

    public static void main(String[] args) {
        // Создание объекта класса Goblin
        Goblin goblin = new Goblin(80, 15, 30,70 );

        // Создание объекта класса Mermaid
        Mermaid mermaid = new Mermaid(120, 10, 40, 3,90);

        // Создание объекта класса Dragon
        Dragon dragon = new Dragon(200, 30, 100, 120);

        // Вывод информации о созданных объектах
        goblin.printInfoGoblin();
        System.out.println();

        mermaid.printInfoMermaid();
        System.out.println();

        dragon.printInfoDragon();
        System.out.println();

        // Вызов методов для демонстрации поведения объектов
        goblin.performAction();
        mermaid.performAction();
        dragon.performAction();

        // Вызов дополнительных методов
        goblin.sneak();
        mermaid.healthUp();
        dragon.breatheFire();

        // Вызов перегруженного метода
        goblin.voice(6);

        // Вывод количества созданных объектов с использованием статической переменной
        System.out.println("Количество созданных монстров: " + Monster.getMonsterCount());
    }
}