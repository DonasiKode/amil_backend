package com.donasikode.amil.backend.controllers

import com.donasikode.amil.backend.reponses.AddNewUserResponse
import com.donasikode.amil.backend.reponses.ErrorResponse
import com.donasikode.amil.backend.reponses.GetAllUserResponse
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.Context
import io.javalin.plugin.openapi.annotations.*

object UserController : BaseController {
    override fun initialize() {
        path("/users") {
            get(UserController::getAllUsers)
            post(UserController::addNewUser)
            path("/bulk") {
                post(UserController::addBulkUser)
            }
        }
    }

    @OpenApi(
        summary = "Get All Users",
        operationId = "getAllUsers",
        description = """
            Get all user.
        """,
        tags = ["Users"],
        responses = [
            OpenApiResponse("200", [OpenApiContent(GetAllUserResponse::class)]),
            OpenApiResponse("400", [OpenApiContent(ErrorResponse::class)]),
            OpenApiResponse("403", [OpenApiContent(ErrorResponse::class)])
        ]
    )
    private fun getAllUsers(ctx: Context) {

    }

    @OpenApi(
        summary = "Add New User",
        operationId = "addNewUser",
        description = """
            Add single user.
        """,
        tags = ["Users"],
        requestBody = OpenApiRequestBody([OpenApiContent(String::class)]),
        responses = [
            OpenApiResponse("200", [OpenApiContent(AddNewUserResponse::class)]),
            OpenApiResponse("400", [OpenApiContent(ErrorResponse::class)]),
            OpenApiResponse("403", [OpenApiContent(ErrorResponse::class)])
        ]
    )
    private fun addNewUser(ctx: Context) {

    }

    @OpenApi(
        summary = "Add new Users Bulk",
        operationId = "addBulkUser",
        description = """
            Add Multiple user at once. Need to upload excel file for it. response is list of users.
        """,
        tags = ["Users"],
        fileUploads = [
            OpenApiFileUpload("Users", false, "Excel file for bulk user upload",  true)
        ],
        responses = [
            OpenApiResponse("200", [OpenApiContent(GetAllUserResponse::class)]),
            OpenApiResponse("400", [OpenApiContent(ErrorResponse::class)]),
            OpenApiResponse("403", [OpenApiContent(ErrorResponse::class)])
        ]
    )
    private fun addBulkUser(ctx: Context) {

    }

}