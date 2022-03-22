package com.example.treino1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    fun getPersonagemService() =
        retrofit.create(PersonagemService::class.java)

    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}