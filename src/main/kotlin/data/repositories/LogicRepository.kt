package data.repositories

import data.datasources.LogicDataSource
import domain.enums.Direction
import domain.state.Node

/**
 * Responsible for changing the current game state.
 */
class LogicRepository(private val node: Node) {

    private val logicDataSource = LogicDataSource()

    /**
     * Moves the current state depending on [Direction]
     */
    fun playerMove(direction: Direction) = node.move(direction)

    /**
     * Hands the control to the computer to play using DFS algorithm.
     */
    fun dfs(node: Node) = logicDataSource.dfs(node = node)

    /**
     * Hands the control to the computer to play using BFS algorithm.
     */
    fun bfs(node: Node) = logicDataSource.bfs(node = node)

    /**
     * Hands the control to the computer to play using USC algorithm.
     */
    fun usc(node: Node) {
        TODO("Not yet implemented")
    }

    /**
     * Hands the control to the computer to play using AStar algorithm.
     */
    fun aStar(node: Node) {
        TODO("Not yet implemented")
    }
}