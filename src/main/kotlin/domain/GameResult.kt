package domain

data class GameResult(
    val winner: Person,
    val playersHoldingMap: Map<Person, List<String>>
)
