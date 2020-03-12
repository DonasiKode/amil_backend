package com.donasikode.amil.backend.models


import com.google.gson.annotations.SerializedName

data class Roles(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?
)