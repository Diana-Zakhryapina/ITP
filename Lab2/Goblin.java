package Lab2;

public class Goblin extends Monster {
    private int agility;

    public Goblin(int health, int armor, int damage, int agility) {
        super(health, armor, damage);
        this.agility = agility;
    }

    public Goblin(int count, int agility) {
        super(count);
        this.agility = agility;
    }

    public Goblin() {
        super();
        this.agility = 5; // Пример значения по умолчанию для ловкости гоблина
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void printInfoGoblin() {
        System.out.println("Запас здоровья гоблина: " + getHealth() + "\n" +
                "Запас щита гоблина: " + getArmor() + "\n" +
                "Наносимый урон гоблина: " + getDamage() + "\n" +
                "Ловкость гоблина: " + agility);
    }

    public void performAction() {
        System.out.println("Гоблин атакует и наносит " + getDamage() + " ед. урона!");
    }

    public void sneak() {
        System.out.println("Гоблин скрывается с уровнем хитрости " + agility + "!");
    }
}