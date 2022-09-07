package br.edu.infnet.analise_do_perfil_do_investidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityMainBinding
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionsBinding

    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        nome = intent.getStringExtra(MainActivity.NOME) ?: ""
    }



}