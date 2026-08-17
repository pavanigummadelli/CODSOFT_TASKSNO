import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static boolean timeUp = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "Q1: What is the capital of India?\n1) Delhi\n2) Mumbai\n3) Kolkata\n4) Chennai",
            "Q2: Who invented Java?\n1) James Gosling\n2) Dennis Ritchie\n3) Bjarne Stroustrup\n4) Guido van Rossum",
            "Q3: Which planet is known as the Red Planet?\n1) Earth\n2) Mars\n3) Jupiter\n4) Venus"
        };

        int[] answers = {1, 1, 2}; // correct options
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            // Timer for each question (10 seconds)
            timeUp = false;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp = true;
                    System.out.println("\n⏰ Time's up!");
                    timer.cancel();
                }
            }, 10000);

            int userAnswer = -1;
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
            }

            if (!timeUp && userAnswer == answers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else if (!timeUp) {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\n--- Quiz Finished ---");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }
}

