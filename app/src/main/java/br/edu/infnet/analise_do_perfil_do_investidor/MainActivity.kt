package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.ActivityMainBinding
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.CustomDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

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


        val tv_sobre = findViewById<TextView>(R.id.tv_sobre)
        tv_sobre.setOnClickListener {
            showCloseAlert()
        }

    }

    companion object {
        val NOME = "NOME"
        var RESULTADO = "RESULTADO"
    }

    private fun showCredits() {
        val uri = Uri.parse("https://www.bancopaulista.com.br/Arquivos/QuestionarioAPI.pdf")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    private fun showLinkedIn() {
        val uri = Uri.parse("https://www.linkedin.com/in/danielrn07/")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    private fun showGithub() {
        val uri = Uri.parse("https://github.com/danielrn07")
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    private fun showCloseAlert() {
        val alert: AlertDialog.Builder = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val dialogBinding: CustomDialogBinding = CustomDialogBinding
            .inflate(LayoutInflater.from(this))

        dialogBinding.btnCredit.setOnClickListener { showCredits() }
        dialogBinding.btnLinkedin.setOnClickListener { showLinkedIn() }
        dialogBinding.btnGithub.setOnClickListener { showGithub() }

        alert.setView(dialogBinding.root)
        alert.show()
    }


}