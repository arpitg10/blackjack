package util

val rankScoreMap = mapOf(
    "2" to 2,
    "3" to 3,
    "4" to 4,
    "5" to 5,
    "6" to 6,
    "7" to 7,
    "8" to 8,
    "9" to 9,
    "10" to 10,
    "J" to 10, //Jack
    "Q" to 10, //Queen
    "K" to 10, //King
    "A" to 11 //Ace
)

fun String.getCardScore(): Int = rankScoreMap[this.substring(1)]!!
