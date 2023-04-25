package com.arjndev.spring_start.routes.validator

import com.arjndev.spring_start.model.Customer
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.Range
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*



@RequestMapping("/api/v1")
@Validated
internal interface ICustomer {
    @PostMapping("/customer")
    fun createCustomer(@Valid @RequestBody customer: Customer): ResponseEntity<Customer>

    @GetMapping("/validID/{id}")
    fun checkValid(@Valid @PathVariable("id") @Size(min = 8) id: Int)

    @GetMapping("/name-for-day")
    fun getNameOfDayByNumber(
        @Valid @RequestParam @NotNull @Range(min = 0, max = 7) dayOfWeek: Int,
        @Valid @RequestParam @NotBlank @Size(min = 3) year: String
    ): String?
}