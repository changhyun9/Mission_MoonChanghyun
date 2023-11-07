package mission_1week.domain.words;

public class Words {
    private String sentence;
    private String writer;

    public Words(String sentence, String writer) {
        this.sentence = sentence;
        this.writer = writer;
    }

    public String getSentence() {
        return sentence;
    }

    public String getWriter() {
        return writer;
    }
}
