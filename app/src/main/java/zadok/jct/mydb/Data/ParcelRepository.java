
package zadok.jct.mydb.Data;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.PostStatus;

public class ParcelRepository extends Application {
    final String TAG = "ZADOK";
    HistoryDataSource database;
    private ParcelsDao parcelsDao;
    private LiveData<List<Parcel>> Parcels;

    public ParcelRepository(Context app) {
        database = Room.databaseBuilder(app, HistoryDataSource.class, "mydb")
                .allowMainThreadQueries()
                .build();
        ParcelsDao parcelsDao = database.getParcelsDao();
        Parcel parcel1 = new Parcel(4, "נתנאל");
        Parcel parcel2 = new Parcel(5, "צדוק");
        Parcel parcel3=new Parcel(6,"שרה");
        //database.getParcelsDao().Insert(parcel1,parcel2,parcel3);
        ParcelsDao parcelsDao1=database.getParcelsDao();
        parcelsDao.Insert(parcel1, parcel2,parcel3);
       List<Parcel> parcels = database.getParcelsDao().getItems();
        Log.i(TAG, "" + parcels);


    }

    //TODO
    Firebase_DBManger fire = new Firebase_DBManger();

    public MutableLiveData<PostStatus> getStatusMessageRepository() {
        return fire.getStatusMessage();
    }

    public void addParcelToDBManger(Parcel parcel) {
        fire.addParcelToFirebase(parcel);
    }
}
