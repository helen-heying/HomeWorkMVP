package com.imaginato.homeworkmvp.presenter.demo

import com.imaginato.homeworkmvp.base.BasePresenter
import com.imaginato.homeworkmvp.data.remote.demo.DemoRepository
import com.imaginato.homeworkmvp.presenter.demo.DemoContract
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.inject

@KoinApiExtension
class DemoPresenter(private val view: DemoContract.View) : BasePresenter<DemoContract.View>(),
    DemoContract.Presenter {

    private val repository: DemoRepository by inject()

    override fun getData() {
        launch(exceptionHandler) {
            repository.getDemoData().onStart {
                view.showLoading()
            }.catch {

                view.setResult(it.message?:"")
                view.hideLoading()
            }.collect {
                view.hideLoading()
                view.setResult(it)
            }
        }
    }
}