package com.arjndev.spring_start.routes.todo


import com.arjndev.spring_start.model.Todo
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.annotation.PostConstruct
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.jvm.optionals.getOrNull


@RestController
@Tag(name = "TODO", description = "TODO APIS")
class TodoController : ITodoApi {
    private lateinit var todos: MutableList<Todo>
    override fun findAll(): ResponseEntity<List<Todo?>?> {
        return ResponseEntity.ok(todos)
    }

    override fun findById(id: String?): ResponseEntity<Todo> {
        val todo= todos.firstOrNull { todo: Todo -> todo.id.equals(id) }
        return when {
            todo!=null -> {
                ResponseEntity.ok(todo)
            }
            else -> {
                ResponseEntity.of(ProblemDetail.forStatus(404).apply {
                    detail="Todo with $id not found"
                }).build()
            }
        }

    }

    override fun save(todo: Todo?): ResponseEntity<Todo>? {
        if (todo != null) {
            todos.add(todo)
        }
        return ResponseEntity.ok(todo)
    }





    override fun update(id: String?, todo: Todo?): ResponseEntity<Todo>? {
        for (t in todos) {
            if (t.id.equals(id)) {
                if (todo != null) {
                    t.id=todo.id
                   t.text= todo.text
                }
            }
        }
        return ResponseEntity.ok(todo)
    }

    override fun delete(id: String?) {
        todos.removeIf { t: Todo -> t.id.equals(id) }
    }

    @PostConstruct
    fun onInit() {
        Stream.of("Groceries", "Lisa's birthday")
            .map {
                Todo(UUID.randomUUID().toString(), it)
            }
            .collect(Collectors.toList()).also { todos = it }
    }
}