package com.eggdevs.theasiansaid.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.eggdevs.theasiansaid.models.DBModel;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {

   @Insert(onConflict = REPLACE)
   void insert(DBModel model);

   @Delete
   void delete(DBModel model);

   @Delete
   void reset(List<DBModel> list);

   @Query("SELECT * FROM table_name")
   List<DBModel> getAll();
}
