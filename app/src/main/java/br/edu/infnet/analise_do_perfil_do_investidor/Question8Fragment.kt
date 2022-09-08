package br.edu.infnet.analise_do_perfil_do_investidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion8Binding


class Question8Fragment : Fragment() {
    private var _binding: FragmentQuestion8Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestion8Binding.inflate(inflater, container, false)
        val view  = binding.root

        binding.btnAvancarQ8.setOnClickListener {
            view.findNavController().navigate(R.id.action_question8Fragment_to_question9Fragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}