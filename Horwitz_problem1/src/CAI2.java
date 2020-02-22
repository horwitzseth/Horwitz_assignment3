import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
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
        int comment = rand.nextInt(4) + 1;
        switch(comment) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
        System.exit(1);
    }

    static void displayIncorrectResponse () {
        int comment = rand.nextInt(4) + 1;
        switch(comment) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
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
