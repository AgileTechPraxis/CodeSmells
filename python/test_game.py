import unittest

from Game import Game


class TestGame(unittest.TestCase):

    def setUp(self):
        self.game = Game()

    def test_not_allow_player_oto_play_first(self):
        with self.assertRaises(Exception):
            self.game.play('O', 0, 0)

    def test_not_allow_player_xto_play_twice_in_arow(self):
        with self.assertRaises(Exception):
            self.game.play('X', 0, 0)
            self.game.play('X', 1, 0)

    def test_not_allow_player_to_play_in_last_played_position(self):
        with self.assertRaises(Exception):
            self.game.play('X', 0, 0)
            self.game.play('O', 0, 0)

    def test_not_allow_player_to_play_in_any_played_position(self):
        with self.assertRaises(Exception):
            self.game.play('X', 0, 0)
            self.game.play('O', 1, 0)
            self.game.play('X', 0, 0)

    def test_declare_player_x_as_awinner_if_three_in_top_row(self):
        self.game.play('X', 0, 0)
        self.game.play('O', 1, 0)
        self.game.play('X', 0, 1)
        self.game.play('O', 1, 1)
        self.game.play('X', 0, 2)

        self.assertEqual('X', self.game.winner())

    def test_declare_player_o_as_awinner_if_three_in_top_row(self):
        self.game.play('X', 2, 2)
        self.game.play('O', 0, 0)
        self.game.play('X', 1, 0)
        self.game.play('O', 0, 1)
        self.game.play('X', 1, 1)
        self.game.play('O', 0, 2)

        self.assertEqual('O', self.game.winner())

    def test_declare_player_x_as_awinner_if_three_in_middle_row(self):
        self.game.play('X', 0, 0)
        self.game.play('O', 1, 0)
        self.game.play('X', 2, 0)
        self.game.play('O', 1, 1)
        self.game.play('X', 2, 1)
        self.game.play('O', 1, 2)

        self.assertEqual('O', self.game.winner())

    def test_declare_player_x_as_awinner_if_three_in_bottom_row(self):
        self.game.play('X', 2, 0)
        self.game.play('O', 0, 0)
        self.game.play('X', 2, 1)
        self.game.play('O', 0, 1)
        self.game.play('X', 2, 2)

        self.assertEqual('X', self.game.winner())

    def test_declare_player_o_as_awinner_if_three_in_bottom_row(self):
        self.game.play('X', 0, 0)
        self.game.play('O', 2, 0)
        self.game.play('X', 1, 0)
        self.game.play('O', 2, 1)
        self.game.play('X', 1, 1)
        self.game.play('O', 2, 2)

        self.assertEqual('O', self.game.winner())


if __name__ == '__main__':
    unittest.main()
