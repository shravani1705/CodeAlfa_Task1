package studentgradetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentScores = new ArrayList<>();

        System.out.println("===== Student Grade Tracker =====");

        System.out.print("Enter number of students: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.close();
            return;
        }

        int n = sc.nextInt();
        sc.nextLine();

        if (n <= 0) {
            System.out.println("No students to process.");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Score: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid score! Enter a numeric score: ");
                sc.next();
            }

            int score = sc.nextInt();
            sc.nextLine();

            studentNames.add(name);
            studentScores.add(score);
        }

        int total = 0;
        int highest = studentScores.get(0);
        int lowest = studentScores.get(0);

        for (int score : studentScores) {

            total += score;

            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }
        double average = (double) total / studentScores.size();

        System.out.println("\n===== Summary Report =====");

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(
                    studentNames.get(i) + " : " + studentScores.get(i));
        }

        System.out.println("\nAverage Score : " + average);
        System.out.println("Highest Score : " + highest);
        System.out.println("Lowest Score  : " + lowest);

        sc.close();
    }
}
