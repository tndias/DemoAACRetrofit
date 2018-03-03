package br.com.psoa.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import br.com.psoa.demoaacretrofit.entities.AddressResponse
import br.com.psoa.demoaacretrofit.repositories.AddressRepository
import br.com.psoa.demoaacretrofit.repositories.AddressRepositoryImpl

class MainViewModel : ViewModel () {

    private val addressRepository: AddressRepository
    private val mApiResponse : MediatorLiveData<AddressResponse>
    val apiResponse: LiveData<AddressResponse> get() = mApiResponse


    init {
        addressRepository = AddressRepositoryImpl()
        mApiResponse = MediatorLiveData()

    }

    fun search (cep: String) : LiveData<AddressResponse> {

        mApiResponse.addSource(addressRepository.getAddress(cep)) {
            a -> mApiResponse.value = a
        }
        return mApiResponse
    }

}
