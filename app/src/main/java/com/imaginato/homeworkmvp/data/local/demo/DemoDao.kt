package com.imaginato.homeworkmvp.data.local.demo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.imaginato.homeworkmvp.data.local.demo.Demo

@Dao
interface DemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDemo(demo: List<Demo>)
}