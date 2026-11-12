import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose Rock / paper or scissors");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1. Read input inside the loop
            String input = scanner.nextLine();

            // Wait! If they type "exit", break the loop.
            // (I added .toLowerCase() so "Rock" and "rock" both work)
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // 2. Generate AI choice
            int randomNum = (int) (Math.random() * 3);
            String aiChoice = "";

            if (randomNum == 0) {
                aiChoice = "rock";
            } else if (randomNum == 1) {
                aiChoice = "paper";
            } else {
                aiChoice = "scissors";
            }

            System.out.println("AI chose: " + aiChoice);

            // 3. Compare using ELSE IF
            if (aiChoice.equalsIgnoreCase(input)) {
                System.out.println("Draw");
            }
            else if (aiChoice.equals("rock") && input.equalsIgnoreCase("paper")) {
                System.out.println("Player wins");
            }
            else if (aiChoice.equals("paper") && input.equalsIgnoreCase("scissors")) {
                System.out.println("Player wins");
            }
            else if (aiChoice.equals("scissors") && input.equalsIgnoreCase("rock")) {
                System.out.println("Player wins");
            }
            else {
                // If it's not a draw, and the player didn't win, AI wins.
                System.out.println("Ai wins");
            }
        }

        scanner.close();
    }
}

