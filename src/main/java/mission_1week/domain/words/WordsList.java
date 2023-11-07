package mission_1week.domain.words;

import java.util.HashMap;
import java.util.Map;

public class WordsList {
    private static int index = 0;

    private final Map<Integer, Words> wordsList;

    public WordsList() {
        this.wordsList = new HashMap<>();
    }

    public void InsertWords(Words words) {
        wordsList.put(++index, words);
    }

    public Words getWord(int index) {
        return wordsList.get(index);
    }

    public void deleteWords(int index){
        wordsList.remove(index);
    }

    public int size() {
        return wordsList.size();
    }

    public int getIndex() {
        return index;
    }
}
