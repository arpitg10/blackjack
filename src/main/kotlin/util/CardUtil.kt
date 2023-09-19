package util

import domain.Suit
import exception.InvalidDeckException

private val cardRegex = Regex("[CDHS]([2-9]|10|[JQKA])\$")

internal fun String.isValidCard(): Boolean = cardRegex.matches(this)

fun getValidatedCards(data: String): List<String> {
    val invalidCards = mutableListOf<String>()
    val deck = data
        .split(",")
        .map {
            val card = it.trim()
            if (!card.isValidCard()) invalidCards.add(card)
            card
        }

    if (invalidCards.isNotEmpty()) throw InvalidDeckException("Invalid card(s) are found in the provided deck: $invalidCards")

    if (deck.size != 52) throw InvalidDeckException("Please provide a deck on valid 52 cards.")

    if (deck.size != deck.toSet().size) throw InvalidDeckException("Please provide a deck of cards without repetition.")

    return deck
}

fun getShuffledDeck(): List<String> = getPlayingCards().also { it.shuffle() }

private fun getPlayingCards(): MutableList<String> =
    ArrayList<String>().also { cards ->
        Suit.values()
            .forEach { suit: Suit ->
                rankScoreMap.keys
                    .forEach { rank: String -> cards.add(suit.code.plus(rank)) }
            }
    }
