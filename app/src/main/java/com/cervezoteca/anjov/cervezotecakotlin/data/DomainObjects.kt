package com.cervezoteca.anjov.cervezotecakotlin.data

import com.cervezoteca.anjov.cervezotecakotlin.Item

/**
 * Created by anjov on 09/04/2017.
 */

data class Beer(val id: String, val name: String, val logo: String)

data class TapBeer(val id: String, val beer: Beer)
