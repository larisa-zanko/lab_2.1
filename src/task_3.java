//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Задание . Вывести номера столбцов, все элементы которых четны.
// Для столбцов, элементы которых на главной диагонали отрицательны,
// вывести номер столбца и сумму элементов этого столбца.

public class task_3{
    // Заполнение матрицы случайными значениями
    public static void matrixCreate(Integer[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100) - 50; // Генерация чисел от -50 до 49
            }
        }
    }

    // Вывод матрицы на экран
    public static void matrixPrint(Integer[][] matr) {
        System.out.println("Матрица:");
        for (Integer[] row : matr) {
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество строк в матрице: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Ошибка ввода, n должно быть натуральным");
            return;
        }

        System.out.println("Введите количество столбцов в матрице: ");
        int m = sc.nextInt();
        if (m <= 0) {
            System.out.println("Ошибка ввода, m должно быть натуральным");
            return;
        }
        Integer[][] matr = new Integer[n][m];
        matrixCreate(matr);
        matrixPrint(matr);

        // Вывод номеров столбцов, все элементы которых четны
        System.out.print("Номера столбцов с всеми чётными элементами: ");
        boolean anyEvenColumns = false;

        for (int j = 0; j < m; j++) {
            boolean allEven = true; // Флаг для текущего столбца
            for (int i = 0; i < n; i++) {
                if (matr[i][j] % 2 != 0) {
                    allEven = false; // Найден нечетный элемент
                    break;
                }
            }
            if (allEven) {
                System.out.print((j + 1) + " "); // Вывод номера столбца
                anyEvenColumns = true;
            }
        }
        if (!anyEvenColumns) {
            System.out.print("нет таких столбцов");
        }
        System.out.println();

        // Вывод номеров столбцов с отрицательными элементами на главной диагонали
        System.out.println("Столбцы с отрицательными элементами на главной диагонали:");

        for (int j = 0; j < Math.min(n, m); j++) {
            if (matr[j][j] < 0) { // Проверяем элемент на главной диагонали
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += matr[i][j]; // Суммируем элементы столбца
                }
                System.out.println("Столбец " + (j + 1) + ": сумма элементов = " + sum);
            }
        }


        // Если не нашлось ни одного столбца с отрицательными элементами на диагонали
        if (Math.min(n, m) == 0 || matr[0][0] >= 0) {
            System.out.println("нет столбцов с отрицательными элементами на главной диагонали");
        }
        sc.close(); // Закрываем сканер
    }
}