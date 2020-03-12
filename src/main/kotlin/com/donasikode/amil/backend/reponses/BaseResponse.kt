package com.donasikode.amil.backend.reponses

import com.donasikode.amil.backend.models.User

open class BaseResponse<T> {
    var data: T? = null
    var code: Int = 0
    var message: String? = null
    var error: APIError? = null
}


data class APIError(val code: Int, val cause: String)


class ErrorResponse : BaseResponse<Any?>()
class UserResponse : BaseResponse<User>()
class GetAllUserResponse : BaseResponse<List<User>>()
class AddNewUserResponse : BaseResponse<User>()