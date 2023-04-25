package com.arjndev.spring_start.routes.hello

import org.springframework.web.bind.annotation.GetMapping

interface IHello {
    @GetMapping("/")
    fun index(): String
}