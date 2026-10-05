import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsWon = 0;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    System.out.println("Attempts used: " + attempts);

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;
                    roundsWon++;

                    System.out.println("Score for this round: " + score);
                    guessedCorrectly = true;
                    break;

                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");

                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ Game Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("\n===== CURRENT SCORE =====");
            System.out.println("Rounds won: " + roundsWon);
            System.out.println("Total score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n===== FINAL RESULT =====");
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Final score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}