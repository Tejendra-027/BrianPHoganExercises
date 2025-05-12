import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TriviaGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = loadQuestionsFromFile("C:/Users/tejen/Desktop/git demo/BrianPHoganExercises/55_TriviaApp/questions.txt");
        if (questions.isEmpty()) {
            System.out.println("No questions found. Exiting.");
            return;
        }

        Collections.shuffle(questions);
        int score = 0;

        for (Question question : questions) {
            System.out.println("\n" + question.question);
            List<String> allAnswers = new ArrayList<>(question.distractors);
            allAnswers.add(question.answer);
            Collections.shuffle(allAnswers);

            for (int i = 0; i < allAnswers.size(); i++) {
                System.out.printf("%d) %s\n", i + 1, allAnswers.get(i));
            }

            System.out.print("Your answer (1-" + allAnswers.size() + "): ");
            int choice = scanner.nextInt();

            if (allAnswers.get(choice - 1).equals(question.answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question.answer);
                break;
            }
        }

        System.out.println("\nGame over! Your score: " + score);
    }

    static List<Question> loadQuestionsFromFile(String filename) {
        List<Question> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String q = line.trim();
                String a = reader.readLine().trim();
                List<String> d = new ArrayList<>();
                d.add(reader.readLine().trim());
                d.add(reader.readLine().trim());
                d.add(reader.readLine().trim());

                questions.add(new Question(q, a, d));
                reader.readLine(); // Skip blank line
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return questions;
    }

    static class Question {
        String question;
        String answer;
        List<String> distractors;

        public Question(String question, String answer, List<String> distractors) {
            this.question = question;
            this.answer = answer;
            this.distractors = distractors;
        }
    }
}
