import java.util.Random;
import java.util.Scanner;
public class GuessTheNumberGame {

    public static void main(String[] args) {
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 7;

        int score = 0;
        int roundsPlayed = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("🎯 Welcome to the Guess the Number Game!");
        System.out.println("You need to guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts per round.\n");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("🔁 Round " + (roundsPlayed + 1) + " starts!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + "): ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("📈 Too high!");
                } else {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempt(s)!");
                    score += (MAX_ATTEMPTS - attempts + 1); // More points for fewer attempts
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The number was: " + numberToGuess);
            }

            roundsPlayed++;
            System.out.println("🏆 Your current score: " + score);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\n🎉 Game Over! You played " + roundsPlayed + " round(s) and scored " + score + " point(s).");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
