package zadok.jct.mydb.Utils;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import zadok.jct.mydb.Entitties.Parcel;

public class RoomConverter {

    //********************for ParcelType enum***************************************************
    @TypeConverter
    public static Parcel.parcelType toParcelType(String value)
    {
        switch (value){
            case "ENVELOPE":
                return Parcel.parcelType.ENVELOPE;
            case "SMALL_PACKAGE":
                return Parcel.parcelType.SMALL_PACKAGE;
            case "BIG_PACKAGE":
                return Parcel.parcelType.BIG_PACKAGE;
            default:
                return null;
        }
    }
    @TypeConverter
    public static String fromParcelType(Parcel.parcelType parcelType) {
        if (parcelType==null)
            return "";
        switch (parcelType) {
            case ENVELOPE:
                return "ENVELOPE";
            case SMALL_PACKAGE:
                return "SMALL_PACKAGE";
            case BIG_PACKAGE:
                return "BIG_PACKAGE";
            default:
                return "";
        }
    }


    //*******for parcelWeight enum*****************************************************
    @TypeConverter
    public static String fromParcelWeight(Parcel.ParcelWeight parcelWeight)
    {
        if(parcelWeight==null)
            return "";
        return parcelWeight.name();
    }
    @TypeConverter
    public static Parcel.ParcelWeight toParcelWeight(String parcelWeight)
    {
     if(parcelWeight.length()==0)
         return null;
        return Parcel.ParcelWeight.valueOf(parcelWeight);
    }

    //******for Date*******************************************************************
    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }

    //****for ParcelStatus*****************************************************
    @TypeConverter
    public static Parcel.ParcelStatus toParcelStatus(String parcelStatus)
    {
        if(parcelStatus.length()==0)
            return null;
        return Parcel.ParcelStatus.valueOf(parcelStatus);
    }
    @TypeConverter
    public static String fromStatusToString(Parcel.ParcelStatus parcelStatus){
        if(parcelStatus==null)
            return "";
        return parcelStatus.name();
    }

    //*****for MyLocation*******************************************8
    @TypeConverter
    public static String fromMyLcationToString(MyLocation myLocation)
    {
        if (myLocation==null)
            return "";
        return myLocation.getLat()+","+myLocation.getLng();
    }
    @TypeConverter
    public static MyLocation ToMyLocation(String location)
    {
        if (location.length()==0)
            return null;
        //convert the location to arrray
        // the first element is Latitude
        //the second element is longitude
        ArrayList<String> tmp=new ArrayList<>(Arrays.asList(location.split(",")));
        Double lat=Double.parseDouble(tmp.get(0));
        Double lng=Double.parseDouble(tmp.get(1));
        return new MyLocation(lat,lng);
    }
}
