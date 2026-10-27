package edu.cnm.deepdive.diceware.controller

import edu.cnm.deepdive.diceware.service.PassphraseService
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/passphrases")
@Validated
class PassphraseController(private val service: PassphraseService) {

    @GetMapping(path = ["/generate"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPassphrase(
        @RequestParam
        @Min(0) @Max(10)
        length: Int = 5
    ): List<String> =
        service.generate(length)

}