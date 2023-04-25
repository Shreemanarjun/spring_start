package com.arjndev.spring_start.model

import java.time.LocalDateTime

data class ErrorDetails(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val message: String,
    val details: Map<String, String?> =mapOf(),
)

