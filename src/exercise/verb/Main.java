package exercise.verb;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        VerbExercise verbExercise = new VerbExercise("LearnGerman.csv");
        verbExercise.run();
    }
}
