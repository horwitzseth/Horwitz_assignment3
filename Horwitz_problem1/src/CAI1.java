import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
    static SecureRandom rand = new SecureRandom();
    static int num1 = rand.nextInt(10);
    static int num2 = rand.nextInt(10);
    static int ans;

    static void askQuestion () {
        System.out.print("How much is " + num1 + " times " + num2 + "? ");
        readResponse();
    }

    static void readResponse () {
        Scanner scan = new Scanner(System.in);
        ans = scan.nextInt();
    }

    static boolean isAnswerCorrect () {
        int sol = num1 * num2;
        if (sol == ans) {
            return true;
        }
        return false;
    }

    static void displayCorrectResponse () {
        System.out.println("Very good!");
        System.exit(1);
    }

    static void displayIncorrectResponse () {
        System.out.println("No. Please try again.");
    }

    static void quiz () {
        askQuestion();
        while (!isAnswerCorrect()) {
            displayIncorrectResponse();
            askQuestion();
        }
        displayCorrectResponse();
    }

    public static void main (String args[]) {
        quiz();
    }
}
