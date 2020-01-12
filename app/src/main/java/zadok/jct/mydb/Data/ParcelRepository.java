
package zadok.jct.mydb.Data;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.PostStatus;

public class ParcelRepository extends Application {
    final String TAG = "ZADOK";
    HistoryDataSource database;
    private ParcelsDao parcelsDao;
    private MutableLiveData<List<Parcel>> parcelsLiveData=new MutableLiveData<>();
    ParcelDataSource parcelDataSource = new ParcelDataSource();

    public ParcelRepository(Context app) {
        database = Room.databaseBuilder(app, HistoryDataSource.class, "mydb")
                .allowMainThreadQueries()
                .build();
        parcelsDao = database.getParcelsDao();
       // parcelDataSource.readUniqueNum();

       List<Parcel> parcels = database.getParcelsDao().getItems();
        Log.i(TAG, "" + parcels);
        parcelDataSource.notifyToChildList(new ParcelDataSource.NotifyDataChange<Parcel>() {
            @Override
            public void onDataChanged(Parcel parcel) {

                Parcel temp=parcelsDao.getItemById(parcel.getParcelId());
                if(temp!=null)
                    //if the item exist in the sqlite- update
                    parcelsDao.Update(parcel);
                else
                    //if the item didn't exist in the sqlite- insert
                parcelsDao.Insert(parcel);
                //take the Parcels from the room and post the to the observer(the HistoryViewModel)
                parcelsLiveData.postValue(parcelsDao.getItems());

            }

            @Override
            public void onFailure(Exception exception) {

            }
        });
        //connect the repository to updates from the Firebase




    }

    //TODO


    public MutableLiveData<PostStatus> getStatusMessageRepository() {
        return parcelDataSource.getStatusMessage();
    }

    public void addParcelParcelDataSource(Parcel parcel) {
        parcelDataSource.addParcelToFirebase(parcel);
    }

    public MutableLiveData<List<Parcel>> getParcelsLiveData()
    {
        return parcelsLiveData;
    }

    public void getDataFromRoom() {
        parcelsLiveData.postValue(parcelsDao.getItems());
    }

}

