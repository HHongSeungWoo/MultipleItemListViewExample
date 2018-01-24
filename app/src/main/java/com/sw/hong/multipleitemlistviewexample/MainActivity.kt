package com.sw.hong.multipleitemlistviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hAdapter = HAdapter(this)
        hAdapter.addItem(HAdapter.Items("aa",HAdapter.VIEWTYPE_EDITTEXT))
        hAdapter.addItem(HAdapter.Items(R.mipmap.ic_launcher,HAdapter.VIEWTYPE_IMAGE))
        hAdapter.addItem(HAdapter.Items(true,HAdapter.VIEWTYPE_BOOLEAN))
        hAdapter.addItem(HAdapter.Items("aa",HAdapter.VIEWTYPE_TEXT))
        hAdapter.addItem(HAdapter.Items(R.mipmap.ic_launcher,HAdapter.VIEWTYPE_IMAGE))
        hAdapter.addItem(HAdapter.Items("aa",HAdapter.VIEWTYPE_TEXT))
        listView.adapter = hAdapter

    }
}
