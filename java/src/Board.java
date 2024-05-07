import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Tile> plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.x = i;
                tile.y = j;
                tile.symbol = ' ';
                plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile t : plays) {
            if (t.x == x && t.y == y) {
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y) {
        Tile newTile = new Tile();
        newTile.x = x;
        newTile.y = y;
        newTile.symbol = symbol;

        TileAt(x, y).symbol = symbol;
    }
}
