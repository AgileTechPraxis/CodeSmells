import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private final List<Tile> plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setX(i);
                tile.setY(j);
                tile.setSymbol(Optional.empty());
                plays.add(tile);
            }
        }
    }

    public Tile tileAt(int x, int y) {
        for (Tile t : plays) {
            if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }
        return null;
    }
}
