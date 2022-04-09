package com.example.passwordgenerator

import java.lang.StringBuilder

class PasswordGenerator {
    private val lowercase = "abcdefghijklmnopgrstuvwxyz"
    private val uppercase = lowercase.uppercase()
    private val digits = "0123456789"
    private val symbols = "~!@#$%^&*()_+|,.;'"
    private val characters = "$lowercase$uppercase$digits$symbols"


    fun generatePassword(length: Int): String{
        val sb = StringBuilder(length)
        for(x in 0 until length){
            val random = (characters.indices).random()
            sb.append(characters[random])
        }
        return sb.toString()
    }
}