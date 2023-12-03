package Lab2;

public abstract class Monster {
    private int health;
    private int armor;
    private int damage;
    private static int monsterCount = 0;  // Статическая переменная для подсчета созданных объектов

    Monster(int health, int armor, int damage) {
        this.health = health;
        this.armor = armor;
        this.damage = damage;
        monsterCount++;
    }

    Monster(int count) {
        this(count, count, count);
    }

    Monster() {
        this(100, 100, 50);
    }

    // Геттеры и сеттеры
    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void printInfo() {
        System.out.println("Запас здоровья: " + health + "\n" +
                "Запас щита: " + armor + "\n" +
                "Наносимый урон: " + damage);
    }

    // Абстрактный метод для описания поведения объекта
    public abstract void performAction();

    void voice() {
        voice(1);
    }

    void voice(int count) {
        voice(count, "Grrrrrrrr...");
    }

    void voice(int count, String phrase) {
        for (int i = 0; i < count; i++) {
            System.out.println(phrase);
        }
    }

    // Статический метод для получения количества созданных объектов
    public static int getMonsterCount() {
        return monsterCount;
    }
}