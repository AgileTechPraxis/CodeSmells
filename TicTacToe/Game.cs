using System;

namespace TicTacToe
{
    public class Game
    {
        private char _lastSymbol = ' ';
        private int _lastX = -1;
        private int _lastY = -1;

        public void Play(char symbol, int x, int y)
        {
            //if first move
            if(_lastSymbol == ' ')
            {
                //if player is X
                if(symbol == 'O')
                {
                    throw new Exception("Invalid first player");
                }
            } 
            //if not first move but player repeated
            else if (symbol == _lastSymbol)
            {
                throw new Exception("Invalid next player");
            }
            // play on an already played tile
            else if (_lastX == x && _lastY == y)
            {
                throw new Exception("Invalid position");
            }

            // update game state
            _lastSymbol = symbol;
            _lastX = x;
            _lastY = y;
        }
    }
}
























































