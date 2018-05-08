package Database;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ForeignKey;

import java.util.ArrayList;

@Entity (tableName="food_table")
public class FoodEntity {

    @PrimaryKey (autoGenerate = true)
    private int food_id;

    @ColumnInfo (name="food_name")
    private String foodname;

    @ColumnInfo (name="food_meal_designation")
    private String foodmealdesignation;

    @ColumnInfo (name="food_meal_type")
    private String foodmealtype;

    @ColumnInfo(name="store_ID")
    private String storeid;

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodmealdesignation() {
        return foodmealdesignation;
    }

    public void setFoodmealdesignation(String foodmealdesignation) {
        this.foodmealdesignation = foodmealdesignation;
    }

    public String getFoodmealtype() {
        return foodmealtype;
    }

    public void setFoodmealtype(String foodmealtype) {
        this.foodmealtype = foodmealtype;
    }
}
