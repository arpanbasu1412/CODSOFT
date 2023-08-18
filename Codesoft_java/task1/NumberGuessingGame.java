import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + (rounds + 1) + ": Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Round " + (rounds + 1) + ": Sorry, you couldn't guess the number " + targetNumber + " within " + maxAttempts + " attempts.");
            }

            rounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Game Over! Your final score: " + score + " rounds won.");
        scanner.close();
    }
}
