import java.util.Optional;

public class Game {
    private char lastSymbol = ' ';
    private final Board board = new Board();

    public void play(char symbol, int x, int y) throws Exception {
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
        else if (board.tileAt(x, y).getSymbol() != ' ') {
            throw new Exception("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.addTileAt(symbol, x, y);
    }

    public Optional<Character> computeWinner() {
        //if the positions in first row are taken
        if (board.tileAt(0, 0).getSymbol() != ' ' &&
            board.tileAt(0, 1).getSymbol() != ' ' &&
            board.tileAt(0, 2).getSymbol() != ' ') {
            //if first row is full with same symbol
            if (board.tileAt(0, 0).getSymbol() ==
                board.tileAt(0, 1).getSymbol() &&
                board.tileAt(0, 2).getSymbol() == board.tileAt(0, 1).getSymbol()) {
                return Optional.of(board.tileAt(0, 0).getSymbol());
            }
        }

        //if the positions in first row are taken
        if (board.tileAt(1, 0).getSymbol() != ' ' &&
            board.tileAt(1, 1).getSymbol() != ' ' &&
            board.tileAt(1, 2).getSymbol() != ' ') {
            //if middle row is full with same symbol
            if (board.tileAt(1, 0).getSymbol() ==
                board.tileAt(1, 1).getSymbol() &&
                board.tileAt(1, 2).getSymbol() ==
                board.tileAt(1, 1).getSymbol()) {
                return Optional.of(board.tileAt(1, 0).getSymbol());
            }
        }

        //if the positions in first row are taken
        if (board.tileAt(2, 0).getSymbol() != ' ' &&
            board.tileAt(2, 1).getSymbol() != ' ' &&
            board.tileAt(2, 2).getSymbol() != ' ') {
            //if middle row is full with same symbol
            if (board.tileAt(2, 0).getSymbol() ==
                board.tileAt(2, 1).getSymbol() &&
                board.tileAt(2, 2).getSymbol() ==
                board.tileAt(2, 1).getSymbol()) {
                return Optional.of(board.tileAt(2, 0).getSymbol());
            }
        }

        return Optional.empty();
    }
}
