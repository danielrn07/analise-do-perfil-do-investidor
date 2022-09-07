package br.edu.infnet.analise_do_perfil_do_investidor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.analise_do_perfil_do_investidor.databinding.FragmentQuestion7Binding


class Question7Fragment : Fragment() {
    private var _binding: FragmentQuestion7Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestion7Binding.inflate(inflater, container, false)
        val view  = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}