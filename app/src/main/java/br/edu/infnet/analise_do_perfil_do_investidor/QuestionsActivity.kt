package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityMainBinding
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityQuestionsBinding
import br.edu.infnet.analise_do_perfil_do_investidor.interfaces.OuvinteDeRespostas

class QuestionsActivity : AppCompatActivity(), OuvinteDeRespostas {
    private lateinit var binding: ActivityQuestionsBinding

    val listaRespostas = mutableListOf<Int>()

    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        nome = intent.getStringExtra(MainActivity.NOME) ?: ""

    }

    override fun onAnswerSubmit(resposta: Int) {
        listaRespostas.add(resposta)
        if (listaRespostas.size == 9) {
            concluirQuestionario()
        }
    }

    fun concluirQuestionario() {

        var textoEnviado = "Seu resultado foi: "
        textoEnviado += "${listaRespostas.sum()}"

        val intentResposta = Intent(this, ResultActivity::class.java)
        intentResposta.putExtra(MainActivity.NOME, nome)
        intentResposta.putExtra(RESULTADO, textoEnviado)
        startActivity(intentResposta)
    }

    companion object {
        val RESULTADO = "RESULTADO"
    }

}