package exercise.verb.exercises;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TopicExercise {
    private final File file;
    private final Scanner scanner;

    public TopicExercise(String filePathname, Scanner scanner) {
        this.file = new File(filePathname);
        this.scanner = scanner;
    }


    public void run() {
        Set<String> topics = extractTopicsFromFile();

        for(String topic : topics){
            System.out.print("Talk about this topic: " + topic);
            scanner.nextLine();
        }
    }

    private Set<String> extractTopicsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            reader.readLine(); // Skip first line, I don't care about that!

            Set<String> topics = new HashSet<>();
            String topic = null;
            while ((topic = reader.readLine()) != null){
                topics.add(topic);
            }

            reader.close();
            return topics;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptySet();
        }
    }
}
