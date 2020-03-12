package com.donasikode.amil.backend.models


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("app_roles")
    var appRoles: List<String?>?,
    @SerializedName("assigned_areas")
    var assignedAreas: List<String?>?,
    @SerializedName("code")
    var code: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("fullname")
    var fullname: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("phones")
    var phones: List<String?>?,
    @SerializedName("photo")
    var photo: String?,
    @SerializedName("roles")
    var roles: Roles?,
    @SerializedName("username")
    var username: String?
)