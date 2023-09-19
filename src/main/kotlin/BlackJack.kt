import domain.GameResult
import domain.Person.DEALER
import domain.Person.SAM
import domain.Player
import exception.GameException
import exception.InvalidArgumentException
import game.BlackJackGame
import util.FileReader.Companion.getFileDataAsString
import util.getShuffledDeck
import util.getValidatedCards

fun main(args: Array<String>) {
    println("\n\n************************************\nWelcome to the Game of Blackjack !!!\n************************************\n")

    val deck: List<String>

    try {
        deck = when (args.size) {
            0 -> getShuffledDeck()
            1 -> getValidatedCards(getFileDataAsString(args[0]))
            else -> throw InvalidArgumentException("Please provide only one program argument")
        }

        val gameResult: GameResult = BlackJackGame(Player(SAM)).play(deck)

        println("**************** Game of Blackjack result ****************")
        println(gameResult.winner.personName)
        println("${SAM.personName} : ${gameResult.playersHoldingMap[SAM]}")
        println("${DEALER.personName} : ${gameResult.playersHoldingMap[DEALER]}")
        println("************************ Finished ************************")

    } catch (e: GameException) {
        println(e.message)
        e.printStackTrace()
    } catch (e: Exception) {
        println("Unknown error occurred while playing the game: ${e.message}")
        e.printStackTrace()
    }
}
