package com.cervezoteca.anjov.cervezotecakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    //estatico, unico todas instancias de esta clase
    companion object {
        val EXTRA_NAME = "DetailActivity:name"
        val EXTRA_URL = "DetailActivity:url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val url = intent.getStringExtra(EXTRA_URL)

        if(url!=null && name !=null){
            item_image.loadUrl(url)
            item_title.text = name
        }
    }
}
