package Lab4;

public class ArrayAverage {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка: Выход за границы массива");
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверные данные");
        } finally {
            System.out.println(sum / arr.length);
        }
    }
}
