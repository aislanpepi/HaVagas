package br.edu.ifsp.scl.sc3038939.havagas

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3038939.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner = binding.formacao
        val educational = resources.getStringArray(R.array.form_array)

        ArrayAdapter.createFromResource(this,
            R.array.form_array,
            android.R.layout.simple_spinner_item)
            .also { adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                spinner.adapter = adapter
            }

        var selectedEdu = ""

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
               selectedEdu = educational[position]
                when (selectedEdu) {
                    "Graduação", "Especialização" -> {
                        binding.instituicao.visibility = View.VISIBLE
                        binding.titleMon.visibility = View.GONE
                        binding.orientator.visibility = View.GONE
                    }
                    "Mestrado", "Doutorado" -> {
                        binding.instituicao.visibility = View.VISIBLE
                        binding.titleMon.visibility = View.VISIBLE
                        binding.orientator.visibility = View.VISIBLE
                    }
                    "Fundamental", "Medio" -> {
                        binding.instituicao.visibility = View.GONE
                        binding.titleMon.visibility = View.GONE
                        binding.orientator.visibility = View.GONE
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.cbTel.setOnClickListener { showMobilePhone() }
        binding.submit
        binding.submit.setOnClickListener {
            user = User(
                binding.nome.text.toString(),
                binding.email.text.toString(),
                binding.telefone.text.toString(),
                binding.telefoneCel.text.toString(),
                binding.dataNasc.text.toString(),
                selectedEdu,
                binding.anoFin.text.toString().toIntOrNull() ?: 0,
                binding.titleMon.text.toString(),
                binding.instituicao.text.toString(),
                binding.orientator.text.toString(),
                getGender(),
                binding.vagas.text.toString(),
                binding.checkBoxEmail.isChecked
            )

            val inflater = LayoutInflater.from(this)
            val popupView = inflater.inflate(R.layout.popup, null)

            popupView.findViewById<TextView>(R.id.nome).text = binding.nome.text
            popupView.findViewById<TextView>(R.id.email).text = binding.email.text
            popupView.findViewById<TextView>(R.id.telefone).text = binding.telefone.text
            popupView.findViewById<TextView>(R.id.data_nasc).text = binding.dataNasc.text
            popupView.findViewById<TextView>(R.id.anoFin).text = binding.anoFin.text
            popupView.findViewById<TextView>(R.id.vagas).text = binding.vagas.text
            if(getGender() == "Masculino")
                popupView.findViewById<TextView>(R.id.gender).text = binding.male.text
            else
                popupView.findViewById<TextView>(R.id.gender).text = binding.female.text
            if(binding.cbTel.isChecked) {
                popupView.findViewById<TextView>(R.id.telefoneCel).visibility = View.VISIBLE
                popupView.findViewById<TextView>(R.id.telefoneCel).text = binding.telefoneCel.text
            }
            popupView.findViewById<TextView>(R.id.formacao).text = selectedEdu


            val popup = PopupWindow(popupView, 800, 800, true)
            popup.isOutsideTouchable = true
            popup.setBackgroundDrawable(null)
            popup.showAtLocation(binding.root, Gravity.CENTER, 0, 0)
        }

        binding.clear.setOnClickListener {
            binding.nome.text.clear()
            binding.checkBoxEmail.isChecked = false
            binding.cbTel.isChecked = false
            binding.email.text.clear()
            binding.telefone.text.clear()
            binding.telefoneCel.text.clear()
            binding.dataNasc.text.clear()
            binding.anoFin.text.clear()
            binding.orientator.text.clear()
            binding.instituicao.text.clear()
            binding.vagas.text.clear()
            binding.titleMon.text.clear()
            binding.dataNasc.text.clear()
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
                if(str.length == 2 && !str.contains("/"))
                    binding.dataNasc.text.append("/")
                if(str.length == 5 && Regex("/").findAll(str).count() != 2)
                    binding.dataNasc.text.append("/")
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