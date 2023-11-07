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
        String sentence = enterSentence();
        String writer = enterWriter();

        Words words = new Words(sentence, writer);
        wordsList.InsertWords(words);
        System.out.println(wordsList.getIndex() + "번 명언이 등록되었습니다.");
    }

    private String enterWriter() {
        System.out.print("작가 : ");
        String writer = sc.nextLine();
        return writer;
    }

    private String enterSentence() {
        System.out.print("명언 : ");
        String sentence = sc.nextLine();
        return sentence;
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
        isExists(index);
        wordsList.deleteWords(index);
        System.out.println(index + "번 명언이 삭제되었습니다.");
    }

    private void isExists(int index) {
        Set<Integer> keySet = wordsList.getKeySet();
        boolean contains = keySet.contains(index);
        if (!contains) {
            throw new IllegalArgumentException(index + "번 명언은 존재하지 않습니다.");
        }
    }

    public void modifyWords(int index) {
        isExists(index);
        Words word = wordsList.getWord(index);
        String modifiedSentence = modifySentence(word);
        String modifiedWriter = modifyWriter(word);

        Words modifiedWords = new Words(modifiedSentence, modifiedWriter);
        wordsList.modifyWords(index, modifiedWords);
        System.out.println(index + "번 명언이 수정되었습니다.");
    }

    private String modifyWriter(Words word) {
        System.out.println("작가(기존) : " + word.getWriter());
        String modifiedWriter = enterWriter();
        return modifiedWriter;
    }

    private String modifySentence(Words word) {
        System.out.println("명언(기존) : " + word.getSentence());
        String modifiedSentence = enterSentence();
        return modifiedSentence;
    }
}

// 예외 상황 처리하기, 예외가 발생한 곳부터 재입력 받는 식으로
// 명령 입력 시, 패턴이 안맞거나, 인덱스가 없는 경우 예외문을 출력하고, 해당 과정부터 재시작
// 위의 단계를 모두 해결하였다면, 9단계로 넘어가기 혹은 계층 분류, 또는 클래스 분리 같은 리팩토링 하기
