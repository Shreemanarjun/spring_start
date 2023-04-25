package com.arjndev.spring_start.routes.hello

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@RestController()
@Tag(name = "Hello", description = "Hello World!")
class HelloController : IHello {
    override fun index(): String {
        return "Greetings from Spring Boot!"
    }
}



fun appRouter() = router {
    "/arjun".nest {
        "/hello/{name}".nest {
            GET { serverRequest ->
                return@GET ServerResponse.ok().body("Hey ${serverRequest.param("name").get()} ")
            }
        }
    }
}

