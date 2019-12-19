package zadok.jct.mydb.Data;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.postStatus;


public class Firebase_DBManger {
    final String TAG="ZADOK";
    private MutableLiveData<postStatus> statusMessage=new MutableLiveData<>();

    public interface action<T>{
        void onSuccess(T obj);
        void onFailure(Exception exception);
        void onProgress(String status,double percent);
    }
    public interface NotifyDataChange<T>{
        void onDataChanged(T obj);
        void onFailure(Exception exception);
    }
    static DatabaseReference parcelsRef;
    static List<Parcel> parcelsList;

    static {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        parcelsRef =database.getReference("Parcels");
        parcelsList=new ArrayList<>();
    }

    public void addParcelToFirebase(final Parcel parcel){
        String key=""+parcel.getParcelId();
        Log.i(TAG,"check log");
        parcelsRef.child(key).setValue(parcel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i(TAG,"Saving success");
                statusMessage.postValue(new postStatus(postStatus.savingStatus.SUCCESS));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i(TAG,"Saving failed");
            statusMessage.postValue(new postStatus(postStatus.savingStatus.FAILED));
            }
        });

    }

    public MutableLiveData<postStatus> getStatusMessage() {
        return statusMessage;
    }
}
