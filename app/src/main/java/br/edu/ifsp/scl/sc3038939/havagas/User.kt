package br.edu.ifsp.scl.sc3038939.havagas

import java.time.LocalDate

class User {
    private var name: String
    private var email: String
    private var phone: Number
    private var cellphone: Number
    private var dateBirth: LocalDate
    private var educational: String
    private var gender: String
    private var updateEmails: Boolean = false

    constructor(
        updateEmails: Boolean,
        gender: String,
        educational: String,
        dateBirth: LocalDate,
        cellphone: Number,
        phone: Number,
        email: String,
        name: String
    ) {
        this.updateEmails = updateEmails
        this.gender = gender
        this.educational = educational
        this.dateBirth = dateBirth
        this.cellphone = cellphone
        this.phone = phone
        this.email = email
        this.name = name
    }
}