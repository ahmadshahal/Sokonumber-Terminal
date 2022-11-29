package presentation

import data.repositories.LogicRepository
import domain.enums.GameStrategy
import domain.mappers.toDirection
import domain.mappers.toGameLevel
import domain.mappers.toGameStrategy
import domain.state.Node
import presentation.utils.printBoard
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {

    println("Choose The Game Strategy")
    GameStrategy.values().forEach { gameStrategy ->
        println("${gameStrategy.ordinal}- ${gameStrategy.name} ")
    }
    val gameStrategy = readln().toGameStrategy()

    println("Choose The Game Level: ")
    (1..6).toList().forEach { print("$it ") }
    println()
    val gameLevel = readln().toGameLevel()

    val node = Node(board = gameLevel.initBoard, finalBoard = gameLevel.finalBoard)
    println("Final Board to achieve:")
    printBoard(gameLevel.finalBoard)
    printBoard(gameLevel.initBoard)

    val logicRepository = LogicRepository(node = node)

    when(gameStrategy) {
        GameStrategy.USER -> {
            while (!node.isFinal()) {
                val direction = readln().toDirection()
                logicRepository.playerMove(direction = direction)
                node.printState()
            }
        }
        GameStrategy.DFS -> {
            println("DFS Playing:")
            logicRepository.dfs(node = node)
        }
        GameStrategy.BFS -> {
            println("BFS Playing:")
            logicRepository.bfs(node = node)
        }
        GameStrategy.UCS -> {
            println("UCS Playing:")
            logicRepository.ucs(node = node)
        }
        GameStrategy.A_STAR -> {
            println("AStar Playing:")
            logicRepository.aStar(node = node)
        }
        GameStrategy.TRY_ALL -> {
            val dfsDuration = measureTime { logicRepository.dfs(node = node) }
            val bfsDuration = measureTime { logicRepository.bfs(node = node) }
            val ucsDuration = measureTime { logicRepository.ucs(node = node) }
            println("DFS: ${dfsDuration.inWholeMilliseconds} ms")
            println("BFS: ${bfsDuration.inWholeMilliseconds} ms")
            println("UCS: ${ucsDuration.inWholeMilliseconds} ms")
        }
    }
}