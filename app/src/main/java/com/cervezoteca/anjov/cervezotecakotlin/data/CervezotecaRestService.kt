package com.cervezoteca.anjov.cervezotecakotlin.data

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by anjov on 09/04/2017.
 */

interface CervezotecaRestService {

    @GET("/beers.json")
    fun getTapBeer(): Call<List<TapBeer>>

}