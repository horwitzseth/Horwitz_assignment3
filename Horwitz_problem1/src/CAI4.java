import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
    static SecureRandom rand = new SecureRandom();
    static Scanner scan = new Scanner(System.in);
    static int num1, num2, ans, diff;
    static double correct = 0;

    static void readDifficulty () {
        diff = scan.nextInt();
    }

    static void generateQuestionArgument () {
        switch (diff) {
            case 1:
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
                break;
            case 2:
                num1 = rand.nextInt(100);
                num2 = rand.nextInt(100);
                break;
            case 3:
                num1 = rand.nextInt(1000);
                num2 = rand.nextInt(1000);
                break;
            case 4:
                num1 = rand.nextInt(10000);
                num2 = rand.nextInt(10000);
                break;
        }
    }

    static void askQuestion () {
        System.out.print("How much is " + num1 + " times " + num2 + "? ");
        readResponse();
    }

    static void readResponse () {
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
        num1 = rand.nextInt(10);
        num2 = rand.nextInt(10);
    }
    static void displayCompletionMessage () {
        double score = correct / 10 * 100;
        System.out.println("Score: " + score + "%");
        if (score >= 75) {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        else {
            System.out.println("Please ask your teacher for extra help.");
        }
        correct = 0;
    }

    static void quiz () {
        boolean newQuiz = true;
        int quizAns;
        while (newQuiz) {
            System.out.print("Please enter a problem type of (1) 1 digit, (2) 2 digits, (3) 3 digits, (4) 4 digits: ");
            readDifficulty();
            generateQuestionArgument();
            for (int i = 0; i < 10; i++) {
                askQuestion();
                if (isAnswerCorrect()) {
                    displayCorrectResponse();
                    correct++;
                }
                else {
                    displayIncorrectResponse();
                }
                generateQuestionArgument();
            }
            displayCompletionMessage();
            System.out.print("Do you want to solve a new problem set? (yes = 1, no = 0) ");
            quizAns = scan.nextInt();
            if (quizAns == 0) {
                newQuiz = false;
            }
        }
    }

    public static void main (String args[]) {
        quiz();
    }
}
