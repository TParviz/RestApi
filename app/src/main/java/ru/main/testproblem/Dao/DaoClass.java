package ru.main.testproblem.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.main.testproblem.Model.UserModel;


@Dao
public interface DaoClass {

    @Insert
    void insertAllData(UserModel model);

    //Select All Data
    @Query("select * from  data")
    List<UserModel> getAllData();
//
//    //DELETE DATA
//    @Query("delete from user where `key`= :id")
//    void deleteData(int id);

    //Update Data

//    @Query("update user SET name= :name ,address =:address, phoneno =:phoneno where `key`= :key")
//    void updateData(String name, String phoneno, String address, int key);

}
