package mission_1week.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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

    public void printWordsList() {
        Set<Integer> keySet = wordsList.getKeySet();
        List<Integer> keys = new ArrayList<>(keySet);
        Collections.reverse(keys);


        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (Integer key : keys) {
            Words word = wordsList.getWord(key);
            System.out.println(key + " / " + word.getWriter() + " / " + word.getSentence());
        }
    }

    public void deleteWords(int index){
        Set<Integer> keySet = wordsList.getKeySet();
        boolean contains = keySet.contains(index);
        if (!contains) {
            throw new IllegalArgumentException(index + "번 명언은 존재하지 않습니다.");
        }
        wordsList.deleteWords(index);
        System.out.println(index + "번 명언이 삭제되었습니다.");
    }
}
