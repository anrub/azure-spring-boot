package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {
    @Value("\${testKey}")
    lateinit var username: String

    @GetMapping("/out")
    fun blog(): String {
        return "hello world"
    }

    @GetMapping("/key")
    fun key(): String {
        return username
    }

}
