package Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "address_table")
public class AddressEntity {

    @PrimaryKey(autoGenerate = true)
    private int address_id;

    @ColumnInfo(name="address_street")
    private String street;

    @ColumnInfo (name="address_city")
    private String city;

    @ColumnInfo (name="address_state")
    private String state;

    @ColumnInfo (name = "address_country")
    private String country;

    @ColumnInfo (name= "address_zipcode")
    private String zipcode;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
