package br.com.psoa.demoaacretrofit.entities

class AddressResponse {

    var address: Address? = null
    var error: Throwable? = null

    constructor(address: Address) {
        this.address = address
    }

    constructor(error: Throwable) {
        this.error = error
    }

}