package br.com.psoa.demoaacretrofit.api

import br.com.psoa.demoaacretrofit.entities.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressAPI {

    @GET("ws/{cep}/json")
    fun search(@Path("cep") cep: String) : Call<Address>

}