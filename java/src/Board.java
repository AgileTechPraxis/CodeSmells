import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private final List<Tile> plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(i, j);
                plays.add(tile);
            }
        }
    }

    public Symbol getSymbolAt(int x, int y) {
        return Optional.ofNullable(this.tileAt(x, y)).map(Tile::getSymbol).orElse(null);
    }

    public void setSymbolAt(int x, int y, Symbol symbol) {
        Optional.ofNullable(this.tileAt(x, y)).ifPresent(t -> t.setSymbol(symbol));
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile currentTile = this.tileAt(i, j);
                sb.append(Optional.ofNullable(currentTile).map(Tile::getSymbol).map(Symbol::getAsChar).orElse(' '));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Tile tileAt(int x, int y) {
        for (Tile t : plays) {
            if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }
        return null;
    }
}
