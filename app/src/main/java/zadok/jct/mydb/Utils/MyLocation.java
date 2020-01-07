package zadok.jct.mydb.Utils;

import android.location.Location;

public class MyLocation{
    Location lo;

    public MyLocation(){}
    public MyLocation(Location location)
    {
        lo=location;
    }
    public Location getLo() {
        return lo;
    }

    public void setLo(Location lo) {
        this.lo = lo;
    }
}
