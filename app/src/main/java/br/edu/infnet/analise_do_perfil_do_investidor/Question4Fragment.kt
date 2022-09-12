package br.edu.infnet.analise_do_perfil_do_investidor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion4Binding
import br.edu.infnet.analise_do_perfil_do_investidor.interfaces.OuvinteDeRespostas


class Question4Fragment : Fragment() {
    private var _binding: FragmentQuestion4Binding? = null
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
        _binding = FragmentQuestion4Binding.inflate(inflater, container, false)
        val view  = binding.root

        binding.btnAvancarQ4.setOnClickListener {
            if (binding.rdGroupQ4.checkedRadioButtonId != -1) {
                when (binding.rdGroupQ4.checkedRadioButtonId) {
                    R.id.rd_q4_btn1 -> { ouvinteDeRespostas.onAnswerSubmit(0) }
                    R.id.rd_q4_btn2 -> { ouvinteDeRespostas.onAnswerSubmit(2) }
                    R.id.rd_q4_btn3 -> { ouvinteDeRespostas.onAnswerSubmit(4) }
                }
            }
            view.findNavController().navigate(R.id.action_question4Fragment_to_question5Fragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}