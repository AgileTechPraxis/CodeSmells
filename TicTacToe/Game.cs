using System;

namespace TicTacToe
{
    public class Game
    {
        private char _lastSymbol = ' ';

        public void Play(char symbol, int x, int y)
        {
            if(_lastSymbol == ' ')
            {
                if(symbol == 'O')
                {
                    throw new Exception("Invalid first player");
                }
            } 
            else
            {
                if (symbol == _lastSymbol)
                {
                    throw new Exception("Invalid next player");
                }
            }

            _lastSymbol = symbol;
 
            
        }
    }
}
























































