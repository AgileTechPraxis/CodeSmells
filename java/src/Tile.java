import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Tile {
    private int x;
    private int y;
    private Optional<Character> symbol;
}
