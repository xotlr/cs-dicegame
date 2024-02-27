package dice.game.project;

import java.util.Random;
import javax.swing.JOptionPane;

public class DiceGame {

    public static int cashPoints = 100;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the OddEvenDiceGame\n"
                + "------------------------------\n"
                + "The Rules are:\n"
                + "\nYou will start with 100 points. You will be asked to "
                + "place a bet from your available points.\n"
                + "\nThen two dice will be rolled.\n"
                + "\nIf the sum of the two dice "
                + "is an odd number, you will win double your bet! "
                + "\nIf the sum of the two dice is an even number, you will lose your bet.\n"
                + "\nThen if you still have points left, you will be asked to play again!");
        game();
    }

    public static void game() {
        while (cashPoints > 0) {
            String input = JOptionPane.showInputDialog(null, "You have " + cashPoints + " cash points\n"
                    + "Do you want to play (again)? (y/n)");

            if ("n".equalsIgnoreCase(input)) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!");
                System.exit(0);
            } else if (!"y".equalsIgnoreCase(input)) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'y' to play or 'n' to exit.");
                continue;
            }

            int bet;
            try {
                bet = Integer.parseInt(JOptionPane.showInputDialog(null, "Cash Points: " + cashPoints + "\n"
                        + "Please enter betting amount: "));
                if (bet < 0 || bet > cashPoints) {
                    JOptionPane.showMessageDialog(null, "Invalid bet amount. Please bet an amount between 1 and " + cashPoints + ".");
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric bet amount.");
                continue;
            }

            Random r = new Random();
            int dice1 = r.nextInt(6) + 1;
            int dice2 = r.nextInt(6) + 1;
            int sum = dice1 + dice2;

            if (sum % 2 != 0) {
                cashPoints += bet;
                JOptionPane.showMessageDialog(null, "The roll was " + dice1 + " and " + dice2 + "\n"
                        + "Sum: " + sum + "\n"
                        + "You win! Your cash increased to " + cashPoints);
            } else {
                cashPoints -= bet;
                JOptionPane.showMessageDialog(null, "The roll was " + dice1 + " and " + dice2 + "\n"
                        + "Sum: " + sum + "\n"
                        + "You lose! Your cash decreased to " + cashPoints);
            }
        }
        JOptionPane.showMessageDialog(null, "You've run out of cash points! Game over.");
    }
}

