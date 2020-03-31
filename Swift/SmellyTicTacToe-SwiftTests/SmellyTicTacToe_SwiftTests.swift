
import XCTest
@testable import SmellyTicTacToe_Swift

class SmellyTicTacToe_SwiftTests: XCTestCase {
    var game : Game!
    
    override func setUp() {
        game = Game()
    }

    func testShould_not_allow_player_O_to_play_first() {
        var thrownError: Error? = nil
        
        XCTAssertThrowsError(try game.Play(symbol:"O", x:0, y:0)) { error in
            thrownError = error
        }
    }
    
    func testShould_not_allow_player_X_to_play_twice_in_a_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:0, y:0)
        }
        catch{}
        
        XCTAssertThrowsError(try game.Play(symbol:"X", x:1, y:0)) { error in
            thrownError = error
        }
    }
    
    func testShould_not_allow_a_player_to_play_in_last_played_position() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:0, y:0)
        }
        catch{}
        
        XCTAssertThrowsError(try game.Play(symbol:"O", x:0, y:0)) { error in
            thrownError = error
        }
    }
    
    func testShould_not_allow_a_player_to_play_in_any_played_position() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:0, y:0)
            try game.Play(symbol:"O", x:1, y:0)
        }
        catch{}
        
        XCTAssertThrowsError(try game.Play(symbol:"O", x:0, y:0)) { error in
            thrownError = error
        }
    }

    func testShould_declare_player_X_as_winner_if_it_plays_three_in_top_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:0, y:0)
            try game.Play(symbol:"O", x:1, y:0)
            try game.Play(symbol:"X", x:0, y:1)
            try game.Play(symbol:"O", x:1, y:1)
            try game.Play(symbol:"X", x:0, y:2)
        }
        catch{}
        
        let winner = game.Winner()
        
        XCTAssertEqual(winner, "X")
    }
    
    func testShould_declare_player_O_as_winner_if_it_plays_three_in_top_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:1, y:0)
            try game.Play(symbol:"O", x:0, y:0)
            try game.Play(symbol:"X", x:1, y:1)
            try game.Play(symbol:"O", x:0, y:1)
            try game.Play(symbol:"X", x:2, y:2)
            try game.Play(symbol:"O", x:0, y:2)
        }
        catch{}
        
        let winner = game.Winner()
        
        XCTAssertEqual(winner, "O")
    }
    
    func testShould_declare_player_X_as_winner_if_it_plays_three_in_mid_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:1, y:0)
            try game.Play(symbol:"O", x:0, y:0)
            try game.Play(symbol:"X", x:1, y:1)
            try game.Play(symbol:"O", x:0, y:1)
            try game.Play(symbol:"X", x:1, y:2)
        }
        catch{}
        
        let winner = game.Winner()
        
        XCTAssertEqual(winner, "X")
    }
    
    func testShould_declare_player_O_as_winner_if_it_plays_three_in_mid_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:0, y:0)
            try game.Play(symbol:"O", x:1, y:0)
            try game.Play(symbol:"X", x:2, y:1)
            try game.Play(symbol:"O", x:1, y:1)
            try game.Play(symbol:"X", x:2, y:2)
            try game.Play(symbol:"O", x:1, y:2)
        }
        catch{}
        
        let winner = game.Winner()
        
        XCTAssertEqual(winner, "O")
    }
    
    func testShould_declare_player_X_as_winner_if_it_plays_three_in_bottom_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:2, y:0)
            try game.Play(symbol:"O", x:0, y:0)
            try game.Play(symbol:"X", x:2, y:1)
            try game.Play(symbol:"O", x:0, y:1)
            try game.Play(symbol:"X", x:2, y:2)
        }
        catch{}
        
        let winner = game.Winner()
        
        XCTAssertEqual(winner, "X")
    }
    
    func testShould_declare_player_O_as_winner_if_it_plays_three_in_bottom_row() {
        var thrownError: Error? = nil
        
        do {
            try game.Play(symbol:"X", x:0, y:0)
            try game.Play(symbol:"O", x:2, y:0)
            try game.Play(symbol:"X", x:1, y:1)
            try game.Play(symbol:"O", x:2, y:1)
            try game.Play(symbol:"X", x:0, y:1)
            try game.Play(symbol:"O", x:2, y:2)
        }
        catch{}
        
        let winner = game.Winner()
        
        XCTAssertEqual(winner, "O")
    }
}
