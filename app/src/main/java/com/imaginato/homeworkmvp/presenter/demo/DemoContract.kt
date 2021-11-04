package com.imaginato.homeworkmvp.presenter.demo

import com.imaginato.homeworkmvp.base.IBaseView
import com.imaginato.homeworkmvp.base.IPresenter
import org.koin.core.component.KoinApiExtension

interface DemoContract {
    interface View : IBaseView {
        fun setResult(data: String)
    }

    @KoinApiExtension
    interface Presenter : IPresenter<View> {
        fun getData()
    }
}
