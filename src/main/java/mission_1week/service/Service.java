package mission_1week.service;

import java.util.Scanner;
import mission_1week.domain.words.Words;
import mission_1week.domain.words.WordsList;

public class Service {
    private final WordsList wordsList;
    private static Scanner sc;

    public Service() {
        this.wordsList = new WordsList();
        this.sc = new Scanner(System.in);
    }

    public void insertWordsList() {
        System.out.print("명언 : ");
        String sentence = sc.nextLine();
        System.out.print("작가 : ");
        String writer = sc.nextLine();

        Words words = new Words(sentence, writer);
        wordsList.InsertWords(words);
        System.out.println(wordsList.getIndex() + "번 명언이 등록되었습니다.");
    }

    public WordsList getWordsList() {
        return wordsList;
    }
}
