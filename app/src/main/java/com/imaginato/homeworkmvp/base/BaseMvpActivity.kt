package com.imaginato.homeworkmvp.base

import android.os.Bundle
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
abstract class BaseMvpActivity<V : IBaseView, P : BasePresenter<V>> : BaseActivity() {
    private var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = initPresenter()
    }

    override fun onResume() {
        super.onResume()
        presenter?.attachView(this as V);
    }

    override fun onDestroy() {
        presenter?.detachView()
        presenter = null
        super.onDestroy()
    }

    abstract fun initPresenter(): P
}