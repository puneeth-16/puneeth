import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctOption; 

    Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        
        questions.add(new Question("What is the capital of India?", 
                                   new String[]{"Mumbai", "Delhi", "Chennai", "Kolkata"}, 2));
        questions.add(new Question("Which language is used for Android development?", 
                                   new String[]{"Java", "Python", "Swift", "PHP"}, 1));
        questions.add(new Question("What is 10 + 20?", 
                                   new String[]{"10", "20", "30", "40"}, 3));

        int score = 0;

        System.out.println("Welcome to the Quiz!\n");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1));
            questions.get(i).displayQuestion();
            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();

            if (questions.get(i).isCorrect(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was option " + questions.get(i).correctOption + "\n");
            }
        }

        System.out.println("Quiz finished!");
        System.out.println("Your Score: " + score + "/" + questions.size());

        scanner.close();
    }
}
