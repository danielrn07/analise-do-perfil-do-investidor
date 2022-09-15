package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion5Binding
import br.edu.infnet.analise_do_perfil_do_investidor.interfaces.OuvinteDeRespostas

class Question5Fragment : Fragment() {
    private var _binding: FragmentQuestion5Binding? = null
    private val binding get() = _binding!!

    private lateinit var ouvinteDeRespostas: OuvinteDeRespostas

    override fun onAttach(context: Context) {
        if (context is OuvinteDeRespostas) {
            ouvinteDeRespostas = context
        }
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestion5Binding.inflate(inflater, container, false)
        val view  = binding.root

        binding.btnAvancarQ5.setOnClickListener {
            if (binding.rdGroupQ5.checkedRadioButtonId != -1) {
                when (binding.rdGroupQ5.checkedRadioButtonId) {
                    R.id.rd_q5_btn1 -> { ouvinteDeRespostas.onAnswerSubmit(0) }
                    R.id.rd_q5_btn2 -> { ouvinteDeRespostas.onAnswerSubmit(2) }
                    R.id.rd_q5_btn3 -> { ouvinteDeRespostas.onAnswerSubmit(4) }
                }
                view.findNavController().navigate(R.id.action_question5Fragment_to_question6Fragment)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}