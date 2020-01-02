package zadok.jct.mydb.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;

@Dao
public interface ParcelsDao {
    @Insert
    void Insert(Parcel... parcels);
    @Update
    void Update(Parcel... parcels);
    @Delete
    void Delete(Parcel parcel);
    @Query("SELECT * FROM parcels_table")
    List<Parcel> getItems();
    @Query("SELECT * FROM parcels_table WHERE parcelId = :id")
    Parcel getItemById(Long id);
}
