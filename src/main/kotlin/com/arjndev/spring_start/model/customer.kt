package com.arjndev.spring_start.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class Customer(
    @get:Valid @field:NotEmpty(message = "Mandatory field: Name is missing in Request Body")
    @field:Size(min = 2)
    @Schema(example = "John")
    val name: String
)