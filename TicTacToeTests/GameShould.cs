using System;
using Xunit;
using TicTacToe;

namespace TicTacToeTests
{
    public class GameShould
    {
        [Fact]
        public void NotAllowPlayerOToPlayFirst()
        {
            var game =new Game();

            Action wrongPlay = () => game.Play('O', 0, 0);

            var exception = Assert.Throws<Exception>(wrongPlay);
            Assert.Equal("Invalid first player", exception.Message);
        }

        [Fact]
        public void NotAllowPlayerXToPlayTwiceInARow()
        {
            var game =new Game();
            game.Play('X', 0, 0);
            
            Action wrongPlay = () => game.Play('X', 1, 0);

            var exception = Assert.Throws<Exception>(wrongPlay);
            Assert.Equal("Invalid next player", exception.Message);
        }

        [Fact]
        public void NotAllowPlayerToPlayInLastPlayedPosition()
        {
            var game =new Game();
            game.Play('X', 0, 0);

            Action wrongPlay = () => game.Play('O', 0, 0);

            var exception = Assert.Throws<Exception>(wrongPlay);
            Assert.Equal("Invalid position", exception.Message);
        }
    }
}
