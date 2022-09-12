package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion1Binding
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion2Binding
import br.edu.infnet.analise_do_perfil_do_investidor.interfaces.OuvinteDeRespostas


class Question2Fragment : Fragment() {
    private var _binding: FragmentQuestion2Binding? = null
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
        _binding = FragmentQuestion2Binding.inflate(inflater, container, false)
        val view  = binding.root

        binding.btnAvancarQ2.setOnClickListener {
            if (binding.rdGroupQ2.checkedRadioButtonId != -1) {
                when (binding.rdGroupQ2.checkedRadioButtonId) {
                    R.id.rd_q2_btn1 -> { ouvinteDeRespostas.onAnswerSubmit(0) }
                    R.id.rd_q2_btn2 -> { ouvinteDeRespostas.onAnswerSubmit(2) }
                    R.id.rd_q2_btn3 -> { ouvinteDeRespostas.onAnswerSubmit(4) }
                    R.id.rd_q2_btn4 -> { ouvinteDeRespostas.onAnswerSubmit(5) }
                }
            }
            view.findNavController().navigate(R.id.action_question2Fragment_to_question3Fragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}