package zadok.jct.mydb.Utils;

import androidx.room.TypeConverter;

import zadok.jct.mydb.Entitties.Parcel;

public class RoomConverter {
    @TypeConverter
    public static Parcel.parcelType fromString(String value)
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
    public static String fromParcelType(Parcel.parcelType parcelType)
//public enum parcelType {ENVELOPE,SMALL_PACKAGE,BIG_PACKAGE};

}
