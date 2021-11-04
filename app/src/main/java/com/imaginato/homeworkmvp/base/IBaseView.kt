package com.imaginato.homeworkmvp.base

interface IBaseView {

    fun showLoading()

    fun hideLoading()

    fun showErrorMsg(errorMsg: String)
}