package br.com.psoa.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import br.com.psoa.demoaacretrofit.api.AddressAPI
import br.com.psoa.demoaacretrofit.entities.Address

import br.com.psoa.demoaacretrofit.entities.AddressResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddressRepositoryImpl : AddressRepository {

    private val addressAPI: AddressAPI

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://viacep.com.br")
                .build()
        addressAPI = retrofit.create(AddressAPI::class.java)

    }

    override fun getAddress(cep: String):
            LiveData<AddressResponse> {
        val liveData = MutableLiveData<AddressResponse>()


        addressAPI.search(cep)
                .enqueue(object : Callback<Address> {
                    override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                        liveData.value = AddressResponse(response?.body()!!)
                    }

                    override fun onFailure(call: Call<Address>?, t: Throwable?) {
                        liveData.value = AddressResponse(t!!)
                    }

                })
        return liveData
    }

}

