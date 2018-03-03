package br.com.psoa.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import android.location.Address
import br.com.psoa.demoaacretrofit.entities.AddressResponse

interface AddressRepository {
    fun getAddress (cep: String): LiveData<AddressResponse>;
}