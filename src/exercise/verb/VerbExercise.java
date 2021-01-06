package exercise.verb;

import java.io.*;
import java.util.*;

public class VerbExercise {
    private final File file;
    private final Scanner scanner;
    private final Random random;

    public VerbExercise(String filePath) {
        file = new File(filePath);
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void run() {
        String response = null;
        do {
            List<ParolaTraduzione> dictionary = generateDictionary();
            playWithDictionary(dictionary);

            System.out.println("Wanna play again? (Y/N)");
            response = scanner.nextLine();
        } while ("Y".equalsIgnoreCase(response));

        scanner.close();
    }

    private void playWithDictionary(List<ParolaTraduzione> dictionary) {

        while (!dictionary.isEmpty()) {
            int randomPick = random.nextInt(dictionary.size());
            ParolaTraduzione parolaTraduzione = dictionary.get(randomPick);

            System.out.print(parolaTraduzione.getEnglish());
            scanner.nextLine();
            System.out.println(parolaTraduzione.getGerman());

            dictionary.remove(parolaTraduzione);
        }

        System.out.println("Complete!");
    }

    private List<ParolaTraduzione> generateDictionary() {
        List<String> lines = readFileLines();

        System.out.print("How many verbs do you know? ");
        Integer numberOfVerbs = Integer.parseInt(scanner.nextLine());

        return generateDictionaryFromLines(lines, numberOfVerbs);
    }

    private List<ParolaTraduzione> generateDictionaryFromLines(List<String> lines, Integer numberOfVerbs) {
        List<ParolaTraduzione> dictionary = new ArrayList<>();
        lines = lines.subList(1, numberOfVerbs + 1);

        for (String line : lines) {
            String[] words = line.split(";");
            dictionary.add(new ParolaTraduzione(words[1], words[0]));
        }
        return dictionary;
    }

    private List<String> readFileLines() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            List<String> lines = new ArrayList<>();

            String line;
            StringBuilder holdingLine = null;
            while ((line = reader.readLine()) != null) {
                if (holdingLine == null && !line.contains("\"")) {
                    lines.add(line);
                } else if (holdingLine == null && line.contains("\"")) {
                    holdingLine = new StringBuilder(line);
                } else if (holdingLine != null && !line.contains("\"")) {
                    holdingLine.append(" ").append(line);
                } else if (holdingLine != null) {
                    holdingLine.append(" ").append(line);
                    lines.add(holdingLine.toString());
                    holdingLine = null;
                }
            }

            reader.close();
            return lines;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
