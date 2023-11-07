package mission_1week.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import mission_1week.domain.words.Words;
import mission_1week.domain.words.WordsList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {
    Service service = new Service();

    @DisplayName("명언과 작가를 입력하면 객체를 생성해서 리스트에 삽입")
    @Test
    void insertWordsList() {
        String input = "명언입니다.\n작가입니다.\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        service.insertWordsList(); // 테스트시 매개변수로 Scanner 를 넘겨줌.
        Assertions.assertThat(service.getWordsList().size()).isEqualTo(1);
    }

    @DisplayName("특정 인덱스를 입력받아, 값을 입력하고 변경합니다.")
    @Test
    void modifyWordsByCertainIndex() {
        String input1 = "명언입니다.\n작가입니다.\n";
        InputStream in = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        service.insertWordsList(); // 테스트시 매개변수로 Scanner 를 넘겨줌.

        String input = "수정명언입니다.\n수정작가입니다.\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        service.modifyWords(1);
        WordsList wordsList = service.getWordsList();

        Words word = wordsList.getWord(1);
        Assertions.assertThat(word.getSentence()).isEqualTo("수정명언입니다.");
        Assertions.assertThat(word.getWriter()).isEqualTo("수정작가입니다.");

    }

    @DisplayName("특정 인덱스를 받아, 인덱스에 해당하는 값이 없으면 예외를 반환한다.")
    @Test
    void deleteWordsByNonExistIndex() {
        Assertions.assertThatThrownBy(() -> service.deleteWords(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 인덱스를 받아, 인덱스에 해당하는 값이 있으면 사이즈가 감소한다.")
    @Test
    void deleteWordsByCertainIndex() {
        String input = "명언입니다.\n작가입니다.\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        service.insertWordsList(); // 테스트시 매개변수로 Scanner 를 넘겨줌.
        service.deleteWords(1);
        Assertions.assertThat(service.getWordsList().size()).isEqualTo(0);
    }
}

// System.in 을 이용한 테스트 코드 리팩토링하기