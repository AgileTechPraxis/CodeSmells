import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
        assertThrows(IllegalArgumentException.class, () -> game.play('O', 0, 0));
    }

    @Test
    void NotAllowPlayerXToPlayTwiceInARow() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.play('X', 0, 0);
            game.play('X', 1, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInLastPlayedPosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.play('X', 0, 0);
            game.play('O', 0, 0);
        });
    }

    @Test
    void NotAllowPlayerToPlayInAnyPlayedPosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.play('X', 0, 0);
            game.play('O', 1, 0);
            game.play('X', 0, 0);
        });
    }

    @Test
    void DeclareNoWinnerWithUnfinishedGrid() {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);

        Optional<Symbol> winner = game.computeWinner();

        assertTrue(winner.isEmpty());
    }

    @Test
    void DeclareNoWinnerWithTiedGrid() {
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
    void DeclarePlayerXAsAWinnerIfThreeInTopRow() {
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
    void DeclarePlayerOAsAWinnerIfThreeInTopRow() {
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
    void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() {
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
    void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() {
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
    void DeclarePlayerXAsAWinnerIfThreeInBottomRow() {
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
    void DeclarePlayerOAsAWinnerIfThreeInBottomRow() {
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
    void NotAllowPlayingIllegalSymbol() {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        assertThrows(IllegalArgumentException.class, () -> game.play('Y', 1, 0));
    }

    @Test
    void AllowPlayingLowercaseVariants() {
        game.play('X', 0, 0);
        game.play('O', 2, 0);
        assertDoesNotThrow(() -> game.play('x', 1, 0));
        assertDoesNotThrow(() -> game.play('o', 2, 1));
    }
    
    @Test
    void DeclarePlayerXAsAWinnerIfThreeInLeftColumn() {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 0, 1);
        game.play('O', 1, 1);
        game.play('X', 0, 2);

        assertTrue(game.computeWinner().isPresent());
        assertEquals(Symbol.X, game.computeWinner().get());
    }

    @Test
    @Disabled("Not implemented")
    void DeclarePlayerXAsAWinnerIfThreeDiagonallyRightDown() {
        game.play('X', 0, 0);
        game.play('O', 1, 0);
        game.play('X', 1, 1);
        game.play('O', 2, 1);
        game.play('X', 2, 2);

        System.out.println(game.printBoard());
        assertTrue(game.computeWinner().isPresent());
        assertEquals(Symbol.X, game.computeWinner().get());
    }
}
