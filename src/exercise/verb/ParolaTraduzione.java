package exercise.verb;

public class ParolaTraduzione {
    private String english;
    private String german;

    public ParolaTraduzione(String english, String german) {
        this.english = english;
        this.german = german;
    }

    public String getEnglish() {
        return english;
    }

    public ParolaTraduzione setEnglish(String english) {
        this.english = english;
        return this;
    }

    public String getGerman() {
        return german;
    }

    public ParolaTraduzione setGerman(String german) {
        this.german = german;
        return this;
    }
}
