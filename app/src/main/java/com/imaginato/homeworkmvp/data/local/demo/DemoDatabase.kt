package com.imaginato.homeworkmvp.data.local.demo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imaginato.homeworkmvp.data.local.demo.Demo
import com.imaginato.homeworkmvp.data.local.demo.DemoDao

@Database(entities = [Demo::class], version = 1, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {
    abstract val demoDao: DemoDao
}