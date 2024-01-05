package tasks;

public class tasks1 {
    public static void main(String[] args) {
        System.out.println(convert(5)); // 18.925
        System.out.println(convert(3)); // 11.355
        System.out.println(convert(8)); // 30.28

        System.out.println(fitCalc(15, 1)); // 15
        System.out.println(fitCalc(24, 2)); // 48
        System.out.println(fitCalc(41, 3)); // 123

        System.out.println(containers(3, 4, 2)); // 460
        System.out.println(containers(5, 0, 2)); // 300
        System.out.println(containers(4, 1, 4)); // 530

        System.out.println(triangleType(5, 5, 5)); // isosceles
        System.out.println(triangleType(5, 4, 5)); // equilateral
        System.out.println(triangleType(3, 4, 5)); // different-sided
        System.out.println(triangleType(5, 1, 1)); // not a triangle

        System.out.println(ternaryEvaluation(8, 4)); // 8
        System.out.println(ternaryEvaluation(1, 11)); // 11
        System.out.println(ternaryEvaluation(5, 9)); // 9

        System.out.println(howManyItems(22, 1.4, 2)); // 3
        System.out.println(howManyItems(45, 1.8, 1.9)); // 6
        System.out.println(howManyItems(100, 2, 2)); // 12

        System.out.println(factorial(3)); // 6
        System.out.println(factorial(5)); // 120
        System.out.println(factorial(7)); // 5040

        System.out.println(gcd(48, 18)); // 6
        System.out.println(gcd(52, 8)); // 4
        System.out.println(gcd(259, 28)); // 7

        System.out.println(ticketSaler(70, 1500)); // 75600
        System.out.println(ticketSaler(24, 950)); // 16416
        System.out.println(ticketSaler(53, 1250)); // 47700

        System.out.println(tables(5, 2)); // 1
        System.out.println(tables(31, 20)); // 0
        System.out.println(tables(123, 58)); // 4


    }


    public static float convert(int gallons) {
        // Коэффициент для преобразования галлонов в литры
        float gallonsToLiters = 3.785f;
        return (float) (Math.round(gallons * gallonsToLiters * 1000.0) / 1000.0);
    }


    public static int fitCalc(int minutes, int intensity) {
        return minutes * intensity; // Возвращаем кол-во калорий
    }


    public static int containers(int boxes, int bags, int barrels) {
        return ((boxes * 20) + (bags * 50) + (barrels * 100)); // Возвращаем общее количество товаров
    }


    public static String triangleType(int x, int y, int z) {
        // Проверяем, является ли треугольником или нет
        if (x <= 0 || y <= 0 || z <= 0 || (x + y <= z) || (y + z <= x) || (z + x <= y)) {
            return "not a triangle"; // Если не является треугольником, возвращаем "не треугольник"
        } else if (x == y & y == z & x == z) {
            return "isosceles"; // Если все стороны равны, возвращаем "равносторонний треугольник"
        } else if (x == y || y == z || x == z) {
            return "equilateral"; // Если две стороны равны, возвращаем "равнобедренный треугольник"
        } else {
            return "different-sided"; // Во всех остальных случаях возвращаем "разносторонний треугольник"
        }
    }


    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b; // Если a больше b, то выводим a, иначе b
    }


    public static int howManyItems(double n, double w, double h) {
        return (int) Math.floor(n / (w * h * 2));
    }


    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            // Факториал 0 равен 1
            return 1;
        } else if (n > 0){
            long result = n;
            for (int i = n - 1; i > 1; i--) {
                result *= i;
            }
            return result;
        }
        return 0; // Если число < 0, выведем значение по умолчанию
    }


    public static int gcd(int a, int b) {
        // Используем алгоритм Евклида для нахождения НОД
        while (b != 0) {
            int temp = b; // Временная переменная для хранения значения b
            b = a % b; // Вычисляем остаток от деления a на b и присваиваем его b
            a = temp; // Присваиваем a значение временной переменной temp
        }
        return a; // Возвращаем наибольший общий делитель (НОД)
    }


    public static int ticketSaler(int numberOfTickets, int ticketPrice) {
        double discount = 0.28; // 28% комиссия
        double totalRevenue = numberOfTickets * ticketPrice * (1 - discount); // Вычисление общей выручки с учетом комиссии
        return (int) totalRevenue; // Возвращаем общую выручку в виде целого числа
    }


    public static int tables(int numberOfStudents, int numberOfDesks) {
        // Вычисляем количество нехватки столов для студентов
        int desksNeeded = (numberOfStudents + 1) / 2; // Для округления в большую сторону добавляем 1 перед делением
        int missingTables = desksNeeded - numberOfDesks; // Вычисляем разницу между необходимым и имеющимся количеством столов
        return missingTables > 0 ? missingTables : 0; // Если desksShort < 0, то возвращаем 0 (нехватки нет)
    }
}




