package com.example.lab1_part2.data

import com.example.lab1_part2.R

class Datasource {
    fun loadImages(): List<Int> {
        return listOf(
            R.drawable.apple,
            R.drawable.apple2,
            R.drawable.apple3,
        )
    }
}