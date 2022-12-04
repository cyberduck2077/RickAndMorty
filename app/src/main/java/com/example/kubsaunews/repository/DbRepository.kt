package com.example.kubsaunews.repository

import android.content.Context
import com.example.kubsaunews.datasourse.db.CharacterDB

interface DbRepository {

    val characterDB: CharacterDB

    val context:Context
}