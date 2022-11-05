package domain.mappers

import domain.enums.GameStrategy

fun String.toGameStrategy() = when(this[0]) {
    '0' -> GameStrategy.USER
    '1' -> GameStrategy.DFS
    '2' -> GameStrategy.BFS
    '3' -> GameStrategy.USC
    '4' -> GameStrategy.A_STAR
    else -> GameStrategy.A_STAR
}