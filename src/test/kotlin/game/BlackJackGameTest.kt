package game

import domain.Holding
import domain.Person.DEALER
import domain.Person.SAM
import domain.Player
import domain.PlayerStatus.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private class BlackJackGameTest {

    @Test
    fun `should get correct result of blackjack game`() {
        //initialise the game with player as SAM
        val blackJackGame = BlackJackGame(Player(SAM))
        val deck: List<String> = listOf(
            "H3", "H8", "S7", "C2", "S10", "H5", "H10", "D3", "HA", "D4", "CA", "DJ",
            "C8", "S4", "HQ", "CQ", "S2", "HJ", "D2", "CK", "C7", "SA", "S9", "S8", "C4", "DA", "H6", "H4", "D10", "H9",
            "D5", "S5", "CJ", "C3", "H2", "D6", "H7", "C5", "S6", "D9", "DK", "SQ", "HK", "C6", "D7", "DQ", "SK", "C9",
            "SJ", "S3", "D8", "C10"
        )

        val gameResult = blackJackGame.play(deck)

        assertEquals(SAM, gameResult.winner)
        assertEquals(listOf("H3", "S7", "S10"), gameResult.playersHoldingMap[SAM])
        assertEquals(listOf("H8", "C2", "H5", "H10"), gameResult.playersHoldingMap[DEALER])
    }

    @Test
    fun `should correctly add to player holding`() {
        val holding = Holding()

        holding.add("SA")
        assertEquals(11, holding.score)
        assertEquals(listOf("SA"), holding.cards)

        holding.add("H5")
        assertEquals(16, holding.score)
        assertEquals(listOf("SA", "H5"), holding.cards)
    }

    @Test
    fun `should get correct player status on basis of score`() {
        assertEquals(11.getPlayerStatus(), CONTINUE)
        assertEquals(21.getPlayerStatus(), BLACKJACK)
        assertEquals(25.getPlayerStatus(), BUST)
    }
}