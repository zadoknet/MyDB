package zadok.jct.mydb.Data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import zadok.jct.mydb.Entitties.Parcel;
import zadok.jct.mydb.Utils.PostStatus;


public class Firebase_DBManger {

    final String TAG = "ZADOK";
    private static ChildEventListener parcelRefChildEventListener;

    public static void notifyToChildList(final NotifyDataChange<Parcel> notifyDataChange) {
        if (notifyDataChange != null)
            notifyDataChange.onFailure(new Exception("first unNotify parcel list"));
        parcelsList.clear();
        parcelRefChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.i("ZADOK", "child added"+dataSnapshot.getValue().toString());
                Parcel parcel=dataSnapshot.getValue(Parcel.class);

                String id=dataSnapshot.getKey();
                parcel.setParcelId(Integer.parseInt(id));

                //todo: if (filter[sent+owned to this machsan]
                notifyDataChange.onDataChanged(parcel);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.i("ZADOK", "child changed");
                Parcel parcel=dataSnapshot.getValue(Parcel.class);
                int id=Integer.parseInt(dataSnapshot.getKey());
                parcel.setParcelId(id);

                //todo:  if (filter[sent+owned to this machsan]
                notifyDataChange.onDataChanged(parcel);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        parcelsRef.addChildEventListener(parcelRefChildEventListener);
    }

    private MutableLiveData<PostStatus> statusMessage = new MutableLiveData<>();

    public interface action<T> {
        void onSuccess(T obj);

        void onFailure(Exception exception);

        void onProgress(String status, double percent);
    }

    public interface NotifyDataChange<T> {
        void onDataChanged(T obj);

        void onFailure(Exception exception);
    }

    static DatabaseReference parcelsRef;
    static List<Parcel> parcelsList;

    static {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        parcelsRef = database.getReference("Parcels");
        parcelsList = new ArrayList<>();
    }

    public void addParcelToFirebase(final Parcel parcel) {

        String key = "" + parcel.getParcelId();
        Log.i(TAG, "check log");
        parcelsRef.child(key).setValue(parcel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i(TAG, "Saving success");
                statusMessage.postValue(new PostStatus(PostStatus.savingStatus.SUCCESS));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i(TAG, "Saving failed");
                statusMessage.postValue(new PostStatus(PostStatus.savingStatus.FAILED));
            }
        });

    }

    public MutableLiveData<PostStatus> getStatusMessage() {
        return statusMessage;
    }

}
