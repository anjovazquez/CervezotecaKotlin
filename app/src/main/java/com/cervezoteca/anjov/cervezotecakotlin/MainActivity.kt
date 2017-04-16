package com.cervezoteca.anjov.cervezotecakotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.ViewDebug
import com.cervezoteca.anjov.cervezotecakotlin.data.RestAPI
import com.cervezoteca.anjov.cervezotecakotlin.data.TapBeer
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.data
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = GridLayoutManager(this, 2)
        /*recycler.adapter = ItemAdapter(getItems()) {
            item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_ID, item.id)
            startActivity(intent)
        }*/
        val tapBeerList = emptyList<TapBeer>()
        recycler.adapter = BeerAdapter(tapBeerList){}
        getTapBeers()

    }


    fun navigateToDetail (item:TapBeer) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NAME, item.beer.name)
        intent.putExtra(DetailActivity.EXTRA_URL, item.beer.logo)
        startActivity(intent)
    }



    fun getTapBeers() {

        doAsync {
            val api = RestAPI()
            val tapBeerList:List<TapBeer> = api.getTapBeers().execute().body()
            uiThread {
                recycler.adapter = BeerAdapter(tapBeerList) {
                    item -> navigateToDetail(item)
                }
            }
        }
    }
}
