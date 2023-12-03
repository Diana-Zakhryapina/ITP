package Lab2;

public class Mermaid extends Goblin {
    private int swimSpeed;

    public Mermaid(int health, int armor, int damage, int agility, int swimSpeed) {
        super(health, armor, damage, agility);
        this.swimSpeed = swimSpeed;
    }

    public Mermaid(int count, int agility, int swimSpeed) {
        super(count, agility);
        this.swimSpeed = swimSpeed;
    }

    public Mermaid() {
        super();
        this.swimSpeed = 10; // Пример значения по умолчанию для скорости плавания русалки
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public void printInfoMermaid() {
        System.out.println("Запас здоровья русалки: " + getHealth() + "\n" +
                "Запас щита русалки: " + getArmor() + "\n" +
                "Ловкость русалки: " + getAgility() + "\n" +
                "Скорость плавания русалки: " + swimSpeed);
    }

    public void performAction() {
        System.out.println("Русалка увеличивает урон на 30 ед.!");
        setDamage(getDamage() + 30);
    }

    public void healthUp() {
        System.out.println("Русалка восстанавливает здоровье до " + swimSpeed + " ед.");
    }
}