package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1부터 45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 출력 기능을 테스트한다.")
    @Test
    void printNumbers() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.printNumbers();

        Assertions.assertThat(output.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }

    @DisplayName("로또 번호 정렬 기능을 테스트한다.")
    @Test
    void sortNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(3, 2, 1, 5, 4, 6));
        lotto.sortNumbers();
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
