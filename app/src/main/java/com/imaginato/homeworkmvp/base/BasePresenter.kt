package com.imaginato.homeworkmvp.base

import android.content.ContentValues
import com.imaginato.homeworkmvp.exts.LOG_TYPE_ERROR
import com.imaginato.homeworkmvp.exts.printLog
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
open class BasePresenter<V : IBaseView> : IPresenter<V>, CoroutineScope by MainScope() {

    private var rootView: V? = null

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.message?.printLog(LOG_TYPE_ERROR, ContentValues.TAG)
        rootView?.showErrorMsg(throwable.message ?: "")
    }

    override fun attachView(view: V) {
        this.rootView = view
    }

    override fun detachView() {
        this.rootView = null
    }

    private val isViewAttached: Boolean
        get() = rootView != null

    override fun isAttach(): Boolean {
        return rootView != null
    }
}