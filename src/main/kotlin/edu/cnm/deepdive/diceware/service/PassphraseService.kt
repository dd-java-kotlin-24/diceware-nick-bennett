package edu.cnm.deepdive.diceware.service

interface PassphraseService {

    fun generate(length: Int): List<String>

}