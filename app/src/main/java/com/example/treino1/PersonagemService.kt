package com.example.treino1

import retrofit2.http.GET

interface PersonagemService {

    @GET("character")
    suspend fun getPersonagens(): Any
}