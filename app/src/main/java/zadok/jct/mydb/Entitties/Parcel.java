package zadok.jct.mydb.Entitties;

import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.database.Exclude;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(tableName = "parcels_table")
public class Parcel {
    private static final String TAG ="ZADOK" ;

    @Override
    public String toString() {
        return "Parcel{" +
                "parcelId=" + parcelId +
                ", name='" + name + '\'' +
                '}';
    }

    static int currentIdIndex;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int parcelId;

    public enum parcelType {ENVELOPE,SMALL_PACKAGE,BIG_PACKAGE;};



    private parcelType type;
    private Boolean isFragile;
    public enum ParcelWeight {HALF_KG,KG,FIVE_KG,TWENTY_KG;}

    private ParcelWeight weight;



    @Ignore
    private Location location;

    private String name;

    @Ignore
    private Location address;


    private Date cameToInhibitorTime; //*****I need to check this

    private String phoneNumber;

    private String mail;
    public enum ParcelStatus {SENT,ACCETED_TAKING_OFFER,ON_THE_WAY,ACCEPTED;}

    @Ignore
    private ParcelStatus status;

    private String messengerName;

    public static int getCurrentIdIndex() {
        return currentIdIndex;
    }

    public static void setCurrentIdIndex(int currentIdIndex) {
        Parcel.currentIdIndex = currentIdIndex;
    }

    @Exclude @NonNull
    public int getParcelId() {
        return parcelId;
    }

    public void setParcelId(@NonNull int parcelId) {
        this.parcelId = parcelId;
    }

    public parcelType getType() {
        return type;
    }

    public void setType(parcelType type) {
        this.type = type;
    }

    public Boolean getFragile() {
        return isFragile;
    }

    public void setFragile(Boolean fragile) {
        isFragile = fragile;
    }

    public ParcelWeight getWeight() {
        return weight;
    }

    public void setWeight(ParcelWeight weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public Date getCameToInhibitorTime() {
        return cameToInhibitorTime;
    }

    public void setCameToInhibitorTime(Date cameToInhibitorTime) {
        this.cameToInhibitorTime = cameToInhibitorTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }


    //TODO: this constuctor is temporary for testing
    public Parcel(int parcelId, parcelType type, Boolean isFragile, ParcelWeight weight, String name, String phoneNumber, String mail, ParcelStatus status, String messengerName) {
        //todo: copy this to the main constructor
        Date cameToInhibitorTime=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Log.i(TAG,formatter.format(cameToInhibitorTime));

        this.parcelId = parcelId;
        this.type = type;
        this.isFragile = isFragile;
        this.weight = weight;
        this.name = name;

        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.status = status;
        this.messengerName = messengerName;


    }



    public Parcel(int parcelId,String _name)
    {
        cameToInhibitorTime=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Log.i(TAG,formatter.format(cameToInhibitorTime));

        this.parcelId=parcelId;
        name=_name;
    }

    public Parcel()
    {}
}


/*TODO: Constructors: in the constructor we need to define the idParcel by
the currentIdIndex and do to currentIdIndex++
* *  */


