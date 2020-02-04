package zadok.jct.mydb.Utils;

import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import zadok.jct.mydb.Entitties.Parcel;

public class ParcelToString {
    private List<String[]> myList;
    public ParcelToString(List<Parcel> ParcelLst) {
        for (Parcel parcel : ParcelLst) {
            String[] tmp=new String[4];
            tmp[0]=parcel.getParcelId();
            tmp[1]=parcel.getName();
            tmp[2]=getCompleteAddress(parcel.getTargetLocation().getLat(),parcel.getTargetLocation().getLng());
            tmp[3]=parcel.getPhoneNumber();
            myList.add(tmp);
        }
    }

    public List<String[]> getMyList() {
        return myList;
    }

    //************This function translate from lat/lng location to literal address**********************
    public String getCompleteAddress(double latitude, double longitude) {
        String location = "";
        try {
            //  Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            Geocoder geocoder = new Geocoder(this,new Locale("he")) ;
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                String state, city, zip, street;
                if (address.getAdminArea() != null) {
                    state = address.getAdminArea();
                } else {
                    state = "";
                }
                if (address.getLocality() != null) {
                    city = address.getLocality();
                } else {
                    city = "";
                }
                if (address.getPostalCode() != null) {
                    zip = address.getPostalCode();
                } else {
                    zip = "";
                }

                if (address.getThoroughfare() != null) {
                    street = address.getSubLocality() + "," + address.getThoroughfare();
                } else {
                    street = address.getSubLocality() + "," + address.getFeatureName();
                }
                location = street + "," + city + "," + zip + "," + state;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }
}
