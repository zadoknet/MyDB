package zadok.jct.mydb.Entitties;

import android.location.Location;

import com.google.firebase.database.Exclude;

import java.util.Date;


public class Parcel {

    static int currentIdIndex;

    int parcelId;
    public enum parcelType {ENVELOPE,SMALL_PACKAGE,BIG_PACKAGE;};
    private parcelType type;
    private Boolean isFragile;
    public enum parcelWeight{HALF_KG,KG,FIVE_KG,TWENTY_KG;}
    private parcelWeight weight;
    private Location location;
    private String name;
    private Location address;
    private Date date; //*****I need to check this
    private String phoneNumber;
    private String mail;
    public enum parcelStatus{SENT,ACCETED_TAKING_OFFER,ON_THE_WAY,ACCEPTED;}
    private parcelStatus status;
    private String messengerName;

    public static int getCurrentIdIndex() {
        return currentIdIndex;
    }

    public static void setCurrentIdIndex(int currentIdIndex) {
        Parcel.currentIdIndex = currentIdIndex;
    }

    @Exclude
    public int getParcelId() {
        return parcelId;
    }

    public void setParcelId(int parcelId) {
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

    public parcelWeight getWeight() {
        return weight;
    }

    public void setWeight(parcelWeight weight) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public parcelStatus getStatus() {
        return status;
    }

    public void setStatus(parcelStatus status) {
        this.status = status;
    }

    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    //TODO: this constuctor is temporary for testing
    public Parcel(int parcelId, parcelType type, Boolean isFragile, parcelWeight weight, String name, String phoneNumber, String mail, parcelStatus status, String messengerName) {
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
}


/*TODO: Constructors: in the constructor we need to define the idParcel by
the currentIdIndex and do to currentIdIndex++
* *  */


