package com.arjndev.spring_start

import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@AutoConfigureMockMvc
@SpringBootTest
class SpringStartApplicationTests(
    @Autowired val mvc: MockMvc, @Autowired
    val objectMapper: ObjectMapper
) {

    @Test
    fun contextLoads() {
    }


    @Test
    fun getHello() {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
    }

//    @Test
//    fun getApiHello() {
//        val response = NestedResponse( CustomResponse("Hello,This is a rest end point",100,
//            Customer(name = "Arjun sahu", id = 12)
//        ))
//        mvc.perform(MockMvcRequestBuilders.get("/api/hello").accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(
//                content().string(
//                    equalTo(objectMapper.writeValueAsString(response))
//                ),
//            )

    }


