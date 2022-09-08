package br.edu.infnet.analise_do_perfil_do_investidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion4Binding


class Question4Fragment : Fragment() {
    private var _binding: FragmentQuestion4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestion4Binding.inflate(inflater, container, false)
        val view  = binding.root

        binding.btnAvancarQ4.setOnClickListener {
            view.findNavController().navigate(R.id.action_question4Fragment_to_question5Fragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}