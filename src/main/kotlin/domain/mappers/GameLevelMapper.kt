package domain.mappers

import domain.enums.GameLevel

fun String.toGameLevel() = when(this[0]) {
    '1' -> GameLevel.FIRST
    '2' -> GameLevel.SECOND
    '3' -> GameLevel.Third
    '4' -> GameLevel.Fourth
    '5' -> GameLevel.FIFTH
    else -> throw Exception("Action isn't supported")
}