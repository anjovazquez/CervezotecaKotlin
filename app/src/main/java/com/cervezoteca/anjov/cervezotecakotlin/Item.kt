package com.cervezoteca.anjov.cervezotecakotlin

/**
 * Created by anjov on 09/04/2017.
 */

fun getItems():List<Item> {
    return (1..10).map { Item(it.toLong(), "Title $it", "http://lorempixel.com/400/200/sports/$it/") }
}

data class Item(val id:Long, val title:String, val url:String)