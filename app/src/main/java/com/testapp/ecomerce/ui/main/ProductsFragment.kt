package com.testapp.ecomerce.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.testapp.ecomerce.BR
import com.testapp.ecomerce.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_products.*

@AndroidEntryPoint
class ProductsFragment : Fragment() {
    private lateinit var viewDataBinding: ViewDataBinding
    private val productsViewModel: ProductsViewModel by activityViewModels()

    private lateinit var adapter: ProductsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeChanges()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.setVariable(BR.viewModel, productsViewModel)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = ProductsAdapter(productsViewModel)
        adapter.itemClickListener = { _, position ->
            findNavController().navigate(
                ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(position)
            )
        }
        rvProducts.adapter = adapter
    }

    private fun observeChanges() {
        productsViewModel.productsViewState.observe(this, Observer {
            when (it) {
                is ProductsViewState.ProductsResponseData -> {
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }
}