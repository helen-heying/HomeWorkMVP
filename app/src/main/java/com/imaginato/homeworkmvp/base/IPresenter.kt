package com.imaginato.homeworkmvp.base

import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
interface IPresenter<in V : IBaseView>: KoinComponent {

    fun attachView(view: V)

    fun detachView()

    fun isAttach(): Boolean
}