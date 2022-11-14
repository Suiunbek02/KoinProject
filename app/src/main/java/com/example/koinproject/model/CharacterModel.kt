package com.example.koinproject.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
data class CharacterModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val image: String,
)