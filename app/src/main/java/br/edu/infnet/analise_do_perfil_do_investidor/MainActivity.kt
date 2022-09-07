package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAvancarTela.setOnClickListener {
            val nome = binding.inputNome.text.toString()
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra(NOME, nome)
            startActivity(intent)
        }
    }
    companion object {
        val NOME = "NOME"
    }
}