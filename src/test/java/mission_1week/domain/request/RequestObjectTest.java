package mission_1week.domain.request;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestObjectTest {

    // 등록, 수정?id=1, 삭제?id=2, 목록, 종료
    @DisplayName("명령어만 입력받으면 인덱스는 0이다")
    @Test
    void createRequestByDefaultIndex() {
        RequestObject requestObject = new RequestObject("등록");
        Assertions.assertThat(requestObject.getCommand()).isEqualTo("등록");
        Assertions.assertThat(requestObject.getIndex()).isEqualTo(0);
    }

    @DisplayName("인덱스 포함 입력시 명령어?id=인덱스 형식으로 입력하지 않으면 예외가 발생함")
    @Test
    void createRequestByInvalidPattern() {
        Assertions.assertThatThrownBy(() -> new RequestObject("수정?id-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("명령어?id=인덱스 정상 입력")
    @Test
    void createRequestSuccess() {
        RequestObject requestObject = new RequestObject("수정?id=3");
        Assertions.assertThat(requestObject.getCommand()).isEqualTo("수정");
        Assertions.assertThat(requestObject.getIndex()).isEqualTo(3);

    }
}