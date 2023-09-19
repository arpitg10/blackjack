package domain

import java.util.ArrayList

data class Player(val name: Person, val holding: Holding) {
    constructor(person: Person) : this(person, Holding())
}

data class Holding(
    var score: Int = 0,
    val cards: MutableList<String> = ArrayList(),
)
