
package zadok.jct.mydb.Data;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import zadok.jct.mydb.Data.Firebase_DBManger;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.postStatus;

public class ParcelRepository {


    //TODO
    Firebase_DBManger fire=new Firebase_DBManger();

    public MutableLiveData<postStatus> getStatusMessageRepository() {
        return fire.getStatusMessage();
    }

    public void addParcelToDBManger(Parcel parcel)
    {
        fire.addParcelToFirebase(parcel);
    }
}
