package com.arjndev.spring_start.routes.todo

import com.arjndev.spring_start.errors.ErrorResponse
import com.arjndev.spring_start.model.Todo
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RequestMapping("/api/todos")
internal interface ITodoApi {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    fun findAll(): ResponseEntity<List<Todo?>?>

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Get a todo by its id")
    @ApiResponse(
        responseCode = "400", description = "Invalid id supplied",
        content = [
            Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = ErrorResponse::class, ),
                examples = [  ExampleObject(value = "{"
                        + "\"message\": \"Invalid ID Supplied\"}")]
            ),
        ],
    )

    @ApiResponse(
        responseCode = "500", description = "Internal server error",
        content = [
            Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = Schema(implementation = ErrorResponse::class),
                examples = [  ExampleObject(value = "{"
                        + "\"message\": \"Internal server error\"}")]
            ),
        ],
    )
    fun findById(@PathVariable id: String?): ResponseEntity<Todo>

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun save(@RequestBody todo: Todo?): ResponseEntity<Todo>?

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    fun update(@PathVariable id: String?, @RequestBody todo: Todo?): ResponseEntity<Todo>?

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String?)
}