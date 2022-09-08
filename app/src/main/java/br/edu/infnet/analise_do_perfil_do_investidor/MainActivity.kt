package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
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

        findViewById<Button>(R.id.btn_sobre).setOnClickListener {
            showCloseAlert()
        }


    }
    companion object {
        val NOME = "NOME"
    }

    private fun showCloseAlert() {
        val alert: AlertDialog.Builder = AlertDialog.Builder(this, R.style.ThemeCustomDialog)
        val dialogBinding: CustomDialogBinding = CustomDialogBinding
            .inflate(LayoutInflater.from(this))

        alert.setView(dialogBinding.root)
        alert.show()
    }


}