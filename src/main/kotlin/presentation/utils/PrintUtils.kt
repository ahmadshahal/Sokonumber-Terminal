package presentation.utils

import domain.state.CellState

fun printBoard(board: List<List<CellState>>) {
    for (i in board.indices) {
        for (j in board[i].indices) {
            when(val cellState = board[i][j]) {
                is CellState.Empty -> print(" ")
                is CellState.Wall -> print("⁕")
                is CellState.Number -> print(cellState.number)
            }
        }
        println()
    }
    println()
}