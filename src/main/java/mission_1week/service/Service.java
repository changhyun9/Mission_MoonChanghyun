package mission_1week.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private final String filePath = "/Users/munchanghyeon/Desktop/javaProject/Mission_MoonChanghyun/Mission/file/명언.txt";
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;
    private BufferedReader fr;

    public Service() throws IOException {
        this.wordsList = new WordsList();
        this.sc = new Scanner(System.in);
        this.file = new File(filePath);
        file.createNewFile();
        this.fr  = new BufferedReader(new FileReader(filePath));
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

    public void deleteWords(int index) throws IllegalArgumentException {
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

    public void fileStore() throws IOException {
        Set<Integer> allKey = wordsList.getKeySet();
        for (Integer key : allKey) {
            Words word = wordsList.getWord(key);
            bw.write(key+","+word.getSentence()+","+word.getWriter());
            bw.write("\n");
        }
        bw.close();
    }

    public void fileBuild() throws IOException {
        String read;
        while((read = fr.readLine()) != null){
            String[] split = read.split(",");
            Words words = new Words(split[1], split[2]);
            wordsList.InsertWords(words);
        }
        this.fw = new FileWriter(file);
        this.bw = new BufferedWriter(fw);
    }
}
