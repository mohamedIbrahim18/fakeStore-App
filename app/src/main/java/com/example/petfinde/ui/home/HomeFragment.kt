package com.example.petfinde.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.domain.model.products.Products
import com.example.petfinde.R
import com.example.petfinde.adapter.ProductsAdapter
import com.example.petfinde.databinding.FragmentHomeBinding
import com.example.petfinde.ui.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var viewBinding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var listProducts: List<Products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listProducts = emptyList()
        productsAdapter = ProductsAdapter(listProducts)
        initViews()
        viewModel.getAllProducts()
        viewModel.getAllCategories()
        subscribeToLiveData()
        setClickListnnerToAdapter()
    }

    private fun setClickListnnerToAdapter() {
        productsAdapter.onItemClickedListnner = object :ProductsAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, task: Products) {
                val bundle = Bundle().apply {
                    putInt("productId", task.id ?: -1)
                }
                findNavController().navigate(
                    R.id.action_homeFragment_to_singleProductFragment,
                    bundle
                )
            }

        }
    }

    private fun subscribeToLiveData() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) {
            Log.e("data", it?.get(0)?.title!!)
            productsAdapter.changeToNewProducts(it)
        }
        viewModel.categoriesLiveData.observe(viewLifecycleOwner) {
            Log.e("data", it.get(0))
            //ad it to tab layout
            addToTabLayout(it)
        }
        viewModel.specificProductsLiveData.observe(viewLifecycleOwner) {
            productsAdapter.changeToNewProducts(it!!)
        }
    }

    private fun addToTabLayout(it: List<String>?) {
        val tab = viewBinding.tabLayout.newTab()
        tab.text = "All"
        viewBinding.tabLayout.addTab(tab)
        it?.forEach {
            val tab = viewBinding.tabLayout.newTab()
            tab.text = it
            viewBinding.tabLayout.addTab(tab)
        }
        viewBinding.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab.let {
                        val categoryName = it?.text.toString()
                        if (categoryName == "All") {
                            viewModel.getAllProducts()
                        } else {
                            viewModel.getSpecificProducts(categoryName)
                        }
                    }
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {
                }

                override fun onTabReselected(p0: TabLayout.Tab?) {
                }

            }
        )
    }

    private fun initViews() {
        viewBinding.recyclerPets.apply {
            adapter = productsAdapter
        }
    }

}