package com.arjndev.spring_start

import io.swagger.v3.oas.models.Operation
import org.springdoc.core.customizers.OperationCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod


@Component
class SwaggerConfig {
    @Bean
    fun customize(): OperationCustomizer {
        return OperationCustomizer { operation: Operation, handlerMethod: HandlerMethod? ->
            operation

        }
    }

//    @Bean
//    fun healthOpenApiCustomiser(): OpenApiCustomizer? {
//        return OpenApiCustomizer { openApi ->
//            openApi.getPaths().entries.stream()
//                .forEach { stringPathItemEntry ->
//                    stringPathItemEntry.value.readOperations().forEach { operation ->
//                        val apiResponses: ApiResponses = operation.responses
//                        val apiResponse: ApiResponse = ApiResponse().description("Custom Error")
//                            .content(
//                                Content()
//                                    .addMediaType(MediaType.APPLICATION_JSON_VALUE,
//                                        io.swagger.v3.oas.models.media.MediaType()
//                                    ),
//                            )
//                        apiResponses.addApiResponse("500", apiResponse)
//                    }
//                }
//        }
//    }
}
