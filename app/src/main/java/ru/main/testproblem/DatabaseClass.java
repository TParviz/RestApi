package ru.main.testproblem;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.main.testproblem.Dao.DaoClass;
import ru.main.testproblem.Model.UserModel;

@Database(entities = {UserModel.class}, version =  1)
public abstract class DatabaseClass extends RoomDatabase {

    public abstract DaoClass getDao();
    private static DatabaseClass instance;

    public static DatabaseClass getDatabase(final Context context){
        if (instance == null){
            synchronized (DatabaseClass.class){
                instance = Room.databaseBuilder(context, DatabaseClass.class, "DATABASE").allowMainThreadQueries().build();

            }
        }
        return instance;
    }
}
