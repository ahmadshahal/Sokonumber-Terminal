package domain.state

import domain.enums.Direction
import presentation.utils.printBoard


/**
 * A Data class that defines the state in a state space.
 * Takes [board] as the current state.
 * Takes [finalBoard] as the final state.
 */
data class Node(
    /**
     * The Current Node State.
     */
    private var board: List<List<CellState>>,
    /**
     * The Final Node State.
     */
    private val finalBoard: List<List<CellState>>
) {

    private var parent: Node? = null

    /**
     * Moves the current state to another state depending on the [direction].
     */
    fun move(direction: Direction) {
        val newBoard = board.map { it.toMutableList() }.toMutableList()
        val numberCellsPositions = getNumberCellsPositions()
        for (position in numberCellsPositions) {
            val nextI = position.first + direction.verticalDelta
            val nextJ = position.second + direction.horizontalDelta
            if (positionValid(nextI = nextI, nextJ = nextJ)) {
                newBoard[position.first][position.second] = board[nextI][nextJ]
                newBoard[nextI][nextJ] = board[position.first][position.second]
            }
        }
        board = newBoard
    }

    /**
     * Returns all possible to achieve states.
     */
    fun getNextStates(): List<Node> {
        val nextStates = mutableListOf<Node>()
        val possibleDirections = validDirections()
        for (direction in possibleDirections) {
            val nextNode = copy()
            nextNode.parent = this
            nextNode.move(direction)
            nextStates.add(nextNode)
        }
        return nextStates
    }

    /**
     * Prints the current state.
     */
    fun printState() = printBoard(board = board)

    /**
     * Prints the path until this node.
     */
    fun printPath() {
        val path = mutableListOf<Node>()
        var currentNode = this
        path.add(currentNode)
        while (currentNode.parent != null) {
            currentNode = currentNode.parent!!
            path.add(currentNode)
        }
        path.reverse()
        path.forEach { it.printState() }
        println("Found in Depth: ${path.size}")
        println("Took ${path.size - 1} Moves")
    }

    /**
     * Determines if the current stat is a final state.
     */
    fun isFinal() = finalBoard == board

    /**
     * A Helper Function that returns all Valid Directions.
     */
    private fun validDirections(): List<Direction> {
        val validDirections = mutableListOf<Direction>()
        val numberCellsPositions = getNumberCellsPositions()
        Direction.values().forEach { direction ->
            positionsLoop@ for (position in numberCellsPositions) {
                val nextI = position.first + direction.verticalDelta
                val nextJ = position.second + direction.horizontalDelta
                if (positionValid(nextI = nextI, nextJ = nextJ)) {
                    validDirections.add(direction)
                    break@positionsLoop
                }
            }
        }
        return validDirections
    }

    /**
     * A Helper Function to get all NumberCellsPositions.
     */
    private fun getNumberCellsPositions(): List<Pair<Int, Int>> {
        val numberCellsPositions = mutableListOf<Pair<Int, Int>>()
        for (i in board.indices)
            for (j in board[i].indices)
                if (board[i][j] is CellState.Number)
                    numberCellsPositions.add(Pair(i, j))
        return numberCellsPositions
    }

    /**
     * A Helper Function to determine if this position is valid or not.
     */
    private fun positionValid(nextI: Int, nextJ: Int): Boolean {
        val leftBound = -1
        val topBound = -1
        val bottomBound = board.size
        val rightBound = board[0].size
        // TODO: Find another way to calculate the right bound.
        val horizontalValid = nextJ in (leftBound + 1) until rightBound
        val verticalValid = nextI in (topBound + 1) until bottomBound
        if (horizontalValid && verticalValid) {
            val isNotWall = board[nextI][nextJ] !is CellState.Wall
            val isNotNumber = board[nextI][nextJ] !is CellState.Number
            if (isNotWall && isNotNumber) return true
        }
        return false
    }
}

