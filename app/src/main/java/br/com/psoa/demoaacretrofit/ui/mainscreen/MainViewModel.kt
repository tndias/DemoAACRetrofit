package br.com.psoa.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.psoa.demoaacretrofit.entities.AddressResponse
import br.com.psoa.demoaacretrofit.repositories.AddressRepository
import br.com.psoa.demoaacretrofit.repositories.AddressRepositoryImpl

class MainViewModel : ViewModel() {

    private val addressRepository: AddressRepository
    private val mApiResponse: MediatorLiveData<AddressResponse>
    val apiResponse: LiveData<AddressResponse> get() = mApiResponse
    val isLoading: MutableLiveData<Boolean>

    init {
        addressRepository = AddressRepositoryImpl()
        mApiResponse = MediatorLiveData()
        isLoading = MutableLiveData()

    }

    fun search(cep: String): LiveData<AddressResponse> {
        isLoading.postValue(true)
        mApiResponse.addSource(addressRepository.getAddress(cep)) { a ->
            mApiResponse.value = a
            isLoading.postValue(false)
        }

        return mApiResponse
    }

}
