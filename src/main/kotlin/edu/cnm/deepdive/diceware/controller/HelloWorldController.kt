package edu.cnm.deepdive.diceware.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello-world")
class HelloWorldController {

    @GetMapping(path = ["/morning"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun goodMorning(): String =
        "Good morning, world!"

    @GetMapping(path = ["/afternoon"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun goodAfternoon(): String =
        "Good afternoon, world!"

    @GetMapping(path = ["/night"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun goodNight(): String =
        "Good night, world!"

}