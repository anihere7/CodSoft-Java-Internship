import java.util.Scanner;

public class QuizApplication {

    static Scanner sc = new Scanner(System.in);

    static String[] questions = {
        "Which language is mainly used for Android development?",
        "Which keyword is used to create a class in Java?",
        "Which method is the starting point of a Java program?",
        "Which data type is used to store whole numbers?",
        "Which symbol is used to end a Java statement?"
    };

    static String[][] options = {
        {"A. Java", "B. HTML", "C. CSS", "D. SQL"},
        {"A. class", "B. Class", "C. create", "D. object"},
        {"A. start()", "B. main()", "C. run()", "D. begin()"},
        {"A. double", "B. float", "C. int", "D. String"},
        {"A. :", "B. .", "C. ;", "D. ,"}
    };

    static char[] correctAnswers = {
        'A',
        'A',
        'B',
        'C',
        'C'
    };

    public static void main(String[] args) {

        int score = 0;
        int correct = 0;
        int incorrect = 0;

        System.out.println("================================");
        System.out.println("       JAVA QUIZ APPLICATION");
        System.out.println("================================");
        System.out.println("You have 10 seconds for each question.");
        System.out.println();

        for (int i = 0; i < questions.length; i++) {

            System.out.println("--------------------------------");
            System.out.println("Question " + (i + 1) + " of " + questions.length);
            System.out.println("--------------------------------");

            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.println();
            System.out.println("You have 10 seconds!");
            System.out.print("Enter your answer (A/B/C/D): ");

            long startTime = System.currentTimeMillis();

            String answer = sc.nextLine().trim().toUpperCase();

            long endTime = System.currentTimeMillis();

            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {
                System.out.println("Time's up! Answer not accepted.");
                System.out.println("Correct answer: " + correctAnswers[i]);
                incorrect++;
            } else if (answer.length() > 0
                    && answer.charAt(0) == correctAnswers[i]) {

                System.out.println("Correct answer!");
                score += 10;
                correct++;

            } else {
                System.out.println("Incorrect answer!");
                System.out.println("Correct answer: " + correctAnswers[i]);
                incorrect++;
            }

            System.out.println("Time taken: " + timeTaken + " seconds");
            System.out.println();
        }

        // Result Screen
        System.out.println("================================");
        System.out.println("          QUIZ RESULT");
        System.out.println("================================");

        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + correct);
        System.out.println("Incorrect Answers: " + incorrect);
        System.out.println("Final Score      : " + score + "/" + (questions.length * 10));

        double percentage = ((double) score / (questions.length * 10)) * 100;

        System.out.printf("Percentage       : %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Performance      : Excellent!");
        } else if (percentage >= 60) {
            System.out.println("Performance      : Good!");
        } else if (percentage >= 40) {
            System.out.println("Performance      : Average!");
        } else {
            System.out.println("Performance      : Needs Improvement!");
        }

        System.out.println("================================");
        System.out.println("Thank you for playing!");
    }
}
