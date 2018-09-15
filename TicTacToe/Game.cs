using System;
using System.Collections.Generic;

namespace TicTacToe
{
    public class Game
    {
        private char _lastSymbol = ' ';
        private Dictionary<Tuple<int, int>, char> _plays = new Dictionary<Tuple<int, int>, char>();

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
            //if not first move but play on an already played tile
            else if (_plays.ContainsKey(new Tuple<int, int>(x, y)))
            {
                throw new Exception("Invalid position");
            }

            // update game state
            _lastSymbol = symbol;
            _plays[new Tuple<int, int>(x, y)] = symbol;
        }

        public char Winner()
        {   //if the positions in first row are taken
            if(_plays.ContainsKey(new Tuple<int, int>(0, 0)) &&
               _plays.ContainsKey(new Tuple<int, int>(0, 1)) &&
               _plays.ContainsKey(new Tuple<int, int>(0, 2)))
               {
                    //if first row is full with same symbol
                    if (_plays[new Tuple<int, int>(0, 0)] == 
                        _plays[new Tuple<int, int>(0, 1)] &&
                        _plays[new Tuple<int, int>(0, 2)] == 
                        _plays[new Tuple<int, int>(0, 1)] )
                        {
                            return _plays[new Tuple<int, int>(0, 0)];
                        }
               }
                
             //if the positions in first row are taken
             if(_plays.ContainsKey(new Tuple<int, int>(1, 0)) &&
                _plays.ContainsKey(new Tuple<int, int>(1, 1)) &&
                _plays.ContainsKey(new Tuple<int, int>(1, 2)))
                {
                    //if middle row is full with same symbol
                    if (_plays[new Tuple<int, int>(1, 0)] == 
                        _plays[new Tuple<int, int>(1, 1)] &&
                        _plays[new Tuple<int, int>(1, 2)] == 
                        _plays[new Tuple<int, int>(1, 1)])
                        {
                            return _plays[new Tuple<int, int>(1, 0)];
                        }
                }

            //if the positions in first row are taken
             if(_plays.ContainsKey(new Tuple<int, int>(2, 0)) &&
                _plays.ContainsKey(new Tuple<int, int>(2, 1)) &&
                _plays.ContainsKey(new Tuple<int, int>(2, 2)))
                {
                    //if middle row is full with same symbol
                    if (_plays[new Tuple<int, int>(2, 0)] == 
                        _plays[new Tuple<int, int>(2, 1)] &&
                        _plays[new Tuple<int, int>(2, 2)] == 
                        _plays[new Tuple<int, int>(2, 1)])
                        {
                            return _plays[new Tuple<int, int>(2, 0)];
                        }
                }

            return ' ';
        }
    }
}
























































