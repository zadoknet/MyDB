package zadok.jct.mydb.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import zadok.jct.mydb.Entitties.Parcel;


@Database(entities = {Parcel.class},version = 1,exportSchema = false)
public abstract class HistoryDataSource extends RoomDatabase {
    public abstract ParcelsDao getParcelsDao();
    //TODO האם אני צריך לעשות עם סינגלטון?
}
