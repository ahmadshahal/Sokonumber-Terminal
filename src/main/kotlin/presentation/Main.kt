package presentation

import data.repository.LogicRepository
import domain.mappers.toGameLevel
import domain.state.Node
import presentation.utils.printBoard

fun main() {
    println("Choose The Game Level: ")
    (1..7).toList().forEach { print("$it ") }
    println()
    val gameLevel = readln().toGameLevel()
    val node = Node(board = gameLevel.initBoard, finalBoard = gameLevel.finalBoard)
    printBoard(gameLevel.finalBoard)
    printBoard(gameLevel.initBoard)
    val logicRepository = LogicRepository(node = node)
    logicRepository.dfs(node)
//    while (!node.isFinal()) {
//        val direction = readln().toDirection()
//        logicRepository.playerMove(direction = direction)
//    }
}