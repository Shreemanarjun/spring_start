package com.arjndev.spring_start.routes.validator

import com.arjndev.spring_start.model.ErrorDetails
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime






@ControllerAdvice
class CustomerExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun handle(exception: ConstraintViolationException): ResponseEntity<Any?>? {
        val fieldErrors = exception.constraintViolations
        val errorMapping = fieldErrors.associate { it.propertyPath.last().toString() to it.message }

        val errorDetails = ErrorDetails(
            timestamp = LocalDateTime.now(),
            message = "Validation Failed",
            details = errorMapping
        )
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {

        val fieldErrors: List<FieldError> = ex.fieldErrors
        val errorMapping = fieldErrors.associate { it.field to it.defaultMessage }

        val errorDetails = ErrorDetails(
            timestamp = LocalDateTime.now(),
            message = "Validation Failed",
            details = errorMapping
        )
        return ResponseEntity(errorDetails, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}

