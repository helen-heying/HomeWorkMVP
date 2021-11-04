package com.imaginato.homeworkmvp.ui.demo

import androidx.core.view.isVisible
import androidx.viewbinding.ViewBinding
import com.imaginato.homeworkmvp.base.BaseMvpActivity
import com.imaginato.homeworkmvp.databinding.ActivityDemoBinding
import com.imaginato.homeworkmvp.presenter.demo.DemoContract
import com.imaginato.homeworkmvp.presenter.demo.DemoPresenter
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class DemoActivity : BaseMvpActivity<DemoContract.View, DemoPresenter>(), DemoContract.View {

    lateinit var binding: ActivityDemoBinding
    lateinit var presenter: DemoPresenter
    override fun getViewBinding(): ViewBinding {
        binding = ActivityDemoBinding.inflate(layoutInflater)
        return binding
    }

    override fun initUI() {
        binding.btnDemo.setOnClickListener {
            presenter.getData()
        }
    }

    override fun initPresenter(): DemoPresenter {
        presenter = DemoPresenter(this)
        return presenter
    }

    override fun setResult(data: String) {
        binding.tvResult.text = data
    }

    override fun showLoading() {
        binding.pbLoading.isVisible = true
    }

    override fun hideLoading() {
        binding.pbLoading.isVisible = false
    }

    override fun showErrorMsg(errorMsg: String) {
        binding.tvResult.text = errorMsg
    }

}