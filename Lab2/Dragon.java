package Lab2;

public class Dragon extends Monster {
    private int fireBreathPower;

    public Dragon(int health, int armor, int damage, int fireBreathPower) {
        super(health, armor, damage);
        this.fireBreathPower = fireBreathPower;
    }

    public Dragon(int count, int fireBreathPower) {
        super(count);
        this.fireBreathPower = fireBreathPower;
    }

    public Dragon() {
        super();
        this.fireBreathPower = 20; // Пример значения по умолчанию для силы огненного дыхания дракона
    }

    public int getFireBreathPower() {
        return fireBreathPower;
    }

    public void setFireBreathPower(int fireBreathPower) {
        this.fireBreathPower = fireBreathPower;
    }

    public void printInfoDragon() {
        System.out.println("Запас здоровья дракона: " + getHealth() + "\n" +
                "Запас щита дракона: " + getArmor() + "\n" +
                "Сила огненного дыхания дракона: " + fireBreathPower);
    }

    public void performAction() {
        System.out.println("Дракон получает 45 ед. урона!");
        if (getArmor() >= 45) {
            setArmor(getArmor() - 45);
        } else if (getHealth() >= 45) {
            setHealth(getHealth() - (45 - getArmor()));
            setArmor(0);
        } else {
            setHealth(0);
            setArmor(0);
            System.out.println("Дракон повержен!");
        }
    }

    public void breatheFire() {
        System.out.println("Дракон выпускает огонь с силой " + fireBreathPower);
    }
}