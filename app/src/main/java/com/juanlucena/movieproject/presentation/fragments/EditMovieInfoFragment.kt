package com.juanlucena.movieproject.presentation.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.juanlucena.movieproject.databinding.FragmentEditMovieInfoBinding

class EditMovieInfoFragment(private val onFinishEditing: (String, String) -> Unit) : DialogFragment() {

    constructor() : this(onFinishEditing = { _, _ -> })

    private lateinit var binding: FragmentEditMovieInfoBinding

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(requireContext(), "Landscape Mode", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(requireContext(), "Portrait Mode", Toast.LENGTH_SHORT).show()
        }
    }

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