package com.eggdevs.theasiansaid.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.eggdevs.theasiansaid.models.DBModel;

@Database(entities = {DBModel.class}, version = 3, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

   private static RoomDB database;

   public synchronized static RoomDB getInstance(Context context) {

      if (database == null) {
         String DATABASE_NAME = "database";
         database = Room.databaseBuilder(context.getApplicationContext(),
                 RoomDB.class, DATABASE_NAME)
                 .allowMainThreadQueries()
                 .fallbackToDestructiveMigration()
                 .build();
      }

      return database;
   }

   public abstract MainDao mainDao();
}
