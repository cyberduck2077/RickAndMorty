package com.example.kubsaunews.domain.models


data class CharacterModel(
    var id:Int = 0,
    var created: String = "",
    var episode: List<String> = emptyList(),
    var gender: String = "",
    var id_in_server: Int = 0,
    var image: String = "",
    var name: String = "",
    var species: String = "",
    var status: String = "",
    var type: String = "",
    var url: String = "",
    var origin_name: String = "",
    var origin_url: String = "",
    var location_name: String = "",
    var location_url: String = "",
)
