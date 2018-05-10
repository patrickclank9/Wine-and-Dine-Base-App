package Database;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;
@Entity (tableName = "store_table")
public class StoreEntity {

    @PrimaryKey
    private int store_id;

    @ColumnInfo (name="store_name")
    private String storename;

    @ColumnInfo (name="store_specialty")
    private String storespecialty;

    @ColumnInfo (name="store_address")
    public String storeaddress;

    public String getStoreaddress() {
        return storeaddress;
    }

    public void setStoreaddress(String storeaddress) {
        this.storeaddress = storeaddress;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStorespecialty() {
        return storespecialty;
    }

    public void setStorespecialty(String storespecialty) {
        this.storespecialty = storespecialty;
    }
}
