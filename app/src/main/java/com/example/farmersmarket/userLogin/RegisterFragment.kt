package com.example.farmersmarket.userLogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.farmersmarket.R
import com.example.farmersmarket.databinding.FragmentRegisterBinding
import com.example.farmersmarket.userDatabase.RegisterDatabase
import com.example.farmersmarket.userDatabase.RegisterRepository

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_register, container, false)

        val application = requireNotNull(this.activity).application

        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository = RegisterRepository(dao)

        val factory = RegisterViewModelFactory(repository, application)

        registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        binding.myViewModel = registerViewModel

        binding.lifecycleOwner = this


        registerViewModel.navigateto.observe(viewLifecycleOwner, Observer { hasFinished->
            if (hasFinished == true){
                registerViewModel.doneNavigating()
                toLoginFragment()
                Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
            }
        })

//        registerViewModel.userDetailsLiveData.observe(viewLifecycleOwner, Observer {
//
//        })

        registerViewModel.errotoast.observe(viewLifecycleOwner, Observer { hasError->
            if(hasError==true){
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                registerViewModel.donetoast()
            }
        })

        registerViewModel.errotoastUsername.observe(viewLifecycleOwner, Observer { hasError->
            if(hasError==true){
                Toast.makeText(requireContext(), "Email already Registered", Toast.LENGTH_SHORT).show()
                registerViewModel.donetoastUserName()
            }
        })


        binding.tvExistUser.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment2)
        }
        return binding.root
    }

    private fun toLoginFragment(){
        view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment2)
    }

}