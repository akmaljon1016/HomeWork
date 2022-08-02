package com.dars.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.dars.homework.databinding.FragmentNextBinding

class NextFragment : Fragment() {

    val args: NextFragmentArgs by navArgs()
    lateinit var binding: FragmentNextBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNextBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtName.text=args.user.name
        binding.txtUsername.text=args.user.username
        binding.txtCity.text=args.user.address.city
        binding.txtEmail.text=args.user.email
    }

}