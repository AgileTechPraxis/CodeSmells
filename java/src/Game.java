public class Game {
    private char lastSymbol = ' ';
    private final Board board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (board.TileAt(x, y).symbol != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (board.TileAt(0, 0).symbol != ' ' &&
            board.TileAt(0, 1).symbol != ' ' &&
            board.TileAt(0, 2).symbol != ' ') {
            //if first row is full with same symbol
            if (board.TileAt(0, 0).symbol ==
                board.TileAt(0, 1).symbol &&
                board.TileAt(0, 2).symbol == board.TileAt(0, 1).symbol) {
                return board.TileAt(0, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(1, 0).symbol != ' ' &&
            board.TileAt(1, 1).symbol != ' ' &&
            board.TileAt(1, 2).symbol != ' ') {
            //if middle row is full with same symbol
            if (board.TileAt(1, 0).symbol ==
                board.TileAt(1, 1).symbol &&
                board.TileAt(1, 2).symbol ==
                board.TileAt(1, 1).symbol) {
                return board.TileAt(1, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(2, 0).symbol != ' ' &&
            board.TileAt(2, 1).symbol != ' ' &&
            board.TileAt(2, 2).symbol != ' ') {
            //if middle row is full with same symbol
            if (board.TileAt(2, 0).symbol ==
                board.TileAt(2, 1).symbol &&
                board.TileAt(2, 2).symbol ==
                board.TileAt(2, 1).symbol) {
                return board.TileAt(2, 0).symbol;
            }
        }

        return ' ';
    }
}
