import java.util.Scanner;

public class Calculator {
    private static int sumCurrentLevel;
    private static int sumNewLevel;
    private static int currentLevel;
    private static boolean error = false;

    Calculator() {
        calculator();
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);

        sumCurrentLevel = currentLevel(scanner, sumCurrentLevel);
        sumNewLevel = newLevel(scanner, sumNewLevel);

        if (error) {
            System.out.println("Invalid input! Current level >= 13 and new level >= current level!");
        } else {
            System.out.println("You need " + (sumNewLevel - sumCurrentLevel) + " souls!");
        }
    }

    private static int currentLevel(Scanner scanner, int sumCurrentLevel) {
        System.out.println("Type in your current level");
        currentLevel = scanner.nextInt();

        if (currentLevel < 13) {
            error = true;
            return 0;
        } else {
            for (int i = 13; i <= currentLevel; i++) {
                sumCurrentLevel += ((0.02 * PowerFunction(i, 3)) + (3.06 * PowerFunction(i, 2)) + (105.6 * i) - 895); //function works at level 13.
            }
            return sumCurrentLevel;
        }
    }

    private static int newLevel(Scanner scanner, int sumNewLevel) {
        System.out.println("Type in your level you want to reach");
        int newLevel = scanner.nextInt();

        if (newLevel < currentLevel) {
            error = true;
            return 0;
        } else {
            for (int i = 13; i <= newLevel; i++) {
                sumNewLevel += ((0.02 * PowerFunction(i, 3)) + (3.06 * PowerFunction(i, 2)) + (105.6 * i) - 895); //function works at level 13.
            }

            return sumNewLevel;
        }
    }

    private static double PowerFunction(int base, int exponent) {
        double result = 1;

        for (int i = 0; i < exponent; i++) {
            result = base * result;
        }

        return result;
    }
}
