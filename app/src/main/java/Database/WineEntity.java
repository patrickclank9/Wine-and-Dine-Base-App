package Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;

@Entity (tableName="wine_table")
public class WineEntity {

    @PrimaryKey (autoGenerate = true)
    private int wine_id;

    @ColumnInfo (name="wine_name")
    private String winename;

    @ColumnInfo (name="wine_color")
    private String winecolor;

    @ColumnInfo (name="wine_varietal")
    private String winevarietal;

    @ColumnInfo (name="wine_year")
    private int wineyear;

    @ColumnInfo (name="wine_ABV")
    private float wineABV;

    @ColumnInfo (name="winery_id")
    private int wineryid;

    public int getWineryid() {
        return wineryid;
    }
    public void setWineryid(int wineryid) {
        this.wineryid = wineryid;
    }
    public int getWine_id() {
        return wine_id;
    }
    public void setWine_id(int wine_id) {
        this.wine_id = wine_id;
    }
    public String getWinename() {
        return winename;
    }
    public void setWinename(String winename) {
        this.winename = winename;
    }
    public String getWinecolor() {
        return winecolor;
    }
    public void setWinecolor(String winecolor) {
        this.winecolor = winecolor;
    }
    public String getWinevarietal() {
        return winevarietal;
    }
    public void setWinevarietal(String winevarietal) {
        this.winevarietal = winevarietal;
    }
    public int getWineyear() {
        return wineyear;
    }
    public void setWineyear(int wineyear) {
        this.wineyear = wineyear;
    }
    public float getWineABV() {
        return wineABV;
    }
    public void setWineABV(float wineABV) {
        this.wineABV = wineABV;
    }


}

