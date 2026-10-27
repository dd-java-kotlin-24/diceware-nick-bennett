package edu.cnm.deepdive.diceware.service

import edu.cnm.deepdive.diceware.repository.WordRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class DicewareService(
    private val repository: WordRepository,
    private val rng: Random,
) : PassphraseService {

    override fun generate(length: Int): List<String> =
        (1..length)
            .map {
                val position = rng.nextInt(repository.size)
                repository[position]
            }

}