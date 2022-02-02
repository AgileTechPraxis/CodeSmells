# frozen_string_literal: true

require 'minitest/autorun'
require './game'

describe('TicTacToe game') do
  before do
    @game = Game.new
  end

  it 'should not allow player O to play first' do
    assert_raises { @game.play('O', 0, 0) }
  end

  it 'should not allow player x to play twice in a row' do
    @game.play('X', 0, 0)
    assert_raises { @game.play('X', 1, 0) }
  end
  
  it 'should not allow a player to play in last played position' do
    @game.play('X', 0, 0)
    assert_raises { @game.play('O', 0, 0) }
  end
  
  it 'should not allow a player to play in any played position' do
    @game.play('X', 0, 0)
    @game.play('O', 1, 0)
    assert_raises { @game.play('X', 0, 0) }
  end
  
  it 'should declare player X as winner if it plays three in top row' do
    @game.play('X', 0, 0)
    @game.play('O', 1, 0)
    @game.play('X', 0, 1)
    @game.play('O', 1, 1)
    @game.play('X', 0, 2)
    
    winner = @game.winner
    
    assert_equal('X', winner)
  end
  
  it 'should declare player O as winner if it plays three in top row' do
    @game.play('X', 1, 0)
    @game.play('O', 0, 0)
    @game.play('X', 1, 1)
    @game.play('O', 0, 1)
    @game.play('X', 2, 2)
    @game.play('O', 0, 2)
    
    winner = @game.winner
    
    assert_equal("O", winner)
  end
  
  it 'should declare player X as winner if it plays three in middle row' do
    @game.play('X', 1, 0)
    @game.play('O', 0, 0)
    @game.play('X', 1, 1)
    @game.play('O', 0, 1)
    @game.play('X', 1, 2)
     
    winner = @game.winner
    
    assert_equal("X", winner)
  end
  
  it 'should declare player O as winner if it plays three in middle row' do
    @game.play('X', 0, 0)
    @game.play('O', 1, 0)
    @game.play('X', 2, 1)
    @game.play('O', 1, 1)
    @game.play('X', 2, 2)
    @game.play('O', 1, 2)
    
    winner = @game.winner
    
    assert_equal("O", winner)
  end
  
  it 'should declare player X as winner if it plays three in bottom row' do
    @game.play('X', 2, 0)
    @game.play('O', 0, 0)
    @game.play('X', 2, 1)
    @game.play('O', 0, 1)
    @game.play('X', 2, 2)
    
    winner = @game.winner
    
    assert_equal("X", winner)
  end
  
  it 'should declare player O as winner if it plays three in bottom row' do
    @game.play('X', 0, 0)
    @game.play('O', 2, 0)
    @game.play('X', 1, 1)
    @game.play('O', 2, 1)
    @game.play('X', 0, 1)
    @game.play('O', 2, 2)
    
    winner = @game.winner
    
    assert_equal("O", winner)
  end
end
