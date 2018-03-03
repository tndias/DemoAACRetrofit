package br.com.psoa.demoaacretrofit.entities

/**
 *
 * Brazilian address definition
  */
data class Address(
        val cep: String,
        val logradouro: String,
        val complemento: String,
        val bairro: String,
        val localidade: String,
        val uf: String,
        val unidade: String,
        val ibge: String,
        val gia: String)

