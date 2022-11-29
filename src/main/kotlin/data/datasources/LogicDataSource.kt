package data.datasources

import domain.state.Node
import java.util.PriorityQueue

/**
 * Contains the complex logic and algorithms used in the game.
 */
class LogicDataSource {

    var dfsVisitedNodes = 0

    /**
     * Classic DFS Algorithm.
     */
    fun dfs(node: Node, visited: MutableSet<Node> = mutableSetOf()): Boolean {
        if (node.isFinal()) {
            node.printPath()
            println("Visited Nodes: $dfsVisitedNodes")
            dfsVisitedNodes = 0
            return true
        }
        dfsVisitedNodes++
        val nextStates = node.getNextStates().filter { !visited.contains(it) }
        nextStates.forEach { visited.add(it) }
        for (state in nextStates) {
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
            val currentNode = queue.removeFirst()
            if (currentNode.isFinal()) {
                currentNode.printPath()
                break
            }
            currentNode.getNextStates()
                .filter { !visited.contains(it) }
                .forEach {
                    visited.add(it)
                    queue.add(it)
                }
        }
        println("Visited Nodes: ${visited.size}")
    }

    /**
     * UCS Algorithm AKA Dijkstra.
     */
    fun ucs(node: Node) {
        var finalNode: Node? = null
        val compareByCost: Comparator<Pair<Int, Node>> = compareBy { it.first }
        val costMap = mutableMapOf<Node, Int>()
        val priorityQueue = PriorityQueue(compareByCost)
        priorityQueue.add(Pair(0, node))
        while (priorityQueue.isNotEmpty()) {
            val (currentCost, currentNode) = priorityQueue.poll()
            val possiblePreviousCost = costMap[currentNode] ?: 100_000_000
            if (possiblePreviousCost < currentCost) continue
            if (currentNode.isFinal()) {
                // Saving the final state and searching for a better solution.
                // The last saved state will always be the best one.
                finalNode = currentNode
            }
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
        finalNode?.let {
            it.printPath()
            println("Final UCS Cost: ${costMap[it]}")
            println("Visited Nodes: ${costMap.size}")
        }
    }

    /**
     * AStar Algorithm.
     */
    fun aStar(node: Node) {
        TODO("Not yet implemented")
    }
}