import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Symbol {
    X('X'),
    O('O');

    private final char asChar;

    public static Symbol fromChar(char in) {
        return Arrays.stream(Symbol.values())
                .filter(s -> s.asChar == Character.toUpperCase(in))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid symbol: %s".formatted(in)));
    }
}
