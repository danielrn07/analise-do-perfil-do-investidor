package br.edu.infnet.analise_do_perfil_do_investidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityQuestionsBinding
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    var nome = ""

    var resultado = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        nome = intent.getStringExtra(MainActivity.NOME) ?: ""
        resultado = intent.getStringExtra(MainActivity.RESULTADO) ?: ""

        binding.nomeResultado.text = nome
        binding.textoResultado.text = resultado
    }
}