from Tile import Tile


class Board(object):

    def __init__(self):
        self._plays = []
        for i in range(3):
            for j in range(3):
                tile = Tile()
                tile.X = i
                tile.Y = j
                tile.Symbol = ' '
                self._plays.append(tile)

    def AddTileAt(self, symbol, x, y):
        new_tile = Tile()
        new_tile.X = x
        new_tile.Y = y
        new_tile.Symbol = symbol

        self.TileAt(x, y).Symbol = symbol

    def TileAt(self, x, y):
        for t in self._plays:
            if t.X == x and t.Y == y:
                return t
        return None
