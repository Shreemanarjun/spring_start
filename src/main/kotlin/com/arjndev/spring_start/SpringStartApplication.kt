package com.arjndev.spring_start

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableAutoConfiguration
@SpringBootApplication
class SpringStartApplication

fun main(args: Array<String>) {
	runApplication<SpringStartApplication>(*args)
}


