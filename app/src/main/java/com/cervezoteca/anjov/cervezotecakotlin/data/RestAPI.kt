package com.cervezoteca.anjov.cervezotecakotlin.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by anjov on 09/04/2017.
 */

class RestAPI() {

    private val cervezotecaAPI: CervezotecaRestService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://dev.cervezotecamalte.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        cervezotecaAPI = retrofit.create(CervezotecaRestService::class.java)
    }

    fun getTapBeers():Call<List<TapBeer>>{
        return cervezotecaAPI.getTapBeer();
    }

}