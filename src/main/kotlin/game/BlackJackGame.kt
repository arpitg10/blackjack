package game

import domain.GameResult
import domain.Holding
import domain.Person.DEALER
import domain.Player
import domain.PlayerStatus
import domain.PlayerStatus.*
import util.getCardScore

class BlackJackGame(private val player: Player) {

    private val dealer: Player = Player(DEALER)

    fun play(deckOfCards: List<String>): GameResult {

        initialDistribution(player.holding, dealer.holding, deckOfCards)

        var index = 4 //Cards up to index 3 already distributed initially from deck

        var winner: Player? = null

        //Checking winner on basis of initially distribution of four cards
        if (player.holding.score == 21) winner = player
        if (player.holding.score > 21) winner = dealer else if (dealer.holding.score > 21) winner = player

        //Game continues if there's no winner after initial distribution
        while (winner == null) {
            if (player.holding.score < 17)
                winner = player.deal(card = deckOfCards[index++], otherPlayer = dealer)
            else
                winner = dealer.deal(card = deckOfCards[index++], otherPlayer = player)
        }

        return GameResult(winner.name, mapOf(player.name to player.holding.cards, DEALER to dealer.holding.cards))
    }


}

/* This function does initial distribution of four cards from deck to player and dealer. */
private fun initialDistribution(
    playerHolding: Holding,
    dealerHolding: Holding,
    deckOfCards: List<String>
) {
    playerHolding.add(card = deckOfCards[0])
    dealerHolding.add(card = deckOfCards[1])
    playerHolding.add(card = deckOfCards[2])
    dealerHolding.add(card = deckOfCards[3])
}

/* This function makes player deal with new card from deck and return the winner if game decisive deal happens. */
private fun Player.deal(card: String, otherPlayer: Player): Player? {
    this.holding.add(card)
    return when (this.holding.score.getPlayerStatus()) {
        BLACKJACK -> this
        BUST -> otherPlayer
        else -> null
    }
}

internal fun Holding.add(card: String) {
    this.cards.add(card)
    this.score += card.getCardScore()
}

internal fun Int.getPlayerStatus(): PlayerStatus {
    return if (this < 21) {
        CONTINUE
    } else if (this == 21) {
        BLACKJACK
    } else {
        BUST
    }
}
