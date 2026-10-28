package edu.cnm.deepdive.diceware.repository

import edu.cnm.deepdive.diceware.configuration.DicewareConfiguration
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

@Service
class DicewareWordListRepository(
    configuration: DicewareConfiguration,
    resourceLoader: ResourceLoader,
) : WordRepository {

    private val words: List<String>

    init {
        val wordListFile = configuration.wordList
        val resource = resourceLoader.getResource(wordListFile)
        words = resource.inputStream
            .bufferedReader()
            .useLines { lines ->
                lines
                    .filter { lineRegex.matches(it) }
                    .map { lineRegex.replace(it, "$1") }
                    .toList()
            }
    }

    override val size: Int
        get() = words.size

    override fun get(index: Int): String =
        words[index]

}

private val lineRegex = Regex("^\\s*\\d+\\s+(\\S+).*?$")