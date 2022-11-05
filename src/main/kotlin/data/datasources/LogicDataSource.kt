package data.datasources

import domain.state.Node
import java.util.PriorityQueue

/**
 * Contains the complex logic and algorithms used in the game.
 */
class LogicDataSource {

    /**
     * Classic DFS Algorithm.
     */
    fun dfs(node: Node, visited: MutableSet<Node> = mutableSetOf()): Boolean {
        if (node.isFinal()) return true
        visited.add(node)
        val nextStates = node.getNextStates().filter { !visited.contains(it) }
        for (state in nextStates) {
            state.printState()
            if (dfs(state, visited)) return true
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
            if (currentNode.isFinal()) break
            visited.add(currentNode)
            val nextStates = currentNode.getNextStates().filter { !visited.contains(it) }
            queue.addAll(nextStates)
            queue.removeFirst()
        }
    }

    /**
     * UCS Algorithm AKA Dijkstra.
     */
    fun ucs(node: Node) {
        val compareByCost: Comparator<Pair<Int, Node>> = compareByDescending { it.first }
        val costMap = mutableMapOf<Node, Int>()
        val priorityQueue = PriorityQueue(compareByCost)
        priorityQueue.add(Pair(0, node))
        while (priorityQueue.isNotEmpty()) {
            val (currentCost, currentNode) = priorityQueue.poll()
            currentNode.printState()
            val possiblePreviousCost = costMap[currentNode] ?: 100_000_000
            if (possiblePreviousCost < currentCost) continue
            if (currentNode.isFinal()) break
            val nextStates = currentNode.getNextStates()
            nextStates.forEach { child ->
                val possiblePreviousChildCost = costMap[child] ?: 100_000_000
                val childCost = currentCost + 1
                if(childCost < possiblePreviousChildCost) {
                    costMap[child] = childCost
                    priorityQueue.add(Pair(childCost, child))
                }
            }
        }
    }

    /**
     * AStar Algorithm.
     */
    fun aStar(node: Node) {
        TODO("Not yet implemented")
    }
}