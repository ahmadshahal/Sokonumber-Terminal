package domain.enums

enum class Direction(val horizontalDelta: Int, val verticalDelta: Int) {
    UP(0, -1),
    DOWN(0, +1),
    RIGHT(+1, 0),
    LEFT(-1, 0)
}