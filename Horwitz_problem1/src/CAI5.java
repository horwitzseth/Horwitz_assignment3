import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
    static SecureRandom rand = new SecureRandom();
    static Scanner scan = new Scanner(System.in);
    static int num1, num2, ans, diff, type, typeRand;
    static double correct = 0;

    static void readDifficulty () {
        diff = scan.nextInt();
    }

    static void readProblemType () {
        type = scan.nextInt();
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
        if ((type == 4 || typeRand == 4) && num2 == 0) {
            switch (diff) {
                case 1:
                    num2 = rand.nextInt(9) + 1;
                    break;
                case 2:
                    num2 = rand.nextInt(99) + 1;
                    break;
                case 3:
                    num2 = rand.nextInt(999) + 1;
                    break;
                case 4:
                    num2 = rand.nextInt(9999) + 1;
                    break;
            }
        }
    }

    static void readResponse () {
        ans = scan.nextInt();
    }

    static void askQuestion () {
        switch (type) {
            case 1:
                System.out.print("How much is " + num1 + " plus " + num2 + "? ");
                break;
            case 2:
                System.out.print("How much is " + num1 + " times " + num2 + "? ");
                break;
            case 3:
                System.out.print("How much is " + num1 + " minus " + num2 + "? ");
                break;
            case 4:
                System.out.print("How much is " + num1 + " divided by " + num2 + " (rounded down to integer)? ");
                break;
            case 5:
                typeRand = rand.nextInt(3) + 1;
                switch (typeRand) {
                    case 1:
                        System.out.print("How much is " + num1 + " plus " + num2 + "? ");
                        break;
                    case 2:
                        System.out.print("How much is " + num1 + " times " + num2 + "? ");
                        break;
                    case 3:
                        System.out.print("How much is " + num1 + " minus " + num2 + "? ");
                        break;
                    case 4:
                        System.out.print("How much is " + num1 + " divided by " + num2 + "(rounded down to integer)? ");
                        break;
                }
                break;
        }
        readResponse();
    }


    static boolean isAnswerCorrect () {
        int sol = 0;
        switch (type) {
            case 1:
                sol = num1 + num2;
                break;
            case 2:
                sol = num1 * num2;
                break;
            case 3:
                sol = num1 - num2;
                break;
            case 4:
                sol = num1 / num2;
                break;
            case 5:
                switch (typeRand) {
                    case 1:
                        sol = num1 + num2;
                        break;
                    case 2:
                        sol = num1 * num2;
                        break;
                    case 3:
                        sol = num1 - num2;
                        break;
                    case 4:
                        sol = num1 / num2;
                        break;
                }
                break;
        }
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
            System.out.print("Please enter a problem type of (1) addition, (2) multiplication, (3) subtraction, (4) division, (5) mixture: ");
            readProblemType();
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
