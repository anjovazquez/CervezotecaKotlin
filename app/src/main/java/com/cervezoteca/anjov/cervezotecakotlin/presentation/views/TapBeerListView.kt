package com.cervezoteca.anjov.cervezotecakotlin.presentation.views

import com.cervezoteca.anjov.cervezotecakotlin.data.TapBeer

/**
 * Created by anjov on 23/04/2017.
 */
interface TapBeerListView {
    fun onTapBeersLoaded(tapBeerList:List<TapBeer>)
}