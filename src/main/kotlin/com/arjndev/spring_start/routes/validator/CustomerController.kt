package com.arjndev.spring_start.routes.validator

import com.arjndev.spring_start.model.Customer
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Customer", description = "Customer APIS")
class CustomerController :ICustomer{
    override fun createCustomer(customer: Customer): ResponseEntity<Customer> {
        return ResponseEntity.ok(customer)
    }

    override fun checkValid(id: Int) {
        TODO("Not yet implemented")
    }

    override fun getNameOfDayByNumber(dayOfWeek: Int, year: String): String? {
        return "$dayOfWeek"
    }

}