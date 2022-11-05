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
            val duration = measureTime {
                logicRepository.dfs(node = node)
            }
            println("DFS execution time: ${duration.inWholeMilliseconds} ms")
        }
        GameStrategy.BFS -> {
            val duration = measureTime {
                logicRepository.bfs(node = node)
            }
            println("BFS execution time: ${duration.inWholeMilliseconds} ms")
        }
        GameStrategy.UCS -> {
            val duration = measureTime {
                logicRepository.ucs(node = node)
            }
            println("UCS execution time: ${duration.inWholeMilliseconds}")
        }
        GameStrategy.A_STAR -> {
            val duration = measureTime {
                logicRepository.aStar(node = node)
            }
            println("A* execution time: ${duration.inWholeMilliseconds}")
        }
    }
}