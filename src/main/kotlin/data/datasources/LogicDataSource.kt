package data.datasources

import domain.state.Node

/**
 * Contains the complex logic and algorithms used in the game.
 */
class LogicDataSource {

    /**
     * Classic DFS Algorithm.
     */
    fun dfs(node: Node, visited: MutableSet<Node> = mutableSetOf()): Boolean {
        if(node.isFinal()) return true
        visited.add(node)
        val nextStates = node.getNextStates().filter { !visited.contains(it) }
        for (state in nextStates) {
            state.printState()
            if(dfs(state, visited)) return true
        }
        return false
    }

    /**
     * Classic BFS Algorithm.
     */
    fun bfs(node: Node) {
        val queue = mutableListOf(node)
        val visited = mutableSetOf<Node>()
        while (queue.isNotEmpty()) {
            val currentNode = queue.first()
            currentNode.printState()
            if(currentNode.isFinal()) break
            visited.add(currentNode)
            val nextStates = currentNode.getNextStates().filter { !visited.contains(it) }
            queue.addAll(nextStates)
            queue.removeFirst()
        }
    }

    /**
     * UCS Algorithm AKA Dijkstra.
     */
    fun usc(node: Node) {
        TODO("Not yet implemented")
    }

    /**
     * AStar Algorithm.
     */
    fun aStar(node: Node) {
        TODO("Not yet implemented")
    }
}