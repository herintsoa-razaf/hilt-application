package com.example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.presenter.MainViewModel
import com.example.ui.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var viewBinding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        attachListeners()
        attachObservers()
        viewBinding?.message?.text = viewModel.getMessage()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun attachListeners() {
        viewBinding?.btnOk?.setOnClickListener {
            viewBinding?.edtCompanyId?.text?.toString()
                ?.takeIf { it.isNotBlank() }
                ?.also(viewModel::getCompany)
                ?: run {
                    viewBinding?.tvCompany?.text = ""
                }
        }
    }

    private fun attachObservers() {
        viewModel.apply {
            company.observe(viewLifecycleOwner) { value ->
                value?.let { "I am ${it.name} " }?.also {
                    viewBinding?.tvCompany?.text = it
                }
            }
            loading.observe(viewLifecycleOwner) { loading ->
                if (loading) {
                    viewBinding?.tvCompany?.text = ""
                    viewBinding?.message?.text = getString(R.string.loading)
                } else {
                    viewBinding?.message?.text = viewModel.getMessage()
                }
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
