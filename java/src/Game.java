import java.util.Optional;

public class Game {
    private Symbol lastSymbol = null;
    private final Board board = new Board();

    public void play(char rawSymbol, int x, int y) {
        Symbol symbol = Symbol.fromChar(rawSymbol);

        //if first move
        if (lastSymbol == null && symbol == Symbol.O) {
            throw new IllegalArgumentException("Invalid first player");
        }

        //if not first move but player repeated
        else if (symbol.equals(lastSymbol)) {
            throw new IllegalArgumentException("Invalid next player");
        }

        //if not first move but play on an already played tile
        else if (board.getSymbolAt(x, y) != null) {
            throw new IllegalArgumentException("Invalid position");
        }

        // update game state
        lastSymbol = symbol;
        board.setSymbolAt(x, y, symbol);
    }

    public Optional<Symbol> computeWinner() {
        //if the positions in first row are taken
        if (board.getSymbolAt(0, 0) != null &&
            board.getSymbolAt(0, 1) != null &&
            board.getSymbolAt(0, 2) != null) {
            //if first row is full with same symbol
            if (board.getSymbolAt(0, 0).equals(board.getSymbolAt(0, 1)) &&
                board.getSymbolAt(0, 2).equals(board.getSymbolAt(0, 1))) {
                return Optional.ofNullable(board.getSymbolAt(0, 0));
            }
        }

        //if the positions in first row are taken
        if (board.getSymbolAt(1, 0) != null &&
            board.getSymbolAt(1, 1) != null &&
            board.getSymbolAt(1, 2) != null) {
            //if middle row is full with same symbol
            if (board.getSymbolAt(1, 0).equals(board.getSymbolAt(1, 1)) &&
                board.getSymbolAt(1, 2).equals(board.getSymbolAt(1, 1))) {
                return Optional.ofNullable(board.getSymbolAt(1, 0));
            }
        }

        //if the positions in first row are taken
        if (board.getSymbolAt(2, 0) != null &&
            board.getSymbolAt(2, 1) != null &&
            board.getSymbolAt(2, 2) != null) {
            //if middle row is full with same symbol
            if (board.getSymbolAt(2, 0).equals(board.getSymbolAt(2, 1)) &&
                board.getSymbolAt(2, 2).equals(board.getSymbolAt(2, 1))) {
                return Optional.ofNullable(board.getSymbolAt(2, 0));
            }
        }

        return Optional.empty();
    }
    
    public String printBoard() {
        return board.print();
    }
}
