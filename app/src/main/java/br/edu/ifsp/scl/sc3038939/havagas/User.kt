package br.edu.ifsp.scl.sc3038939.havagas

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
        name: String,
        email: String,
        phone: String,
        cellphone: String,
        dateBirth: String,
        educational: String,
        gender: String,
        updateEmails: Boolean
    ) {
        this.updateEmails = updateEmails
        this.gender = gender
        this.educational = educational
        this.dateBirth = dateBirth
        if(!cellphone.contains("^[0-9]{10,11}$"))
            this.cellphone = ""
        this.cellphone = cellphone
        if(!phone.contains(Regex("[0-9]{10}")))
            throw IllegalStateException("Numero de telefone invalido")
        this.phone = phone
        if(!email.contains(Regex("^[a-zA-Z0-9.]{2,}@[a-zA-Z0-9.]{2,}[.com]$|^[a-zA-Z0-9.]{2,}@[a-zA-Z0-9.]{2,}[.combr]$")))
            throw IllegalStateException("E-mail invalido.")
        this.email = email
        this.name = name
    }

    override fun toString(): String {
        return "Name='$name'\n" +
                "E-mail='$email'\n" +
                "Telephone='$phone'\n" +
                "Cellphone='$cellphone'\n" +
                "Date of Birth='$dateBirth'\n" +
                "Educational='$educational'\n" +
                "Gender='$gender"
    }


}