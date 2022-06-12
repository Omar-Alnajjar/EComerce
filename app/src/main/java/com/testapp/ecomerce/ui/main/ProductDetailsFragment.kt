package com.testapp.ecomerce.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.testapp.ecomerce.BR
import com.testapp.ecomerce.R

class ProductDetailsFragment : Fragment() {

    private lateinit var viewDataBinding: ViewDataBinding
    private val productsViewModel: ProductsViewModel by activityViewModels()

    private val productPosition by lazy {
        val args by navArgs<ProductDetailsFragmentArgs>()
        args.position
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.setVariable(BR.product, productsViewModel.getItemAt(productPosition))
    }
}