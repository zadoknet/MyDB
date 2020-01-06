package zadok.jct.mydb.Utils;

import androidx.room.TypeConverter;

import zadok.jct.mydb.Entitties.Parcel;

public class RoomConverter {

    //***for ParcelType enum
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
        switch (parcelType) {
            case ENVELOPE:
                return "ENVELOPE";
            case SMALL_PACKAGE:
                return "SMALL_PACKAGE";
            case BIG_PACKAGE:
                return "BIG_PACKAGE";
            default:
                return null;
        }
    }


    //*******for parcelWeight enum
    @TypeConverter
    public static String fromParcelWeight(Parcel.ParcelWeight parcelWeight)
    {
        return parcelWeight.name();
    }
    @TypeConverter
    public static Parcel.ParcelWeight toParcelWeight(String parcelWeight)
    {
        return Parcel.ParcelWeight.valueOf(parcelWeight);
    }

}
