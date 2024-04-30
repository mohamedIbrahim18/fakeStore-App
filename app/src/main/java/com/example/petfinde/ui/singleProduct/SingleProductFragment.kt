package com.example.petfinde.ui.singleProduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.domain.model.products.Products
import com.example.petfinde.R
import com.example.petfinde.databinding.FragmentSingleProductBinding
import com.example.petfinde.ui.viewmodel.HomeViewModel
import com.example.petfinde.ui.viewmodel.SingleProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleProductFragment : Fragment() {
    lateinit var viewBinding: FragmentSingleProductBinding
    lateinit var viewModel: SingleProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SingleProductViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentSingleProductBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productId = arguments?.getInt("productId")
        viewModel.getSingleProduct(productId!!)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.singleProductLiveData.observe(viewLifecycleOwner) {
            initUi(it)
        }
    }

    private fun initUi(it: Products?) {
        viewBinding.productTitle.text = it?.title
        viewBinding.productDesc.text = it?.description
        viewBinding.productPrice.text = it?.price.toString()
        Glide.with(viewBinding.root).load(it?.image).into(viewBinding.productImage)
    }

}