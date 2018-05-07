package Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface WineAndDineDao {

    //INSERT STATEMENTS FOR TABLES
    @Insert
    void insertWine(WineEntity wine);
    @Insert
    void insertWinery(WineryEntity winery);
    @Insert
    void insertFood(FoodEntity food);
    @Insert
    void insertStore(StoreEntity store);
    @Insert
    void insertAddress(AddressEntity address);
    /*
    @Insert
    void insertUser(UserEntity user);
    */

    //SPECIFIC SELECT QUERIES

    //WINE QUERIES
    @Query ("SELECT * FROM wine_table WHERE wine_color= :search")
    List<WineEntity> getAllWineColor(String search);
    @Query ("SELECT * FROM wine_table WHERE wine_varietal= :search")
    List<WineEntity> getWineVarietal(String search);
    @Query ("SELECT * FROM wine_table WHERE wine_name= :search")
    List<WineEntity> getWineName(String search);

    //FOOD QUERIES
    @Query("SELECT * FROM food_table WHERE food_meal_designation= :search")
    List<FoodEntity> getFoodMeal(String search);
    @Query("SELECT * FROM food_table WHERE food_meal_type= :search")
    List<FoodEntity> getFoodType(String search);
    @Query("SELECT * FROM food_table WHERE food_name= :search")
    List<FoodEntity> getFoodName(String search);

    //WINERY QUERIES
    @Query("SELECT * FROM winery_table")
    List<WineryEntity> getWineryName();
}
