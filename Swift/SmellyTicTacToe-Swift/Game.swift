import Foundation

class Game {
    var _lastSymbol: String = " ";
    let _board: Board = Board();

    public func Play(symbol: String, x: Int, y: Int) throws {
        //if first move
        if (self._lastSymbol == " ") {
            //if player is X
            if (symbol == "O") {
                throw "Invalid first player";
            }
        }
        //if not first move but player repeated
        else if (symbol == self._lastSymbol) {
            throw "Invalid next player";
        }
        //if not first move but play on an already played tile
        else if (self._board.TileAt(x:x, y:y)!.Symbol != " ") {
            throw "Invalid position";
        }

        // update game state
        self._lastSymbol = symbol;
        self._board.AddTileAt(symbol:symbol, x:x, y:y);
    }

    public func Winner() -> String {
        //if the positions in first row are taken
        if (self._board.TileAt(x:0, y:0)!.Symbol != " " &&
            self._board.TileAt(x:0, y:1)!.Symbol != " " &&
            self._board.TileAt(x:0, y:2)!.Symbol != " ") {
            //if first row is full with same symbol
            if (self._board.TileAt(x:0, y:0)!.Symbol ==
                self._board.TileAt(x:0, y:1)!.Symbol &&
                self._board.TileAt(x:0, y:2)!.Symbol == self._board.TileAt(x:0, y:1)!.Symbol) {
                return self._board.TileAt(x:0, y:0)!.Symbol;
            }
        }

        //if the positions in first row are taken
        if (self._board.TileAt(x:1, y:0)!.Symbol != " " &&
            self._board.TileAt(x:1, y:1)!.Symbol != " " &&
            self._board.TileAt(x:1, y:2)!.Symbol != " ") {
            //if middle row is full with same symbol
            if (self._board.TileAt(x:1, y:0)!.Symbol ==
                self._board.TileAt(x:1, y:1)!.Symbol &&
                self._board.TileAt(x:1, y:2)!.Symbol ==
                self._board.TileAt(x:1, y:1)!.Symbol) {
                return self._board.TileAt(x:1, y:0)!.Symbol;
            }
        }

        //if the positions in first row are taken
        if (self._board.TileAt(x:2, y:0)!.Symbol != " " &&
            self._board.TileAt(x:2, y:1)!.Symbol != " " &&
            self._board.TileAt(x:2, y:2)!.Symbol != " ") {
            //if middle row is full with same symbol
            if (self._board.TileAt(x:2, y:0)!.Symbol ==
                self._board.TileAt(x:2, y:1)!.Symbol &&
                self._board.TileAt(x:2, y:2)!.Symbol ==
                self._board.TileAt(x:2, y:1)!.Symbol) {
                return self._board.TileAt(x:2, y:0)!.Symbol;
            }
        }

        return " ";
    }
}

struct Tile
{
    public let X: Int;
    public let Y: Int;
    public var Symbol: String;
}

class Board
{
    private var _plays : [Tile] = [];

    init()
    {
        for i in 0...2 {
            for j in 0...2 {
                let tile : Tile = Tile( X : i, Y : j, Symbol : " ")
                self._plays.append(tile);
            }
        }
    }

    public func TileAt(x:  Int, y: Int) -> Tile? {
        return _plays.filter { $0.X == x && $0.Y == y}.first
    }

    public func AddTileAt(symbol: String, x: Int, y: Int)
    {
        var tile : Tile = Tile( X : x, Y : y, Symbol : symbol)

        _plays = _plays.map{ return $0.X == x && $0.Y == y ? Tile(X : $0.X, Y : $0.Y, Symbol : symbol) : $0 }
    }
}

extension String: Error {}
