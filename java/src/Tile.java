import lombok.Getter;
import lombok.Setter;

@Getter
public class Tile {
    private final int x;
    private final int y;
    @Setter
    private Symbol symbol;
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
