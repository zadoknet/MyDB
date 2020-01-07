package zadok.jct.mydb.Utils;

import android.location.Location;

public class MyLocation{
    private Location lo;

    public MyLocation(){}

    public MyLocation(MyLocation location)
    {
        lo=location.getLo();
    }
    public MyLocation(Location location)
    {
        lo=location;
    }
    public Location getLo() {
        return lo;
    }

    public MyLocation(double lat,double lng)
    {
        lo.setLatitude(lat);
        lo.setLongitude(lng);
    }
    public void setLo(Location lo) {
        this.lo = lo;
    }


}
