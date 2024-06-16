import java.util.Scanner;

public class GradeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the grades of the students separated by space:");
        String input = scanner.nextLine();
        String[] gradesStr = input.split(" ");
        int N = gradesStr.length;
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(gradesStr[i]);
        }

        int maxGrade = Integer.MIN_VALUE;
        int minGrade = Integer.MAX_VALUE;
        double total = 0;
        int[] stats = new int[5];

        for (int score : scores) {
            if (score > maxGrade) maxGrade = score;
            if (score < minGrade) minGrade = score;
            total += score;

            if (score >= 81) stats[4]++;
            else if (score >= 61) stats[3]++;
            else if (score >= 41) stats[2]++;
            else if (score >= 21) stats[1]++;
            else stats[0]++;
        }

        double average = total / N;

        System.out.println("Values:");
        System.out.println("The maximum grade is " + maxGrade);
        System.out.println("The minimum grade is " + minGrade);
        System.out.println("The average grade is " + String.format("%.6f", average));

        System.out.println("\nGraph:");
        int maxFrequency = 0;
        for (int stat : stats) {
            if (stat > maxFrequency) {
                maxFrequency = stat;
            }
        }
        for (int i = maxFrequency; i > 0; i--) {
            System.out.print(" " + i + "  > ");
            for (int j = 0; j < 5; j++) {
                if (stats[j] >= i) {
                    System.out.print("#######   ");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }
        System.out.println("    +-----------+---------+---------+---------+---------+");
        System.out.println("    I    0-20   I  21-40  I  41-60  I  61-80  I  81-100 I");
    }
}
