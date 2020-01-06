package zadok.jct.mydb.Data;

import org.junit.Test;

import zadok.jct.mydb.Entitties.Parcel;

public class firebase_DBMangerTest {
    @Test
    public void addParcelToFirebaseTest()
    {
        Firebase_DBManger fire=new Firebase_DBManger();
        Parcel testParcel=new Parcel(23423, Parcel.parcelType.BIG_PACKAGE,Boolean.TRUE, Parcel.ParcelWeight.FIVE_KG,"zado","9990214","zadoknet@gmail.com", Parcel.parcelStatus.ACCEPTED,"no");
        fire.addParcelToFirebase(testParcel);
    }

}