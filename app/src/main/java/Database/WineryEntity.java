package Database;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;

    @Entity (tableName="winery_table")
    public class WineryEntity {

        @PrimaryKey
        private int winery_id;

        @ColumnInfo (name="winery_name")
        private String wineryname;

        @ColumnInfo (name="winery_varietals")
        private String wineryvarietals;

        @ColumnInfo (name = "winery_address")
        private String wineryaddress;

        public String getWineryaddress() {
            return wineryaddress;
        }

        public void setWineryaddress(String wineryaddress) {
            this.wineryaddress = wineryaddress;
        }

        public int getWinery_id() {
            return winery_id;
        }

        public void setWinery_id(int winery_id) {
            this.winery_id = winery_id;
        }

        public String getWineryname() {
            return wineryname;
        }

        public void setWineryname(String wineryname) {
            this.wineryname = wineryname;
        }

        public String getWineryvarietals() {
            return wineryvarietals;
        }

        public void setWineryvarietals(String wineryvarietals) {
            this.wineryvarietals = wineryvarietals;
        }
    }
