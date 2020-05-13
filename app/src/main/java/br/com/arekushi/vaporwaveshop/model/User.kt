package br.com.arekushi.vaporwaveshop.model

class User {

    var email : String? = null
    var password : String? = null

    constructor(email : String, password : String) {
        this.email = email
        this.password = password
    }

    constructor(email : String) {
        this.email = email
    }
}