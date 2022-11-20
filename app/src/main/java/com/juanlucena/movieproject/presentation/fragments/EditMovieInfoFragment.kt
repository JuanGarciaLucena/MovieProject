package com.juanlucena.movieproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.juanlucena.movieproject.databinding.FragmentEditMovieInfoBinding

class EditMovieInfoFragment(private val onFinishEditing: (String, String) -> Unit) : DialogFragment() {

    private lateinit var binding: FragmentEditMovieInfoBinding

    override fun onResume() {
        dialog!!.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEditMovieInfoBinding.inflate(layoutInflater, container, false)
        initListeners()
        return binding.root
    }

    private fun initListeners(){
        binding.editInfoButton.setOnClickListener {
            onFinishEditing(binding.editTitleEditText.text.toString(), binding.editDescriptionEditText.text.toString())
            dialog!!.dismiss()
        }
    }
}