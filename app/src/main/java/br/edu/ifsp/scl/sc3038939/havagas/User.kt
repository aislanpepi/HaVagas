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
    private var yearConclusion: Number
    private var interVacancy: String = ""
    private var orientator: String = ""
    private var monography: String = ""
    private var institute: String = ""


    constructor(
        name: String,
        email: String,
        phone: String,
        cellphone: String,
        dateBirth: String,
        educational: String,
        yearConclusion: Number,
        monography: String,
        institute: String,
        orientator: String,
        gender: String,
        interVacancy: String,
        updateEmails: Boolean
    ) {
        this.updateEmails = updateEmails
        this.gender = gender
        this.educational = educational
        this.dateBirth = dateBirth
        if(!cellphone.contains(Regex("^[0-9]{10,11}$")))
            this.cellphone = ""
        this.cellphone = cellphone
        if(!phone.contains(Regex("[0-9]{10}")))
            println("Numero de telefone invalido")
        this.phone = phone
        if(!email.contains(Regex("^[a-zA-Z0-9.]{2,}@[a-zA-Z0-9.]{2,}[.com]$|^[a-zA-Z0-9.]{2,}@[a-zA-Z0-9.]{2,}[.combr]$")))
            println("Email invalido.")
        this.email = email
        this.name = name
        this.interVacancy = interVacancy
        this.yearConclusion = yearConclusion
        this.orientator = orientator
        this.institute = institute
        this.monography = monography
    }



    override fun toString(): String {
        return "Nome='$name'\n" +
                "E-mail='$email'\n" +
                "Telefone Fixo='$phone'\n" +
                "Telefone Movel='$cellphone'\n" +
                "Data de Nascimento='$dateBirth'\n" +
                "Formação='$educational'\n" +
                "Ano de conclusão='$yearConclusion'\n"+
                "Instituicão='$institute'\n"+
                "Titulo da monografia='$monography'\n"+
                "Orientador='$orientator'\n"+
                "Sexo='$gender'\n"+
                "Vaga de Interesse='$interVacancy'"
    }
}