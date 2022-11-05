package domain.mappers

import domain.enums.Direction

fun String.toDirection() = when(this[0]) {
    'd' -> Direction.RIGHT
    'a' -> Direction.LEFT
    'w' -> Direction.UP
    's' -> Direction.DOWN
    else -> Direction.UP
}