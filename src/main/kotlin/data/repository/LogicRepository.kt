package data.repository

import domain.enums.Direction
import domain.state.Node

/**
 * Responsible for changing the current game state.
 */
class LogicRepository(private val node: Node) {

    /**
     * Moves the current state depending on [Direction]
     */
    fun playerMove(direction: Direction) {
        node.move(direction)
    }

    /**
     * Hands the control to the computer to play using DFS algorithm.
     */
    fun dfs(node: Node, visited: MutableSet<Node> = mutableSetOf()) {
        if(node.isFinal()) return
        visited.add(node)
        val nextStates = node.getNextStates().filter { !visited.contains(it) }
        for (state in nextStates) {
            state.printState()
            dfs(state, visited)
        }
        visited.remove(node)
    }

    /**
     * Hands the control to the computer to play using BFS algorithm.
     */
    fun bfs() {
        TODO("Not yet implemented")
    }

    /**
     * Hands the control to the computer to play using USC algorithm.
     */
    fun usc() {
        TODO("Not yet implemented")
    }

    /**
     * Hands the control to the computer to play using AStar algorithm.
     */
    fun aStar() {
        TODO("Not yet implemented")
    }
}