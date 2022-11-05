package domain.mappers

import domain.enums.GameStrategy

fun String.toGameStrategy() = when(this[0]) {
    '0' -> GameStrategy.USER
    '1' -> GameStrategy.DFS
    '2' -> GameStrategy.BFS
    '3' -> GameStrategy.UCS
    '4' -> GameStrategy.A_STAR
    '5' -> GameStrategy.TRY_ALL
    else -> throw Exception("Action isn't supported")
}