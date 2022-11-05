package domain.state

sealed class CellState {
    object Empty : CellState()
    object Wall : CellState()
    data class Number(val number: Int) : CellState()
}
