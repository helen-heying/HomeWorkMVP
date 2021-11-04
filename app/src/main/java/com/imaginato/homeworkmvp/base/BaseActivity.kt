package com.imaginato.homeworkmvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewBinding().root)
        initUI()
    }

    abstract fun getViewBinding(): ViewBinding
    abstract fun initUI()

}