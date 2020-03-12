package com.donasikode.amil.backend

import com.donasikode.amil.backend.controllers.AuthController
import com.donasikode.amil.backend.controllers.UserController
import com.donasikode.amil.backend.reponses.ErrorResponse
import io.javalin.Javalin
import io.javalin.plugin.openapi.OpenApiOptions
import io.javalin.plugin.openapi.OpenApiPlugin
import io.javalin.plugin.openapi.ui.ReDocOptions
import io.javalin.plugin.openapi.ui.SwaggerOptions
import io.swagger.v3.oas.models.info.Info

const val PORT = 7070

fun main(vararg args: String) {
    Javalin.create {
        it.registerPlugin(getConfiguredOpenApiPlugin())
        it.defaultContentType = "application/json"
    }.routes {
        AuthController.initialize()
        UserController.initialize()
    }.start(PORT)

    println("Check out ReDoc docs at http://localhost:$PORT/redoc")
    println("Check out Swagger UI docs at http://localhost:$PORT/swagger-ui")

}

fun getConfiguredOpenApiPlugin() = OpenApiPlugin(
    OpenApiOptions(
        Info().apply {
            version("1.0")
            description("User API")
        }
    ).apply {
        path("/swagger-docs") // endpoint for OpenAPI json
        swagger(SwaggerOptions("/swagger-ui")) // endpoint for swagger-ui
        reDoc(ReDocOptions("/redoc")) // endpoint for redoc
        defaultDocumentation { doc ->
            doc.json("500", ErrorResponse::class.java)
            doc.json("503", ErrorResponse::class.java)
        }
    }
)