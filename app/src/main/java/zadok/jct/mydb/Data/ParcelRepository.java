
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
    Firebase_DBManger fire = new Firebase_DBManger();

    public ParcelRepository(Context app) {
        database = Room.databaseBuilder(app, HistoryDataSource.class, "mydb")
                .allowMainThreadQueries()
                .build();
        final ParcelsDao parcelsDao = database.getParcelsDao();
        //Parcel parcel1 = new Parcel(4, "נתנאל");
        //Parcel parcel2 = new Parcel(5, "צדוק");
        //Parcel parcel3=new Parcel(6,"שרה");
        //database.getParcelsDao().Insert(parcel1,parcel2,parcel3);
        //ParcelsDao parcelsDao1=database.getParcelsDao();
        //parcelsDao.Insert(parcel1, parcel2,parcel3);
       List<Parcel> parcels = database.getParcelsDao().getItems();
        Log.i(TAG, "" + parcels);
        fire.notifyToChildList(new Firebase_DBManger.NotifyDataChange<Parcel>() {
            @Override
            public void onDataChanged(Parcel parcel) {

                Parcel temp=parcelsDao.getItemById(Long.parseLong(""+parcel.getParcelId()));
                if(temp!=null)
                    //if the item exist in the sqlite- update
                    parcelsDao.Update(temp);
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
        return fire.getStatusMessage();
    }

    public void addParcelToDBManger(Parcel parcel) {
        fire.addParcelToFirebase(parcel);
    }

    public MutableLiveData<List<Parcel>> getParcelsLiveData()
    {
        return parcelsLiveData;
    }

    public void getDataFromRoom() {
        parcelsLiveData.postValue(parcelsDao.getItems());
    }
}

