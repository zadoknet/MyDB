package zadok.jct.mydb.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.RoomConverter;


@Database(entities = {Parcel.class},version = 1,exportSchema = false)
@TypeConverters({RoomConverter.class})
public abstract class HistoryDataSource extends RoomDatabase {
    public abstract ParcelsDao getParcelsDao();
    //TODO האם אני צריך לעשות עם סינגלטון?
}
