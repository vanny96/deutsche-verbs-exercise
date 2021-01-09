package exercise.verb;

import exercise.verb.exercises.TopicExercise;
import exercise.verb.exercises.VerbExercise;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What exercise do you want to do?" +
                    "\n1) verbs" +
                    "\n2) topics" +
                    "\nx) quit");
            String response = scanner.nextLine();

            switch (response.toLowerCase()) {
                case "1":
                    VerbExercise verbExercise = new VerbExercise("LearnGerman.csv", scanner);
                    verbExercise.run();
                    break;
                case "2":
                    TopicExercise topicExercise = new TopicExercise("LearnGerman-topics.csv", scanner);
                    topicExercise.run();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Not a valid input");
            }
        }
    }
}
