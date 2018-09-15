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

            Assert.Throws<Exception>(wrongPlay);
        }
    }
}
