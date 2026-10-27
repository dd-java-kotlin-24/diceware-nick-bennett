package edu.cnm.deepdive.diceware.repository

interface WordRepository {

    val size: Int

    operator fun get(index: Int): String

}