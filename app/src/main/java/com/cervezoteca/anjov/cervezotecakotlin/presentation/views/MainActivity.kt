package com.cervezoteca.anjov.cervezotecakotlin.presentation.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.ViewDebug
import com.cervezoteca.anjov.cervezotecakotlin.data.RestAPI
import com.cervezoteca.anjov.cervezotecakotlin.data.TapBeer
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.data
import com.cervezoteca.anjov.cervezotecakotlin.R
import com.cervezoteca.anjov.cervezotecakotlin.presentation.adapter.BeerAdapter
import com.cervezoteca.anjov.cervezotecakotlin.presentation.presenter.MainPresenter
import com.cervezoteca.anjov.cervezotecakotlin.presentation.views.DetailActivity
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(), TapBeerListView {

    lateinit var presenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = GridLayoutManager(this, 2)
        val tapBeerList = emptyList<TapBeer>()
        recycler.adapter = BeerAdapter(tapBeerList) {}

        presenter = MainPresenter(this)
        presenter.getTapBeers()
    }



    fun navigateToDetail (item: TapBeer) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NAME, item.beer.name)
        intent.putExtra(DetailActivity.EXTRA_URL, item.beer.logo)
        startActivity(intent)
    }

    override fun onTapBeersLoaded(tapBeerList:List<TapBeer>) {
        recycler.adapter = BeerAdapter(tapBeerList) {
            item -> navigateToDetail(item)
        }
    }
}
