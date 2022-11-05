package domain.enums

import domain.state.CellState

enum class GameLevel(
    val initBoard: List<List<CellState>>,
    val finalBoard: List<List<CellState>>
) {
    FIRST(
        initBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Empty, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Wall,),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
        finalBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Number(1), CellState.Wall,),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        )
    ),
    SECOND(
        initBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Wall, CellState.Number(2), CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
        finalBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Wall, CellState.Number(2), CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        )
    ),
    Third(
        initBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Empty, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Empty, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Number(2), CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
        finalBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Number(2), CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Empty, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Number(1), CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
    ),
    Fourth(
        initBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Wall, CellState.Number(2), CellState.Wall, CellState.Number(3), CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Empty, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
        finalBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(3), CellState.Empty, CellState.Number(2), CellState.Empty, CellState.Number(1), CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Empty, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
    ),
    FIFTH(
        initBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Number(2), CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Number(3), CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Empty, CellState.Number(4), CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
        finalBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Number(1), CellState.Empty, CellState.Wall, CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Number(2), CellState.Empty, CellState.Number(4), CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Number(3), CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
    ),
    SIXTH(
        initBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Number(2), CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Number(1), CellState.Empty, CellState.Number(5), CellState.Wall),
            listOf(CellState.Wall, CellState.Number(3), CellState.Wall, CellState.Number(4), CellState.Empty, CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
        finalBoard = listOf(
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Number(2), CellState.Wall, CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Empty, CellState.Number(1), CellState.Number(5), CellState.Wall),
            listOf(CellState.Wall, CellState.Empty, CellState.Wall, CellState.Number(3), CellState.Number(4), CellState.Wall),
            listOf(CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall, CellState.Wall),
        ),
    ),
}