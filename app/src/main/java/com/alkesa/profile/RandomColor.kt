package com.alkesa.profile

import java.util.*

object RandomColor {
    fun getRandom(_min: Int, _max: Int): Int {
        val random = Random()
        return random.nextInt(_max - _min + 1) + _min
    }
}