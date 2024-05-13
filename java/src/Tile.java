import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Tile {
    private final int x;
    private final int y;
    @Setter
    private Symbol symbol;
}
