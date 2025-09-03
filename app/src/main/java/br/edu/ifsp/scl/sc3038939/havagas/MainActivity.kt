package br.edu.ifsp.scl.sc3038939.havagas

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import br.edu.ifsp.scl.sc3038939.havagas.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cbTel.setOnClickListener { showMobilePhone() }
        binding.submit
            .setOnClickListener {
                println(User(binding.nome.text.toString(),
                    binding.email.text.toString(),
                    binding.telefone.text.toString(),
                    binding.telefoneCel.text.toString(),
                    binding.dataNasc.text.toString(),
                    "Graduacao",
                    getGender(),
                    binding.checkBoxEmail.isChecked))
            }

        binding.dataNasc.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                val str = binding.dataNasc.text.toString()
                if(str.length == 2 && !str.contains("/")) binding.dataNasc.text.append("/")
                if(str.length == 5 && Regex("/").findAll(str).count() != 2)binding.dataNasc.text.append("/")
            }
        })
    }

    fun showMobilePhone(){
        if(binding.cbTel.isChecked)
            binding.telefoneCel.visibility = View.VISIBLE
        else
            binding.telefoneCel.visibility = View.GONE
    }
    fun getGender(): String {
        val male = binding.male
        val fem = binding.female
        if(male.isChecked) return male.text.toString()
        return fem.text.toString()
    }
}