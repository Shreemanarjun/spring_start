package com.arjndev.spring_start.model

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty


data class Todo(
   @field:NotEmpty @field:NotBlank
   @Schema(example = "0")
   var id: String? = null,
   @Schema(example = "working on spring")
    var text: String? = null
)