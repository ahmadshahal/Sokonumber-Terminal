package presentation

import data.repositories.LogicRepository
import domain.enums.GameStrategy
import domain.mappers.toDirection
import domain.mappers.toGameLevel
import domain.mappers.toGameStrategy
import domain.state.Node
import presentation.utils.printBoard

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

    val logicRepository = LogicRepository(node = node)

    when(gameStrategy) {
        GameStrategy.USER -> {
            while (!node.isFinal()) {
                val direction = readln().toDirection()
                logicRepository.playerMove(direction = direction)
                node.printState()
            }
        }
        GameStrategy.DFS -> logicRepository.dfs(node = node)
        GameStrategy.BFS -> logicRepository.bfs(node = node)
        GameStrategy.UCS -> logicRepository.ucs(node = node)
        GameStrategy.A_STAR -> logicRepository.aStar(node = node)
    }
}