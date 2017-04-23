package com.cervezoteca.anjov.cervezotecakotlin.presentation.presenter

import com.cervezoteca.anjov.cervezotecakotlin.data.RestAPI
import com.cervezoteca.anjov.cervezotecakotlin.data.TapBeer
import com.cervezoteca.anjov.cervezotecakotlin.presentation.views.MainActivity
import com.cervezoteca.anjov.cervezotecakotlin.presentation.views.TapBeerListView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by anjov on 22/04/2017.
 */

open class MainPresenter (val tapBeerListView: TapBeerListView) {


    fun getTapBeers() {
        doAsync{
            val api = RestAPI()
            val tapBeerList:List<TapBeer> = api.getTapBeers().execute().body()
            uiThread {
                tapBeerListView.onTapBeersLoaded(tapBeerList)
            }
        }
    }
}