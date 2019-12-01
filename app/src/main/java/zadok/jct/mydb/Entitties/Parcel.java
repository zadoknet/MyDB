package zadok.jct.mydb.Entitties;

import android.location.Location;

import java.util.Date;

public class Parcel {
    enum parcelType {ENVELOPE,SMALL_PACKAGE,BIG_PACKAGE;};
    private parcelType type;
    enum parcelWeight{HALF_KG,KG,FIVE_KG,TWENTY_KG;}
    private parcelWeight weight;
    private Location location;
    private String name;
    private Location address;
    private Date date; //*****I need to check this
    private String phoneNumber;
    private String mail;
    enum parcelStatus{SENT,ACCETED_TAKING_OFFER,ON_THE_WAY,ACCEPTED;}
    private parcelStatus status;
    private String messengerName;

}



