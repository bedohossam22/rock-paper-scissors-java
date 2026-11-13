import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // --- Start / Restart a new game session ---
            System.out.println("\n=== Rock Paper Scissors ===");
            System.out.println("Type rock, paper, or scissors to play.");
            System.out.println("Type 'restart' to start over or 'exit' to quit.");

            int playerScore = 0;
            int aiScore    = 0;
            int rounds     = 0;

            // Inner loop: one game session
            while (true) {
                System.out.print("\nYour move: ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("\nThanks for playing! Final score — You: " + playerScore + " | AI: " + aiScore);
                    scanner.close();
                    return;
                }

                if (input.equalsIgnoreCase("restart")) {
                    System.out.println("\nRestarting game...");
                    break; // breaks inner loop → outer loop restarts a fresh session
                }

                // Validate input
                if (!input.equalsIgnoreCase("rock") &&
                    !input.equalsIgnoreCase("paper") &&
                    !input.equalsIgnoreCase("scissors")) {
                    System.out.println("Invalid choice. Please type rock, paper, or scissors.");
                    continue;
                }

                // Generate AI choice
                int randomNum = (int) (Math.random() * 3);
                String aiChoice;
                if      (randomNum == 0) aiChoice = "rock";
                else if (randomNum == 1) aiChoice = "paper";
                else                     aiChoice = "scissors";

                System.out.println("AI chose: " + aiChoice);
                rounds++;

                // Determine result
                if (aiChoice.equalsIgnoreCase(input)) {
                    System.out.println("Draw!");
                } else if (
                    (aiChoice.equals("rock")     && input.equalsIgnoreCase("paper"))    ||
                    (aiChoice.equals("paper")    && input.equalsIgnoreCase("scissors")) ||
                    (aiChoice.equals("scissors") && input.equalsIgnoreCase("rock"))
                ) {
                    System.out.println("Player wins!");
                    playerScore++;
                } else {
                    System.out.println("AI wins!");
                    aiScore++;
                }

                System.out.println("Score — You: " + playerScore + " | AI: " + aiScore + " (Round " + rounds + ")");
            }
        }
    }
}
