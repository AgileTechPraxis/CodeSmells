import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private Game game;

    @BeforeEach
    void InitializeGame() {
        game = new Game();
    }

    @Test
    void NotAllowPlayerOToPlayFirst() {
        assertThrows(Exception.class, () -> game.play('O', 0, 0));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(Exception.class, () -> {
            game.play('X', 0, 0);
            game.play('X', 1, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(Exception.class, () -> {
            game.play('X', 0, 0);
            game.play('O', 0, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(Exception.class, () -> {
            game.play('X', 0, 0);
            game.play('O', 1, 0);
            game.play('X', 0, 0);
        });
    }

    @Test
    void DeclareNoWinnerWithUnfinishedGrid() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isEmpty());
    }

    @Test
    void DeclareNoWinnerWithTiedGrid() throws Exception {
        game.play('X', 1, 1);
        game.play('O', 0, 0);
        game.play('X', 0, 2);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('O', 1, 2);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isEmpty());
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);
        game.play('X', 0, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals(Symbol.X, winner.get());
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception {
        game.play('X', 2, 2);
        game.play('O', 0, 0);
        game.play('X', 1, 0);
        game.play('O', 0, 1);
        game.play('X', 1, 1);
        game.play('O', 0, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals(Symbol.O, winner.get());
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.play('X', 1, 0);
        game.play('O', 0, 0);
        game.play('X', 1, 1);
        game.play('O', 0, 1);
        game.play('X', 1, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals(Symbol.X, winner.get());
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 2, 0);
        game.play('O', 1, 1);
        game.play('X', 2, 1);
        game.play('O', 1, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals(Symbol.O, winner.get());
    }

    @Test
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception {
        game.play('X', 2, 0);
        game.play('O', 0, 0);
        game.play('X', 2, 1);
        game.play('O', 0, 1);
        game.play('X', 2, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals(Symbol.X, winner.get());
    }

    @Test
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        game.play('X', 1, 0);
        game.play('O', 2, 1);
        game.play('X', 1, 1);
        game.play('O', 2, 2);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isPresent());
        assertEquals(Symbol.O, winner.get());
    }

    @Test
    void NotAllowPlayingIllegalSymbol() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        assertThrows(IllegalArgumentException.class, () -> game.play('Y', 1, 0));
    }

    @Test
    void AllowPlayingLowercaseVariants() throws Exception {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        assertDoesNotThrow(() -> game.play('x', 1, 0));
        assertDoesNotThrow(() -> game.play('o', 2, 1));
    }
}
