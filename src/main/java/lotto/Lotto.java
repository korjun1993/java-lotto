package lotto;

import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

import java.util.Collections;
import java.util.List;

import static lotto.LottoConfiguration.END_NUMBER;
import static lotto.LottoConfiguration.START_NUMBER;
import static lotto.LottoConfiguration.SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInValidSize(numbers)) {
            throw new MyIllegalArgumentException(ErrorCode.LOTTO_SIZE_ERROR);
        }
        if (hasOutOfBoundNumber(numbers)) {
            throw new MyIllegalArgumentException(ErrorCode.LOTTO_BOUND_ERROR);
        }
        if (hasDuplicateNumber(numbers)) {
            throw new MyIllegalArgumentException(ErrorCode.LOTTO_DUPLICATE_ERROR);
        }
    }

    private boolean isInValidSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    private boolean hasOutOfBoundNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(x -> x < START_NUMBER || x > END_NUMBER);
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
