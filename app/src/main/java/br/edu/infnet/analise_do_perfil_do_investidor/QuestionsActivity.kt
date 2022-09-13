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
        var soma = listaRespostas.sum()

        var textoEnviado = "Sua pontuação foi: "
        textoEnviado += "$soma\n\n"

        if (soma <= 12) {
            textoEnviado += "Seu perfil de investidor é: Conservador"
        } else if (soma >= 13 && soma <= 29) {
            textoEnviado += "Seu perfil de investidor é: Moderado"
        } else {
            textoEnviado += "Seu perfil de investidor é: Arrojado"
        }

        val intentResposta = Intent(this, ResultActivity::class.java)
        intentResposta.putExtra(MainActivity.NOME, nome)
        intentResposta.putExtra(RESULTADO, textoEnviado)
        startActivity(intentResposta)
    }

    override fun onBackPressed() {
        if (listaRespostas.isNotEmpty())
            listaRespostas.removeLast()
        super.onBackPressed()
    }

    companion object {
        val RESULTADO = "RESULTADO"
    }
}