package br.edu.ifsp.scl.sc3038939.havagas

import java.time.LocalDate

class User {
    private var name: String
    private var email: String
    private var phone: String
    private var cellphone: String
    private var dateBirth: String
    private var educational: String
    private var gender: String
    private var updateEmails: Boolean = false

    constructor(
        updateEmails: Boolean,
        gender: String,
        educational: String,
        dateBirth: String,
        cellphone: String,
        phone: String,
        email: String,
        name: String
    ) {
        this.updateEmails = updateEmails
        this.gender = gender
        this.educational = educational
        this.dateBirth = dateBirth
        if(!cellphone.contains("^[0-9]{10,11}$"))
            this.cellphone = ""
        this.cellphone = cellphone
        if(!phone.contains("[0-9]{10,10}"))
            throw IllegalStateException("Numero de telefone invalido")
        this.phone = phone
        if(!email.contains("^[a-zA-Z0-9\\.]{2,}[@][a-zA-Z0-9\\.]{2,}[\\.com]\$|^^[a-zA-Z0-9\\.]{2,}[@][a-zA-Z0-9\\.]{2,}[\\.com\\.br]\$"))
            throw IllegalStateException("E-mail invalido.")
        this.email = email
        this.name = name
    }

    override fun toString(): String {
        return "User(name='$name', email='$email', phone='$phone', cellphone='$cellphone', dateBirth='$dateBirth', educational='$educational', gender='$gender', updateEmails=$updateEmails)"
    }


}