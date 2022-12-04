package com.example.kubsaunews.repository

import android.content.Context
import com.example.kubsaunews.datasourse.db.CharacterDB

class DbRepositoryImpl(override val context: Context) :DbRepository {

    override val characterDB: CharacterDB = CharacterDB.getInstance(context)
}